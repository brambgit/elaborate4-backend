package elaborate.editor.model.orm.service;

/*
 * #%L
 * elab4-backend
 * =======
 * Copyright (C) 2011 - 2014 Huygens ING
 * =======
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import nl.knaw.huygens.facetedsearch.SolrUtils;
import nl.knaw.huygens.jaxrstools.exceptions.InternalServerErrorException;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import elaborate.editor.model.AbstractStoredEntity;
import elaborate.editor.model.orm.Project;
import elaborate.editor.model.orm.StorableSearchData;
import elaborate.editor.model.orm.User;
import elaborate.editor.solr.ElaborateEditorSearchParameters;
import elaborate.util.ResourceUtil;

@Singleton
public class SearchService extends AbstractStoredEntityService<StorableSearchData> {
	private static final SearchService instance = new SearchService();
	ProjectService projectService = ProjectService.instance();

	private SearchService() {}

	public static SearchService instance() {
		return instance;
	}

	public StorableSearchData createSearch(ElaborateEditorSearchParameters elaborateSearchParameters, User user) {
		beginTransaction();
		projectService.setEntityManager(getEntityManager());
		Project project = projectService.getProjectIfUserIsAllowed(elaborateSearchParameters.getProjectId(), user);
		String level1 = project.getLevel1();
		String level2 = project.getLevel2();
		String level3 = project.getLevel3();
		if (!elaborateSearchParameters.isLevelFieldsSet()) {
			elaborateSearchParameters.setLevelFields(level1, project.getLevel2(), project.getLevel3());
		}
		if (elaborateSearchParameters.getSearchInTranscriptions() && elaborateSearchParameters.getTextLayers().isEmpty()) {
			elaborateSearchParameters.setTextLayers(ImmutableList.copyOf(project.getTextLayers()));
		}
		Set<String> resultFields = Sets.newHashSet(elaborateSearchParameters.getResultFields());
		addIfNotEmpty(resultFields, level1);
		addIfNotEmpty(resultFields, level2);
		addIfNotEmpty(resultFields, level3);
		elaborateSearchParameters//
				.setFacetFields(project.getFacetFields())//
				.setResultFields(resultFields)//
				.setFacetInfoMap(project.getFacetInfoMap());
		try {
			Map<String, Object> result = getSolrServer().search(elaborateSearchParameters);
			StorableSearchData storableSearchData = new StorableSearchData().setResults(result);
			persist(storableSearchData);
			commitTransaction();
			return storableSearchData;

		} catch (Exception e) {
			e.printStackTrace();
			if (getEntityManager().getTransaction().isActive()) {
				rollbackTransaction();
			}
			LOG.error(e.getMessage());
			LOG.error("e={}", e);
			throw new InternalServerErrorException(e.getMessage());
		}
	}

	private void addIfNotEmpty(Set<String> resultFields, String level1) {
		if (StringUtils.isNotEmpty(level1)) {
			resultFields.add(level1);
		}
	}

	public Map<String, Object> getSearchResult(long projectId, long searchId, int start, int rows, User user) {
		Map<String, Object> resultsMap = Maps.newHashMap();
		//    try {
		openEntityManager();
		StorableSearchData storableSearchData = find(StorableSearchData.class, searchId);
		checkEntityFound(storableSearchData, searchId);
		Project project = getEntityManager().find(Project.class, projectId);
		String[] projectEntryMetadataFieldnames = project.getProjectEntryMetadataFieldnames();
		Map<String, String> fieldnameMap = Maps.newHashMap();
		for (String fieldName : projectEntryMetadataFieldnames) {
			fieldnameMap.put(SolrUtils.facetName(fieldName), fieldName);
		}
		closeEntityManager();

		if (storableSearchData != null) {
			List<String> sortableFields = Lists.newArrayList("id", "name");
			sortableFields.addAll(ImmutableList.copyOf(project.getFacetFields()));

			resultsMap = storableSearchData.getResults();

			List<String> ids = (List<String>) resultsMap.remove("ids");
			List<Map<String, Object>> results = (List<Map<String, Object>>) resultsMap.remove("results");

			int lo = ResourceUtil.toRange(start, 0, ids.size());
			int hi = ResourceUtil.toRange(lo + rows, 0, ids.size());
			results = results.subList(lo, hi);
			groupMetadata(results, fieldnameMap);

			resultsMap.put("ids", ids);
			resultsMap.put("results", results);
			resultsMap.put("start", lo);
			resultsMap.put("rows", hi - lo);

			resultsMap.put("sortableFields", sortableFields);
		}
		return resultsMap;
	}

	private void groupMetadata(List<Map<String, Object>> results, Map<String, String> fieldnameMap) {
		for (Map<String, Object> resultmap : results) {
			Map<String, String> metadata = Maps.newHashMap();
			List<String> keys = ImmutableList.copyOf(resultmap.keySet());
			for (String key : keys) {
				if (key.startsWith(SolrUtils.METADATAFIELD_PREFIX)) {
					Object valueObject = resultmap.remove(key);
					String name = fieldnameMap.get(key);
					if (name != null) {
						if (valueObject == null) {
							metadata.put(name, SolrUtils.EMPTYVALUE_SYMBOL);
						} else if (valueObject instanceof List) {
							List<String> values = (List<String>) valueObject;
							if (values.isEmpty()) {
								metadata.put(name, SolrUtils.EMPTYVALUE_SYMBOL);
							} else if (values.size() == 1) {
								metadata.put(name, values.get(0));
							} else if (values.size() > 1) {
								LOG.warn("unexpected: multiple values: {}", values);
								metadata.put(name, values.get(0));
							}
						}
					}
				}
			}
			//			LOG.info("metadata:{}", metadata);
			resultmap.put("metadata", metadata);
		}
	}

	public void removeExpiredSearches() {
		String cutoffDate = new DateTime().minusDays(1).toString("YYYY-MM-dd HH:mm:ss");
		beginTransaction();
		getEntityManager()//
				.createQuery("delete StorableSearchData where created_on < '" + cutoffDate + "'")//
				.executeUpdate();
		commitTransaction();
	}

	@Override
	Class<? extends AbstractStoredEntity<?>> getEntityClass() {
		return StorableSearchData.class;
	}

	@Override
	String getEntityName() {
		return "SearchData";
	}
}
