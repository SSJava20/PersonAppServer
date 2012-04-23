/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.core;

import java.util.ArrayList;
import java.util.Set;
import javax.validation.Validator;
import org.courses.core.domain.Email;
import org.courses.core.domain.Person;
import org.courses.core.domain.Phone;
import org.courses.core.util.ValidatorFactory;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author NGAL
 */
public class ValidatorTest
{

    Validator validator = null;
    Person m_person = null;

//    @Test
    public void trueValidatorTest()
    {
        ArrayList<Phone> phones = new ArrayList<Phone>();
        ArrayList<Email> emails = new ArrayList<Email>();

        phones.add(new Phone("89261234567"));
        phones.add(new Phone("89261234568"));
        
        emails.add(new Email("qwe@qwe.ru"));
        emails.add(new Email("qwe@qwe.domain.ru"));

        String firstName = "Alex";
        String lastName = "Galkovsky";

        m_person.setPhone(phones);
        m_person.setFirstName(firstName);
        m_person.setLastName(lastName);

        validator = ValidatorFactory.getValidator();
        Set<String> errors = Person.validate(m_person, validator);
//        assertEquals(errors.size(), 0);
    }

    @Test
    public void falseValidatorTest()
    {
        ArrayList<Phone> phones = new ArrayList<Phone>();
        ArrayList<Email> emails = new ArrayList<Email>();

        phones.add(new Phone("!@#$%^&**&"));
        phones.add(new Phone("89 263#$123-45-68"));
        
        emails.add(new Email("qw34eq43we.r43u"));
        
        String firstName = "A";
        String lastName = "Ga58_lkovsk$y";

        m_person.setPhone(phones);
        m_person.setM_address(emails);
        m_person.setFirstName(firstName);
        m_person.setLastName(lastName);

        validator = ValidatorFactory.getValidator();
        Set<String> errors = Person.validate(m_person, validator);
        for (String string : errors)
        {
            System.out.println(string);
        }
        assertEquals(errors.size(), 3);
    }

    @Before
    public void setUp()
    {
        m_person = new Person();
    }
}
