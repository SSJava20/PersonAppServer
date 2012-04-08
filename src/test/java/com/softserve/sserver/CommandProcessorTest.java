/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.sserver;

import com.softserve.person.Person;
import com.softserve.persondao.HibernateUtil;
import com.softserve.persondao.PersonDAO;
import com.softserve.protocol.Command;
import com.softserve.protocol.CommandList;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Nubaseg
 */
public class CommandProcessorTest {
    
    private PersonDAO personDAO;
    private SocketThread sthread;
    private Person person;
    private Long testid;
    private List<Person> persons = new ArrayList<Person>();
    
    public CommandProcessorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        personDAO = Mockito.mock(PersonDAO.class);
        sthread = Mockito.mock(SocketThread.class);
        
        person = new Person();
        person.setFirstName("Roman");
        person.setLastName("Kostyrko");
        person.setEmail("nubaseg@gmail.com");
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of operateCommand method, of class CommandProcessor.
     */
    @Test
    public void testOperateCommand() throws Exception {
        CommandList cl = new CommandList();
        Command com = new Command(cl);
        String s = com.serialize();
        String strCommand = "";
        CommandProcessor processor = new CommandProcessor(sthread);
        processor.setPersonDAO(personDAO);
        processor.operateCommand(s);
        Mockito.verify(sthread).sendCommand(s);
        Mockito.verify(personDAO).getPersonList();
    }
}
