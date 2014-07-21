package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;


import rest.core.Outlet;
import rest.menu.manager.ManagerMenuBuilder;
/**
 * Class <code>OpenSearchMenu</code> represents a command to the search menu.
 *
 * @version 1.0
 * @author PO
 **/

public class OpenSearchMenu extends Command<Outlet> {
    /**
     */
    public OpenSearchMenu(Outlet o) {
	super(false, MenuEntry.MENU_SEARCH, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    @Override
    public final void execute() throws InvalidOperation {
	ManagerMenuBuilder m = new ManagerMenuBuilder();
	m.openSearchMenu(entity());
    }
}
