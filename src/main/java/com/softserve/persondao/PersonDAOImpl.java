///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.softserve.persondao;
//
//import com.softserve.person.Person;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
///**
// * @author Nubaseg
// */
//public class PersonDAO
//{
//
//    SessionFactory sessionFactory;
//
//    public PersonDAO(SessionFactory sessionFactory)
//    {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public void addPerson(Person person)
//    {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(person);
//        session.getTransaction().commit();
//    }
//
//    public void delPerson(Long id)
//    {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Person tmpPerson = (Person) session.get(Person.class, id);
//        ;
//        session.delete(tmpPerson);
//        session.getTransaction().commit();
//    }
//
//    public Person getPersonById(Long id)
//    {
//        Session session = sessionFactory.openSession();
//        Person person = null;
//        person = (Person) session.get(Person.class, id);
//        return person;
//    }
//
//    public void updatePerson(Person person) throws SQLException
//    {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.update(person);
//        session.getTransaction().commit();
//    }
//
//    public List<Person> getPersonList()
//    {
//        Session session = sessionFactory.openSession();
//        List<Person> persons = new ArrayList<Person>();
//        persons = session.createCriteria(Person.class).list();
//        return persons;
//    }
//}
