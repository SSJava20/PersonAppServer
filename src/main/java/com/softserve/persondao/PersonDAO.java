package com.softserve.persondao;

import com.softserve.person.Person;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 19.02.12
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public interface PersonDAO
{
    public void addPerson(Person person) throws SQLException;
    public void updatePerson(long person_id, Person person) throws SQLException;
    public Person getPersonById(long person_id) throws SQLException;
    public Collection getAllPersons() throws SQLException;
    public void deletePerson(long id) throws SQLException;
}
