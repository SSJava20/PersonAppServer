/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.protocol;

import com.softserve.person.Person;
import java.util.List;

/**
 *
 * @author Nubaseg
 */
public class CommandList implements ICommand {

    private List<Person> persons;

    public int getType() {
        return Command.PERSON_LIST;
    }

    /**
     * @return the persons
     */
    public List<Person> getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
