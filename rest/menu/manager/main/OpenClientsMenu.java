package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.clients.MenuEntry;
import rest.textui.clients.Message;

import rest.menu.manager.ManagerMenuBuilder;
import rest.core.Outlet;
/**
 * Class <code>OpenClientsMenu</code> represents a command to open the client menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenClientsMenu extends Command<Outlet> {
     /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
    public OpenClientsMenu(Outlet o) {
	super(false, MenuEntry.TITLE, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    

 /**
	 * Executes the command (open client´s menu of outlet).
	 * 
	 * @throws InvalidOperation
	 */	
	@Override
	public final void execute() {
		
		/* Open the client´s menu of outlet. */	
		ManagerMenuBuilder m = new ManagerMenuBuilder();
		m.openClientMenu(entity());
		}
}
