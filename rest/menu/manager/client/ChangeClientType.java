package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;


import rest.core.Outlet;
import rest.core.Client;
import rest.textui.clients.Message;
/**
 * This class implements the command that changes the type of a given client.
 *
 * @version 1.0
 * @author PO
 **/

public class ChangeClientType extends Command<Outlet> {
	/* Number by tests */	
	int sucesso;

	/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public ChangeClientType(Outlet o) {
			super(false, MenuEntry.CHANGE_TYPE, o);
    }

    //**
     //* @see pt.utl.ist.po.ui.Command#execute()
     //**«ß/
  

 /**
	 * Executes the command (Change client type).
	 * 
	 * @throws InvalidOperation
	 */		
	  @Override
    public void execute() throws InvalidOperation {
			Form f = new Form(title());
			/* Receive a client key */				
			InputString email = new InputString(f, Message.reqKey());
			
			/* Receive a new type for that client */			
			InputString type = new InputString(f, Message.reqType());
			f.parse();
			while(true){
				/* check if the type is valid */				
				if((type.value().equals("VEGETARIAN")) || (type.value().equals("OMNIVOROUS")))
					break;
				f = new Form(title());
				type = new InputString(f, Message.reqType());
				f.parse();
			}
			
			/** Check if the client exists in client´s list of outlet.
				* Case true change this client type.
				*/
			for(Client c : entity().getClients()){
					if((email.value().equals(c.getKey()))){
							sucesso = 1;
							c.setType(type.value());
							break;
					}
			}
			if(sucesso == 0)
				/* If client does not exists in client´s list in outlet launch an exception */				
				throw new UnknownKeyException(email.value());
			
	}
}
