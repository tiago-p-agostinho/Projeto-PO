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
 * Class <code>OpenFoodMenu</code> represents a command to the food management menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenFoodMenu extends Command<Outlet> {
      /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public OpenFoodMenu(Outlet o) {
		super(false, MenuEntry.MENU_FOOD, o);
		
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    

		 /**
	 * Executes the command (open food´s menu of outlet).
	 * 
	 * @throws InvalidOperation
	 */	
		@Override
    public final void execute() throws InvalidOperation {
		/* Open the food´s menu of outlet. */			
		ManagerMenuBuilder m = new ManagerMenuBuilder();
		m.openFoodMenu(entity());
	}
}
