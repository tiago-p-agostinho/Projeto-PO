package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.DuplicateKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.core.Outlet;
import rest.core.Client;

/**
 * This class implements the command that shows all clients registered with this application.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowClients extends Command<Outlet> {
   
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
	 public ShowClients(Outlet o) {
		super(false, MenuEntry.SHOW_ALL_CLIENTS, o);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    

 /**
	 * Executes the command (show all clients).
	 * 
	 * @throws InvalidOperation
	 */	
		@Override
    public void execute() throws InvalidOperation {
			/* Receives the client´s list of outlet */			
			ArrayList<Client> clients = entity().getClients();
			
			/* Sort the client´s list by key */		
			Collections.sort(clients);		
			Display d = new Display();
			
			/* Display all sorted client´s list */			
			for(Client c : clients){
			d.addNewLine(c.toString());
    	}
		d.display();
	}
}
