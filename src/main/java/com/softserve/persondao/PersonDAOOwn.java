package com.softserve.persondao;

import com.softserve.person.Person;

import java.sql.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 22.04.12
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
public class PersonDAOOwn implements PersonDAO
{
    private Connection connect(String DBName, String user, String pass)
    {
        Connection connection = null;

        try
        {
            Class.forName("org.hsqldb.jdbcDriver");

            connection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:DB/" + DBName, user, pass);

        } catch (ClassNotFoundException e)
        {
            System.err.println("Can't load DB driver.");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e)
        {
            System.err.println("Can't create connection.");
            e.printStackTrace();
            System.exit(1);
        }


        return connection;
    }


    @Override
    public void addPerson(Person person) throws SQLException
    {
        Connection connection = connect("PersonBase", "SA", "");

        Statement statement = connection.createStatement();
        String query = "INSERT INTO Persons (FName, SName, Date, FilePath, Comment) VALUES('" + person.getFirstName()
                + "', '" + person.getLastName() + "', '" + person.getDateOfBirth().toString() + "', '" + person.getFilePath()
                + "', '" + person.getComment() + ")";

        statement.executeUpdate(query);
        statement.close();

        Iterator it = person.getAddress().iterator();

        while (it.hasNext())
        {
            statement = connection.createStatement();
            query = "INSERT INTO Addresses (PersonID, Address) VALUES('" + person.getId() + "', '" + (String) it.next() + ")";

            statement.executeUpdate(query);
            statement.close();
        }

        it = person.getPhone().iterator();
        while (it.hasNext())
        {
            statement = connection.createStatement();
            query = "INSERT INTO Phones (PersonID, Phone) VALUES('" + person.getId() + "', '" + (String) it.next() + ")";

            statement.executeUpdate(query);
            statement.close();
        }

        //close connection
        statement = connection.createStatement();
        query = "SHUTDOWN";
        statement.execute(query);
        statement.close();


    }

    @Override
    public void updatePerson(long person_id, Person person) throws SQLException
    {
        Connection connection = connect("PersonBase", "SA", "");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Persons WHERE ID =" + person_id;
    }

    @Override
    public Person getPersonById(long person_id) throws SQLException
    {
        Connection connection = connect("PersonBase", "SA", "");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Persons WHERE ID =" + person_id;

        ResultSet resultSet = statement.executeQuery(query);

        Person result = new Person();

        result.setId(resultSet.getLong(1));
        result.setFirstName(resultSet.getString(2));
        result.setLastName(resultSet.getString(3));
        result.setDateOfBirth(new java.util.Date(resultSet.getLong(4)));
        result.setFilePath(resultSet.getString(5));
        result.setComment(resultSet.getString(6));

        query = "SELECT * FROM Addresses WHERE PersonID =" + person_id;

        resultSet = statement.executeQuery(query);

        ArrayList<String> adr = new ArrayList<String>();
        while (resultSet.next())
        {
            adr.add(resultSet.getString(3));
        }

        result.setAddress(adr);

        query = "SELECT * FROM Phones WHERE PersonID =" + person_id;

        resultSet = statement.executeQuery(query);

        ArrayList<String> phone = new ArrayList<String>();
        while (resultSet.next())
        {
            phone.add(resultSet.getString(3));
        }

        result.setPhone(phone);

        return result;
    }

    @Override
    public Collection getAllPersons() throws SQLException
    {
        ArrayList<Person> result = new ArrayList<Person>();

        Connection connection = connect("PersonBase", "SA", "");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Persons";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next())
        {
            Person tPerson = new Person();
            tPerson.setId(resultSet.getLong(1));
            tPerson.setFirstName(resultSet.getString(2));
            tPerson.setLastName(resultSet.getString(3));
            tPerson.setDateOfBirth(new java.util.Date(resultSet.getLong(4)));
            tPerson.setFilePath(resultSet.getString(5));
            tPerson.setComment(resultSet.getString(6));

            query = "SELECT * FROM Addresses WHERE PersonID =" + tPerson.getId();

            resultSet = statement.executeQuery(query);

            ArrayList<String> adr = new ArrayList<String>();
            while (resultSet.next())
            {
                adr.add(resultSet.getString(3));
            }

            tPerson.setAddress(adr);

            query = "SELECT * FROM Phones WHERE PersonID =" + tPerson.getId();

            resultSet = statement.executeQuery(query);

            ArrayList<String> phone = new ArrayList<String>();
            while (resultSet.next())
            {
                phone.add(resultSet.getString(3));
            }

            tPerson.setPhone(phone);

            result.add(tPerson);
        }

        return result;
    }

    @Override
    public void deletePerson(long id) throws SQLException
    {
        Connection connection = connect("PersonBase", "SA", "");
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Persons Where ID=" +id;
    }
}
