/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.sserver;

import com.google.gson.Gson;
import com.softserve.persondao.PersonDAO;
import com.softserve.protocol.*;
import java.sql.SQLException;

/**
 *
 * @author Nubaseg
 */
public class CommandProcessor {

    SocketThread sthread;
    PersonDAO personDAO;

    public CommandProcessor(SocketThread sthread) {
        this.sthread = sthread;
        personDAO = new PersonDAO();
    }

    private void sendPersonList() {
        CommandList cl = new CommandList();
        cl.setPersons(personDAO.getPersonList());
        Command com = new Command(cl);
        String s = com.serialize();
        sthread.sendCommand(s);
    }

    public void operateCommand(String strCommand) throws SQLException {
        Gson gson = new Gson();
        Command command = Command.deserialize(strCommand);
        System.out.println(strCommand);
        switch (command.getType()) {
            case Command.PERSON_LIST: {
                sendPersonList();
                break;
            }
            case Command.PERSON_ADD: {
                CommandAdd commandList = gson.fromJson(command.getStringData(),
                        CommandAdd.class);
                personDAO.addPerson(commandList.getPerson());
                sendPersonList();
                break;
            }
            case Command.PERSON_DELETE: {
                CommandDelete commandList = gson.fromJson(command.getStringData(),
                        CommandDelete.class);
                personDAO.delPerson(commandList.getId());
                sendPersonList();
                break;
            }
            case Command.PERSON_SELECT: {
                CommandSelect commandList = gson.fromJson(command.getStringData(),
                        CommandSelect.class);

                break;
            }
            case Command.PERSON_UPDATE: {
                CommandUpdate commandList = gson.fromJson(command.getStringData(),
                        CommandUpdate.class);
                personDAO.updatePerson(commandList.getPerson());
                sendPersonList();
                break;
            }
            default: {
            }
        }
    }
}
