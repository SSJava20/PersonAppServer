/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.protocol;

/**
 *
 * @author Nubaseg
 */
public class CommandDelete implements ICommand {

    private Long id;

    public int getType() {
        return Command.PERSON_DELETE;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
