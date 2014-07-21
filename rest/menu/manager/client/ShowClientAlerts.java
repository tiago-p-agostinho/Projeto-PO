package rest.menu.manager.client;

/**
 * This class implements the command that shows all alerts for a given client.
 *
 * @version 1.0
 * @author PO
  **/

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;

import rest.textui.UnknownKeyException;
import rest.textui.DuplicateKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

import rest.core.Outlet;
import rest.core.Client; 
import rest.core.ClientMessage;

public class ShowClientAlerts extends Command<Outlet> {
	
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public ShowClientAlerts(Outlet o) {
	super(false, MenuEntry.SHOW_ALERTS, o);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
 
 /**
	 * Executes the command (show client alerts).
	 * 
	 * @throws InvalidOperation
	 */	
 @Override
	public void execute() throws InvalidOperation {
		
		Form f = new Form(title());
		/* Receives a Client key */		
		InputString key = new InputString(f, Message.reqKey());
		f.parse();
		
		Client client = null;
		/* number by tests */			
		int sucesso = 0;
		
		/* check if client already exists */		
		for(Client c: entity().getClients()){
			if((c.getKey().equals(key.value()))){
				sucesso = 1;		
				client = c;
				break;
			}
		}
		/* If client´s already exists... */		
		if(sucesso == 1) {
			/* Get the client´s message list */			
			ArrayList<ClientMessage> cm = client.getMessageList();		
			
			/* Display all client´s message */
			Display dis = new Display();				
			for(ClientMessage cmsg : cm){
				dis.addNewLine(cmsg.toString());
			}
			dis.display();
			/* If client does not exists in client´s list in outlet launch an exception */		
		}else throw new UnknownKeyException(key.value());
	}
}




