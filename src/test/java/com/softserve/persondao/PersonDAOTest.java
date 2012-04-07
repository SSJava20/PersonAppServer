/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.persondao;

import com.softserve.person.Person;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Nubaseg
 */
public class PersonDAOTest {

    public PersonDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPerson method, of class PersonDAO.
     */
    @Test
    public void testAddPerson() {
        org.hibernate.Session session = Mockito.mock(org.hibernate.Session.class);
        PersonDAO pdao = new PersonDAO(session);
        Person person = new Person();
        person.setFirstName("Roman");
        person.setLastName("Kostyrko");
        pdao.addPerson(person);
    }

    /**
     * Test of delPerson method, of class PersonDAO.
     */
    @Test
    public void testDelPerson() {

        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonById method, of class PersonDAO.
     */
    @Test
    public void testGetPersonById() {

        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePerson method, of class PersonDAO.
     */
    @Test
    public void testUpdatePerson() throws Exception {

        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonList method, of class PersonDAO.
     */
    @Test
    public void testGetPersonList() {

        fail("The test case is a prototype.");
    }
}
