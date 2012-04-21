package com.softserve.persondao;

import com.softserve.person.Person;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 22.04.12
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
public class PersonDAOOwn implements PersonDAO
{
    @Override
    public void addPerson(Person person) throws SQLException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updatePerson(int person_id, Person person) throws SQLException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Person getPersonById(int person_id) throws SQLException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection getAllPersons() throws SQLException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deletePerson(Person person) throws SQLException
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
