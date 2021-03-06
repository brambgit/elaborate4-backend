package elaborate.editor.backend;

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


import static elaborate.util.HibernateUtil.beginTransaction;
import static elaborate.util.HibernateUtil.commitTransaction;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import elaborate.editor.model.orm.ProjectEntry;
import elaborate.editor.model.orm.service.ProjectEntryService;
import elaborate.editor.solr.ElaborateSolrIndexer;

public class Indexer {
  private static final int COMMIT_EVERY_N_RECORDS = 100;
  private static final Logger LOG = LoggerFactory.getLogger(Indexer.class);

  @SuppressWarnings("boxing")
  public static void main(String[] args) {
    StopWatch sw = new StopWatch();
    sw.start();
    ElaborateSolrIndexer solr = new ElaborateSolrIndexer();
    solr.clear();
    EntityManager entityManager = beginTransaction();

    ProjectEntryService projectEntryService = ProjectEntryService.instance();
    projectEntryService.setEntityManager(entityManager);
    List<ProjectEntry> projectentries = projectEntryService.getAll();
    int size = projectentries.size();
    LOG.info("indexing {} projectEntries", size);
    int n = 1;
    for (ProjectEntry projectEntry : projectentries) {
      LOG.info("indexing projectEntry {} ({}/{} = {}%)", new Object[] { projectEntry.getId(), n, size, percentage(n, size) });
      solr.index(projectEntry, autoCommit(n));
      n++;
    }
    commitTransaction(entityManager);
    solr.commit();
    sw.stop();
    LOG.info("done in {}", convert(sw.getTime()));
  }

  private static String percentage(int part, int total) {
    return new DecimalFormat("0.00").format((double) (100 * part) / (double) total);
  }

  private static boolean autoCommit(int n) {
    return (n % COMMIT_EVERY_N_RECORDS) == 0;
  }

  public static String convert(long ms) {
    Date date = new Date(ms);
    DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
    return formatter.format(date);
  }

}
