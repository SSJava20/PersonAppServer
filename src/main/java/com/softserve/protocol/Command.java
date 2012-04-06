/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.protocol;

import com.google.gson.Gson;

/**
 *
 * @author Nubaseg
 */
public class Command {

    static public final int PERSON_LIST = 1;
    static public final int PERSON_SELECT = 2;
    static public final int PERSON_UPDATE = 3;
    static public final int PERSON_DELETE = 4;
    static public final int PERSON_ADD = 5;
    private String data;
    private int comandType;

    public Command(ICommand o) {
        comandType = o.getType();
        Gson gson = new Gson();
        data = gson.toJson(o);
    }

    public String getStringData() {
        return data;
    }

    static public Command deserialize(String s) {
        Gson gson = new Gson();
        Command com = gson.fromJson(s, Command.class);
        return com;
    }

    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public int getType() {
        return comandType;
    }
}
