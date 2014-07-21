package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;

import rest.menu.manager.ManagerMenuBuilder;
import rest.core.Outlet;
/**
 * Class <code>OpenrestaurantsMenu</code> represents a command to open the restaurant management menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenRestaurantsMenu extends Command<Outlet> {
  /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public OpenRestaurantsMenu(Outlet o) {
	super(false, MenuEntry.MENU_RESTAURANTS, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    
 /**
	 * Executes the command (open restaurant´s menu of outlet).
	 * 
	 * @throws InvalidOperation
	 */	
	@Override
  public final void execute() throws InvalidOperation {
		/* Open the restaurant´s menu of outlet. */			
		ManagerMenuBuilder m = new ManagerMenuBuilder();
		m.openRestaurantsMenu(entity());
    }
}
