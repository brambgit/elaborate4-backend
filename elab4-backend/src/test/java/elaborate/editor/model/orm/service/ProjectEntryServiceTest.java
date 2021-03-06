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

import static elaborate.editor.model.orm.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;

import elaborate.editor.AbstractTest;
import elaborate.editor.model.orm.ProjectEntry;
import elaborate.editor.model.orm.User;

public class ProjectEntryServiceTest extends AbstractTest {

	private ProjectEntryService projectEntryService;

	@Before
	public void setUp() throws Exception {
		projectEntryService = ProjectEntryService.instance();
	}

	@After
	public void tearDown() throws Exception {}

	//  @Test
	public void testRead() throws Exception {
		User user = mock(User.class);
		when(user.getId()).thenReturn((long) 1);
		ProjectEntry pe = projectEntryService.read(1, user);
		assertThat(pe).hasId(1);
	}

}
