package rest.menu.manager.search;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.search.MenuEntry;
import rest.textui.search.Message;
import java.util.ArrayList;
import rest.core.Outlet;
import rest.core.Client;
/**
 * Class <code>ShowClientsWithoutAlerts</code> represents a command for listing all
 * clients without any alert.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowClientsWithoutAlerts extends Command<Outlet> {
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public ShowClientsWithoutAlerts(Outlet o) {
	super(false, MenuEntry.SHOW_CLIENTS_WITHOUT_ALERTS, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command (show clients without alerts).
	 * 
	 * @throws InvalidOperation
	 */		
		@Override
    public final void execute() {
		Display d = new Display();		
		for(Client c : entity().getClients()){
			/* display all clients that have empty their message´s list */						
			if(c.getMessageList().isEmpty()){
				d.addNewLine(c.toString());
			}
		}
		d.display();
   }
}

