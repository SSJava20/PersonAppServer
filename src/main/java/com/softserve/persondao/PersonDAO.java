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

    public void addPerson(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delPerson(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Person tmpPerson = getPersonById(id);
            session.delete(tmpPerson);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Person getPersonById(Long id) {
        Session session = null;
        Person person = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            person = (Person) session.get(Person.class, id);
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return person;
    }

    public void updatePerson(Person person) throws SQLException {
        Person ptmp = getPersonById(person.getId());
        ptmp.setFirstName(person.getFirstName());
        ptmp.setLastName(person.getLastName());
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(person);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList() {
        Session session = null;
        List<Person> persons = new ArrayList<Person>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            persons = session.createCriteria(Person.class).list();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return persons;
    }
}
