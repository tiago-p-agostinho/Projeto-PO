package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
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
import rest.textui.clients.Message;
/**
 * This class implements the command that registers a client.
 *
 * @version 1.0
 * @author PO
  **/

public class RegisterClient extends Command<Outlet> {
  
	/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public RegisterClient(Outlet o) {
		super(false, MenuEntry.REGISTER_CLIENT, o);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
  
 /**
	 * Executes the command (register a client).
	 * 
	 * @throws InvalidOperation
	 */			
 @Override
  public void execute() throws InvalidOperation {
		Form f = new Form(title());
		
		/* Receive a client type */
		InputString type = new InputString(f, Message.reqType());
		int i;
		f.parse();
		
		/** Check the client type.
 			* If not expected type repeat the operation until find one expected type.
			*/
		if((type.value().equals(Message.clientTypeVegetarian())) || (type.value().equals(Message.clientTypeOmnivorous()))){
			i=0;
			}
			else
				i=-1;
		while(i!=0){	
			if((type.value().equals(Message.clientTypeVegetarian())) || (type.value().equals(Message.clientTypeOmnivorous()))){
				i=0;
			}
			else{	
				f = new Form(title());
				type = new InputString(f, Message.reqType());
				f.parse();
				}
		}
	f = new Form(title());	
	
	/* Receive a new client´s name */	
	InputString name = new InputString(f, Message.reqName());
	
	/* Receive a new client´s key */	
	InputString email = new InputString(f, Message.reqEmail());
	f.parse();

	/* Check if the client already exists */	
	for(Client c : entity().getClients()){
		if(email.value().equals(c.getKey())){
			throw new DuplicateKeyException(email.value());
		}
	}
	
	/* Creates and saves the new client in client´s list in outlet. */
	Client c = new Client(entity(),name.value(), email.value(), type.value());
	entity().addClient(c);
    }
}
