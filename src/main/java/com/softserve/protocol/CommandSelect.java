/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.protocol;

import com.softserve.person.Person;

/**
 *
 * @author Nubaseg
 */
public class CommandSelect implements ICommand {

    private Long id;
    private Person person;

    public int getType() {
        return Command.PERSON_SELECT;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
