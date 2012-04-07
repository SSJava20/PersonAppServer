/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.persondao;

import com.softserve.person.Person;
import java.util.ArrayList;
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

    private org.hibernate.Session sessionMock;
    private org.hibernate.Transaction transactionMock;
    private Person person;
    private Long testid;
    private List<Person> persons = new ArrayList<Person>();

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
        testid = new Long(1);
        sessionMock = Mockito.mock(org.hibernate.Session.class);
        transactionMock = Mockito.mock(org.hibernate.Transaction.class);
        org.hibernate.Criteria criteriaMock = Mockito.mock(org.hibernate.Criteria.class);
        Mockito.when(sessionMock.getTransaction()).thenReturn(transactionMock);
        Mockito.when(sessionMock.get(Person.class, testid)).thenReturn(person);
        Mockito.when(sessionMock.createCriteria(Person.class)).thenReturn(criteriaMock);
        Mockito.when(criteriaMock.list()).thenReturn(persons);
        Person person = new Person();
        person.setFirstName("Roman");
        person.setLastName("Kostyrko");
        person.setEmail("nubaseg@gmail.com");
        persons.add(person);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPerson method, of class PersonDAO.
     */
    @Test
    public void testAddPerson() {
        PersonDAO pdao = new PersonDAO(sessionMock);
        pdao.addPerson(person);
        Mockito.verify(sessionMock).beginTransaction();
        Mockito.verify(sessionMock).save(person);
        Mockito.verify(transactionMock).commit();
    }

    /**
     * Test of delPerson method, of class PersonDAO.
     */
    @Test
    public void testDelPerson() {
        PersonDAO pdao = new PersonDAO(sessionMock);
        pdao.delPerson(testid);
        Mockito.verify(sessionMock).beginTransaction();
        Mockito.verify(sessionMock).get(Person.class, testid);
        Mockito.verify(sessionMock).delete(person);
        Mockito.verify(transactionMock).commit();
    }

    /**
     * Test of getPersonById method, of class PersonDAO.
     */
    @Test
    public void testGetPersonById() {
        PersonDAO pdao = new PersonDAO(sessionMock);
        person = pdao.getPersonById(testid);
        Mockito.verify(sessionMock).get(Person.class, testid);
    }

    /**
     * Test of updatePerson method, of class PersonDAO.
     */
    @Test
    public void testUpdatePerson() throws Exception {
        PersonDAO pdao = new PersonDAO(sessionMock);
        pdao.updatePerson(person);
        Mockito.verify(sessionMock).beginTransaction();
        Mockito.verify(sessionMock).update(person);
        Mockito.verify(transactionMock).commit();
    }

    /**
     * Test of getPersonList method, of class PersonDAO.
     */
    @Test
    public void testGetPersonList() {
        PersonDAO pdao = new PersonDAO(sessionMock);
        persons = pdao.getPersonList();
        Mockito.verify(sessionMock).createCriteria(Person.class);
    }
}
