package org.courses.core.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person
{
    private long id;
    @NotNull(message = "Name is required")
    @Size(min = 3, message = "Name size must be more than 3")
    private String firstName;
    @NotNull(message = "Last name is requires")
    @Size(min = 3, message = "Last name size must be more than 3")
    private String lastName;
    private Date dateOfBirth;
    @Valid
    private ArrayList<Email> email;
    private String photoFilePath;
    private byte[] photo;
    private String filePath;
    private byte[] fileData;
    @Valid
    private ArrayList<Phone> phone;
    private ArrayList<String> m_address;
    private String comment;

    public static Set<String> validate(Object object, Validator validator)
    {
        HashSet<String> errors = new HashSet<String>();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        for (ConstraintViolation<Object> cv : constraintViolations)
        {
            errors.add(cv.getMessage());
        }
        return errors;
    }
      public long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the email
     */
    public ArrayList<Email> getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(ArrayList<Email> email)
    {
        this.email = email;
    }

    /**
     * @return the photoFilePath
     */
    public String getPhotoFilePath()
    {
        return photoFilePath;
    }

    /**
     * @param photoFilePath the photoFilePath to set
     */
    public void setPhotoFilePath(String photoFilePath)
    {
        this.photoFilePath = photoFilePath;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto()
    {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    /**
     * @return the filePath
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * @return the fileData
     */
    public byte[] getFileData()
    {
        return fileData;
    }

    /**
     * @param fileData the fileData to set
     */
    public void setFileData(byte[] fileData)
    {
        this.fileData = fileData;
    }

    /**
     * @return the phone
     */
    public ArrayList<Phone> getPhone()
    {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(ArrayList<Phone> phone)
    {
        this.phone = phone;
    }

    /**
     * @return the m_address
     */
    public ArrayList<String> getM_address()
    {
        return m_address;
    }

    /**
     * @param m_address the m_address to set
     */
    public void setM_address(ArrayList<String> m_address)
    {
        this.m_address = m_address;
    }

    /**
     * @return the comment
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
//package org.courses.core.domain;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validator;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//public class Person {
//
//    public Person() {
//    }
//
//    public Person(String aFirstName, String aLastName, Date date, String phone,
//            String email, String imgPath1, String filePath, String comment) {
//        setFirstName(aFirstName);
//        setLastName(aLastName);
//        setEmail(email);
//        setDate(date);
//        setPhone(phone);
//        setImgFilePath(filePath);
//        setFilePath(filePath);
//        setComment(comment);
//    }
//
//    public void setImgFilePath(String imgFilePath) {
//        this.imgFilePath = imgFilePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public void loadFileData() {
//        try {
//            if (filePath == null) {
//                return;
//            }
//            File file = new File(filePath);
//            FileInputStream fileInputStream = new FileInputStream(file);
//
//            fileData = new byte[(int) file.length()];
//            fileInputStream.read(fileData);
//        } catch (Exception e) {
//            // System.err.println("Fail to load file data " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public void loadImageData() {
//        try {
//            if (imgFilePath == null) {
//                return;
//            }
//            File file = new File(imgFilePath);
//            FileInputStream fileInputStream = new FileInputStream(file);
//
//            imageData = new byte[(int) file.length()];
//            fileInputStream.read(imageData);
//        } catch (Exception e) {
//            // System.err.println("Fail to load image data " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public byte[] getImgData() {
//        return imageData;
//    }
//
//    public byte[] getFileData() {
//        return fileData;
//    }
//
//    public void setImgData(byte[] imgArr) {
//        imageData = imgArr;
//    }
//    private int id;
//   
//    private String firstName;
//
//    private String lastName;
//   
//    private String phone;
//    
//    private String email;
//    private String comment;
//    private byte imageData[];
//    private byte fileData[];
//    private String imgFilePath;
//    private String filePath;
//    private Date date;
//
//    public static Set<String> validate(Object object, Validator validator) {
//        HashSet<String> errors = new HashSet<String>();
//        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
//        for (ConstraintViolation<Object> cv : constraintViolations) {
//            errors.add(cv.getMessage());
//        }
//        return errors;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int iD) {
//        id = iD;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getImgFilePath() {
//        imageData = getImgData();
//        return imgFilePath;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//}
// NEW 

    /**
     * @return the id
     */
  