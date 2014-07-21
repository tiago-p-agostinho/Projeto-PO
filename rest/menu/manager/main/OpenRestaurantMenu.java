package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;

import rest.menu.manager.ManagerMenuBuilder;
import rest.core.Outlet;
import rest.core.Restaurants;

public class OpenRestaurantMenu extends Command<Restaurants> {

    /**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
	public OpenRestaurantMenu(Restaurants restaurant){
		super(false, MenuEntry.TITLE, restaurant);
	}

		 /**
	 * Executes the command (open restaurant´s menu of a restaurant).
	 * 
	 * @throws InvalidOperation
	 */	
	public final void execute(){
		/* Open the restaurant´s menu of a restaurant. */		
		ManagerMenuBuilder m =new ManagerMenuBuilder();
		m.openRestaurantMenu(entity());
	}	
}
