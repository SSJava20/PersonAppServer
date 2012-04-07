/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.persondao;

import com.softserve.person.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Nubaseg
 */
public class PersonDAO {

    Session session;

    public PersonDAO(Session session) {
        this.session = session;
    }

    public void addPerson(Person person) {
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }

    public void delPerson(Long id) {
        session.beginTransaction();
        Person tmpPerson = (Person) session.get(Person.class, id);;
        session.delete(tmpPerson);
        session.getTransaction().commit();
    }

    public Person getPersonById(Long id) {
        Person person = null;
        person = (Person) session.get(Person.class, id);
        return person;
    }

    public void updatePerson(Person person) throws SQLException {
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
    }

    public List<Person> getPersonList() {
        List<Person> persons = new ArrayList<Person>();
        persons = session.createCriteria(Person.class).list();
        return persons;
    }
}
