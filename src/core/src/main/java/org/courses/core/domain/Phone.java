/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.core.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author NGAL
 */
public class Phone
{

    @NotNull(message = "Phone is required")
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "phone is invalid")
    private String m_phone;

    public Phone(String phone)
    {
        m_phone = phone;
    }

    /**
     * @return the m_phone
     */
    public String getM_phone()
    {
        return m_phone;
    }

    /**
     * @param m_phone the m_phone to set
     */
    public void setM_phone(String m_phone)
    {
        this.m_phone = m_phone;
    }
}
