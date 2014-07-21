package rest.menu.manager.search;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import java.util.ArrayList;
import rest.textui.search.MenuEntry;
import rest.textui.search.Message;
import rest.core.Orders;
import rest.core.Client;
import rest.core.Outlet;
/**
 * Class <code>ShowClientsWithClosedOrders</code> represents a command for listing all clients
 *  without any orders.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowClientsWithClosedOrders extends Command<Outlet> {
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public ShowClientsWithClosedOrders(Outlet o) {
	super(false, MenuEntry.SHOW_CLIENTS_WITHOUT_ORDERS, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command (show clients with closed orders).
	 * 
	 * @throws InvalidOperation
	 */				
		@Override
    public final void execute() {
			Display d = new Display();
			for(Client c: entity().getClients()){
				/* display all clients that have empty their order´s list */
				if(c.getTemporaryOrders().isEmpty()){
					d.addNewLine(c.toString());
				}
			}
			d.display();
		}
}
