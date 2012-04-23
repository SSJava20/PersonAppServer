/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.courses.core.dao.DAOFactory;
import org.courses.core.dao.IPersonDAO;
import org.courses.core.dao.PersonDAO_SQL;
import org.courses.core.domain.Person;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import sun.print.resources.serviceui;

/**
 *
 * @author NGAL
 */
@RunWith(value = Parameterized.class)
public class PersonDAO_SQLTest
{

    char DAO_type = ' ';
    IPersonDAO DAO = null;
    static MainServer server;

    public PersonDAO_SQLTest(char type)
    {
        System.out.println("Test DAO : " + type);
        this.DAO_type = type;
    }

    @BeforeClass
    public static void setUpServer() throws UnknownHostException, IOException
    {
        server = new MainServer(InetAddress.getByName("localhost"), 3224);
    }

    @After
    public void stopServer()
    {
        server.stop();
    }

    @Before
    public void setUp() throws Exception
    {
        DAO = DAOFactory.getInstance().getPersonDAO(DAO_type);
    }

    /**
     * Test of addPerson method, of class PersonDAO_SQL.
     */
    @Test
    public void testAddPerson() throws Exception
    {
        System.out.println("addPerson");
        Person person = new Person();
        person.setFirstName("FUCK");
        DAO.addPerson(person);
    }

    /**
     * Test of getPersonById method, of class PersonDAO_SQL.
     */
    @Test
    public void testGetPersonById() throws Exception
    {
        System.out.println("getPersonById");
        Person person = new Person();
        person.setFirstName("FUCK");
        DAO.addPerson(person);
        Person newPerson = DAO.getPersonById(person.getId());

        equalPersons(person, newPerson);

    }

    /**
     * Test of getAllPersons method, of class PersonDAO_SQL.
     */
    @Test
    public void testGetAllPersons() throws Exception
    {
        System.out.println("getAllPersons");

        Person p1 = new Person();
        p1.setFirstName("FUCK");
        Person p2 = new Person();
        p2.setFirstName("FUCK2");

        DAO.addPerson(p1);
        DAO.addPerson(p2);

        List<Person> persons = DAO.getAllPersons();

        for (Person person : persons)
        {
            if (person.getId() == p1.getId())
            {
                equalPersons(p1, person);
            } else if (person.getId() == p2.getId())
            {
                equalPersons(p2, person);
            }
        }
    }

    /**
     * Test of deletePerson method, of class PersonDAO_SQL.
     */
    @Test
    public void testDeletePerson() throws Exception
    {
        System.out.println("deletePerson");

        Person p1 = new Person();
        p1.setFirstName("FUCK");
        Person p2 = new Person();
        p2.setFirstName("FUCK2");

        Person newP1 = DAO.getPersonById(p1.getId());
        Person newP2 = DAO.getPersonById(p2.getId());

        assertTrue(newP1 == null);
        assertTrue(newP2 == null);
    }

    private void clearAll() throws SQLException
    {
        ((PersonDAO_SQL) (DAO)).clearAllTables();
    }

    private boolean equalPersons(Person p1, Person p2)
    {
        assertEquals(p1.getId(), p2.getId());
        assertEquals(p1.getFirstName(), p2.getFirstName());
        assertEquals(p1.getLastName(), p2.getLastName());
        assertEquals(p1.getPhotoFilePath(), p2.getPhotoFilePath());
        return true;
    }

    @Parameters
    public static Collection<Object[]> data()
    {
        Object[][] data = new Object[][]
        {
            {
                's'
            },
            {
                'n'
            },
        };
        return Arrays.asList(data);
    }
}
