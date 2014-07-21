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
 * This class implements the command that subscribes a client.
 *
 * @version 1.0
 * @author PO
 **/

public class SubscribeClient extends Command<Outlet> {

 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
 public SubscribeClient(Outlet o) {
	super(false, MenuEntry.SUBSCRIBE_ALERT_LIST, o);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
  
 /**
	 * Executes the command (subscribe a client in alert´s lists).
	 * 
	 * @throws InvalidOperation
	 */	
  @Override
	public void execute() throws InvalidOperation {
		Form f = new Form(title());
		
		/* Receives an client´s key */		
		InputString key = new InputString(f, Message.reqKey());
		f.parse();
								
		while(true){
			f = new Form(title());
		
			/* Receives an alert type */			
			InputString alert = new InputString(f, Message.reqJoinAlertType());	
			f.parse();
			
			/* Check if the alert type correspond to one expected alert type */  
			if((alert.value().equals(Message.alertTypeDiscount())) || (alert.value().equals(Message.alertTypeNovelty()))){
				
				boolean t=false;		
				for(Client c : entity().getClients()){
						/* Check if client exists in client´s list */
						if((c.getKey().equals(key.value()))){
							t=true;								
							
							/* Check if client want subscribe in discount alert list and does not is registered*/								
							if((alert.value().equals(Message.alertTypeDiscount())) && (!(c.getAcceptDiscount()))){		
								/* Subscribe client in discount alert list */								
								c.setAcceptDiscount(true);
								break;				
							} 
							/* Check if client want subscribe in novelty alert list and does not is registered*/								
							if((alert.value().equals(Message.alertTypeNovelty())) && (!(c.getAcceptNovelty()))){
							/* Subscribe client in novelty alert list */								
								c.setAcceptNovelty(true);
								break;
							}
						}
				}
				/* If client does not exists in client´s list in outlet launch an exception */						
				if(!t)
					throw new UnknownKeyException(key.value());		
				break;
			}		
		}
	}
}
