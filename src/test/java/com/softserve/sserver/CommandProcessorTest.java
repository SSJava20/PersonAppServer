/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.sserver;

import com.softserve.person.Person;
import com.softserve.persondao.HibernateUtil;
import com.softserve.persondao.PersonDAO;
import com.softserve.protocol.Command;
import com.softserve.protocol.CommandAdd;
import com.softserve.protocol.CommandDelete;
import com.softserve.protocol.CommandList;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

/**
 *
 * @author Nubaseg
 */
public class CommandProcessorTest {
    
    class IsPerson extends ArgumentMatcher<Person> {
        
        public boolean matches(Object person) {
            return ((Person) person).getFirstName().equals("Roman");
        }
    }

    class IsTrueID extends ArgumentMatcher<Long> {
        
        public boolean matches(Object id) {
            return ((Long) id).equals(testid);
        }
    }
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
        
        testid = new Long(1);
        person = new Person();
        person.setFirstName("Roman");
        person.setLastName("Kostyrko");
        person.setEmail("nubaseg@gmail.com");
        persons.add(person);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of operateCommand method, of class CommandProcessor.
     */
    @Test
    public void testOperateCommandList() throws Exception {
        CommandList incomingCommandList = new CommandList();
        Command incomingCommand = new Command(incomingCommandList);
        String stringCommand = incomingCommand.serialize();
        CommandProcessor processor = new CommandProcessor(sthread);
        processor.setPersonDAO(personDAO);
        processor.operateCommand(stringCommand);
        Mockito.verify(personDAO).getPersonList();
    }
    
    @Test
    public void testOperateCommandAdd() throws Exception {
        CommandAdd incomingCommandAdd = new CommandAdd();
        incomingCommandAdd.setPerson(person);
        Command incomingCommand = new Command(incomingCommandAdd);
        String stringCommand = incomingCommand.serialize();
        CommandProcessor processor = new CommandProcessor(sthread);
        processor.setPersonDAO(personDAO);
        processor.operateCommand(stringCommand);
        Mockito.verify(personDAO).addPerson(Mockito.argThat(new IsPerson()));
    }
    
    @Test
    public void testOperateCommandDel() throws Exception {
        CommandDelete incomingCommandDel = new CommandDelete();
        incomingCommandDel.setId(testid);
        Command incomingCommand = new Command(incomingCommandDel);
        String stringCommand = incomingCommand.serialize();
        CommandProcessor processor = new CommandProcessor(sthread);
        processor.setPersonDAO(personDAO);
        processor.operateCommand(stringCommand);
        Mockito.verify(personDAO).delPerson(Mockito.argThat(new IsTrueID()));
    }
}
