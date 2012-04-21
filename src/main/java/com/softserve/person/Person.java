/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.person;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Nubaseg
 */
public class Person
{

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private ArrayList<String> email;
    private byte[] photo;
    private String filePath;
    private ArrayList<String> phone;
    private String comment;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;

    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * @return the email
     */
    public ArrayList<String> getEmail()
    {
        return email;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto()
    {
        return photo;
    }

    /**
     * @return the filePath
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * @return the phone
     */
    public ArrayList<String> getPhone()
    {
        return phone;
    }

    /**
     * @return the comment
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(ArrayList<String> email)
    {
        this.email = email;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(ArrayList<String> phone)
    {
        this.phone = phone;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
