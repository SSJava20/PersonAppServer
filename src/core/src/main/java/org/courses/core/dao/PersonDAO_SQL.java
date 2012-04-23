/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.core.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.courses.core.domain.Person;
import org.courses.core.domain.Phone;

/**
 *
 * @author NGAL
 */
public class PersonDAO_SQL implements IPersonDAO
{

    private String m_DBName = "";
    private String m_user = "";
    private String m_pass = "";

    public PersonDAO_SQL(String DBName, String user, String pass)
    {
        m_DBName = DBName;
        m_user = user;
        m_pass = pass;
    }

    private Connection connect(String DBName, String user, String pass)
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + DBName, user, pass);

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
        Connection connection = connect(m_DBName, m_user, m_pass);

        PreparedStatement stat = connection.prepareStatement("INSERT INTO Persons (firstname, lastname, dateofbirth, photo, filepath, comment) VALUES(?,?,?,?,?,?)");
        stat.setString(1, person.getFirstName());
        stat.setString(2, person.getLastName());
        stat.setDate(3, null);
        stat.setString(4, person.getPhotoFilePath());
        stat.setString(5, person.getFilePath());
        stat.setString(6, person.getComment());
        stat.execute();

        stat.close();

        if (person.getM_address() != null)
        {
            Iterator<String> itAddress = person.getM_address().iterator();

            while (itAddress.hasNext())
            {
                stat = connection.prepareStatement("INSERT INTO Addresses (PersonID, Address) VALUES(?,?)");
                stat.setLong(1, person.getId());
                stat.setString(2, itAddress.next());
                stat.execute();
                stat.close();
            }

        }
        if (person.getPhone() != null)
        {
            Iterator<Phone> itPhone = person.getPhone().iterator();
            while (itPhone.hasNext())
            {
                stat = connection.prepareStatement("INSERT INTO Phones (PersonID, phone) VALUES(?,?)");
                stat.setLong(1, person.getId());
                stat.setString(2, itPhone.next().getM_phone());
                stat.execute();
                stat.close();
            }
        }
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT MAX(id) max_id FROM Persons");
        rs.next();
        person.setId(rs.getInt("max_id"));
        connection.close();
    }

    @Override
    public void updatePerson(long person_id, Person person) throws SQLException
    {
        Connection connection = connect(m_DBName, m_user, m_pass);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Persons WHERE ID =" + person_id;
    }

    @Override
    public Person getPersonById(long person_id) throws SQLException
    {
        Connection connection = connect(m_DBName, m_user, m_pass);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Persons WHERE ID =" + person_id;

        ResultSet resultSet = statement.executeQuery(query);

        if (!resultSet.next())
        {
            return null;
        }
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

        result.setM_address(adr);

        query = "SELECT * FROM Phones WHERE PersonID =" + person_id;

        resultSet = statement.executeQuery(query);

        ArrayList<Phone> phone = new ArrayList<Phone>();
        while (resultSet.next())
        {
            phone.add(new Phone(resultSet.getString(3)));
        }

        result.setPhone(phone);

        return result;
    }

    @Override
    public List<Person> getAllPersons() throws SQLException
    {
        ArrayList<Person> result = new ArrayList<Person>();

        Connection connection = connect(m_DBName, m_user, m_pass);
        final Statement stat = connection.createStatement();
        String query = "SELECT * FROM Persons";

        final ResultSet rs = stat.executeQuery(query);

        while (rs.next())
        {
            Person tPerson = new Person();
            tPerson.setId(rs.getLong(1));
            tPerson.setFirstName(rs.getString(2));
            tPerson.setLastName(rs.getString(3));
            tPerson.setDateOfBirth(new java.util.Date(rs.getLong(4)));
            tPerson.setFilePath(rs.getString(5));
            tPerson.setComment(rs.getString(6));

            query = "SELECT * FROM Addresses WHERE PersonID =" + tPerson.getId();

            Statement inStat = connection.createStatement();
            ResultSet inResultSet = inStat.executeQuery(query);

            ArrayList<String> adr = new ArrayList<String>();
            while (inResultSet.next())
            {
                adr.add(inResultSet.getString(3));
            }

            tPerson.setM_address(adr);

            query = "SELECT * FROM Phones WHERE PersonID =" + tPerson.getId();

            inResultSet = inStat.executeQuery(query);

            ArrayList<Phone> phone = new ArrayList<Phone>();
            while (inResultSet.next())
            {
                phone.add(new Phone(inResultSet.getString(3)));
            }

            tPerson.setPhone(phone);

            result.add(tPerson);
        }
        connection.close();
        return result;
    }

    @Override
    public void deletePerson(Person person) throws SQLException
    {
        Connection connection = connect(m_DBName, m_user, m_pass);
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Persons Where ID=" + person.getId();
        statement.execute(query);
        connection.close();
    }

    public void clearAllTables() throws SQLException
    {
        Connection connection = connect(m_DBName, m_user, m_pass);
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Persons";
        statement.execute(query);
        query = "DELETE FROM addresses";
        statement.execute(query);
        query = "DELETE FROM phones";
        statement.execute(query);
        connection.close();

    }
}
