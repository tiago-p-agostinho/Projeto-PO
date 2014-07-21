package rest.menu.manager.client;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.textui.UnknownKeyException;
import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;


import rest.core.Outlet;
import rest.core.Client;
/**
 * This class implements the command that unsubscribes a client.
 *
 * @version 1.0
 * @author PO
 **/

public class UnsubscribeClient extends Command<Outlet> {	
    
/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public UnsubscribeClient(Outlet o) {
			super(false, MenuEntry.UNSUBSCRIBE_ALERT_LIST, o);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    

	 /**
	 * Executes the command (unsubscribe clients in alert´s lists.
	 * 
	 * @throws InvalidOperation
	 */	
	@Override
	public void execute() throws InvalidOperation, UnknownKeyException {
			Form f = new Form(title());
			
			/* Receives an client´s key */				
			InputString key = new InputString(f, Message.reqKey());
			f.parse();
				
			f = new Form(title());
			
			/* Receives an alert type */		
			InputString alert = new InputString(f, Message.reqLeaveAlertType());	
			f.parse();
			
			/* Check if the alert type correspond to one expected alert type */  		
			if((alert.value().equals(Message.alertTypeDiscount())) || (alert.value().equals(Message.alertTypeNovelty()))){
				
				for(Client c : entity().getClients()){
					/* Check if client exists in client´s list */
					if(c.getName().equals(key.value())){
				
						/* Check if client want unsubscribe in discount alert list and is registered*/							
						if((alert.value().equals(Message.alertTypeDiscount())) && (c.getAcceptDiscount())){	
						/* Unsubscribe client in discount alert list */									
							c.setAcceptDiscount(false);
							break;				
						} 
						/* Check if client want unsubscribe in novelty alert list and is registered*/						
						if((alert.value().equals(Message.alertTypeNovelty()))&&(c.getAcceptNovelty())){
							/* Unsubscribe client in novelty alert list */								
							c.setAcceptNovelty(false);
							break;
						}
					}
					break;
				}
			}	
	}
}
