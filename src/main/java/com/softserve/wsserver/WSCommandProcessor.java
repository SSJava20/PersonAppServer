/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.wsserver;

import com.google.gson.Gson;
import com.softserve.person.Person;
import com.softserve.persondao.HibernateUtil;
import com.softserve.persondao.PersonDAO;
import com.softserve.protocol.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Nubaseg
 */
public class WSCommandProcessor {

    WSThread wsthread;
    PersonDAO personDAO;

    public WSCommandProcessor(WSThread wsthread) {
        this.wsthread = wsthread;
        personDAO = new PersonDAO(HibernateUtil.configureSessionFactory());
    }

    private void sendPersonList() throws IOException {
        CommandList cl = new CommandList();
        cl.setPersons(personDAO.getPersonList());
        Command com = new Command(cl);
        String s = com.serialize();
        System.out.println(s);
        wsthread.sendCommand(s);
    }

    private void sendPersonByID() {
    }

    public void operateCommand(String strCommand) throws SQLException,
            IOException {
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
                CommandSelect commandSel = gson.fromJson(command.getStringData(),
                        CommandSelect.class);
                Long d = commandSel.getId();
                Person p = personDAO.getPersonById(d);
                CommandSelect cl = new CommandSelect();
                cl.setPerson(p);
                Command com = new Command(cl);
                String s = com.serialize();
                System.out.println(s);
                wsthread.sendCommand(s);
                break;
            }
            case Command.PERSON_UPDATE: {
                CommandUpdate commandUpd = gson.fromJson(command.getStringData(),
                        CommandUpdate.class);
                Person p = commandUpd.getPerson();
                personDAO.updatePerson(p);
                sendPersonList();
                break;
            }
            default: {
            }
        }
    }
}
