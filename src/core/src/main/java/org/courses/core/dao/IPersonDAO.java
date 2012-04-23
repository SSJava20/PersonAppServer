package org.courses.core.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.courses.core.domain.Person;

public interface IPersonDAO
{
//
//    void saveOrUpdate(List<Person> persons);
//
//    void saveOrUpdate(Person person);
//
//    Person getPersonById(int ID);
//
//    ArrayList<Person> getPersons();
//
//    void delPerson(Person person);

    public void addPerson(Person person) throws SQLException;

    public void updatePerson(long person_id, Person person) throws SQLException;

    public Person getPersonById(long person_id) throws SQLException;

    public List<Person> getAllPersons() throws SQLException;

    public void deletePerson(Person person) throws SQLException;
}
