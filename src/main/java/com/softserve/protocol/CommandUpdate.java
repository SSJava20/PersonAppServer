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
public class CommandUpdate implements ICommand {

    private Person person;

    public int getType() {
        return Command.PERSON_UPDATE;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
