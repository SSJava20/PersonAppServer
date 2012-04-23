/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.core.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author NGAL
 */
public class Email
{
    @NotNull(message = "Email is required")
    @Pattern(regexp = "^([a-zA-Z0-9]+[\\w.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\w.]*[a-zA-Z0-9]+\u002E[a-zA-Z0-9]{1,4})$", message = "email is invalid")
    private String m_email;

    public Email(String email)
    {
        m_email = email;
    }

    /**
     * @return the m_phone
     */
    public String getM_email()
    {
        return m_email;
    }

    /**
     * @param m_phone the m_phone to set
     */
    public void setM_email(String m_email)
    {
        this.m_email = m_email;
    }
}
