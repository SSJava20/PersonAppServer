/**
 * 
 */
package org.courses.server;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.courses.core.command.AllPersonsCommand;
import org.courses.core.command.Command;
import org.courses.core.dao.DAOFactory;
import org.courses.core.dao.HibernateUtil;
import org.courses.core.dao.IPersonDAO;
import org.courses.core.domain.Person;
import org.courses.core.util.DateConverter;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @author NGAL version 31.03.2012
 */
public class OpenSessionTest {

	@Test
	public void test() throws Exception {
             Session session = HibernateUtil.getSessionFactory().openSession();
	}

}
