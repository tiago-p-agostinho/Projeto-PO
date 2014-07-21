package rest.menu.manager.restaurants;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.textui.restaurants.MenuEntry;
import rest.textui.restaurants.Message;
import rest.core.Outlet;
import rest.core.Restaurants;

import java.lang.*;
/**
 * Class <code>ShowAllRestaurants</code> represents a command for listing all registered restaurants.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowAllRestaurants extends Command<Outlet> {
  /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public ShowAllRestaurants(Outlet outlet) {
		super(false, MenuEntry.SHOW_RESTAURANTS, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
		/**
	 * Executes the command (show all restaurants).
	 * 
	 * @throws InvalidOperation
	 */			
	 @Override
    public final void execute() throws InvalidOperation {
		/* Receive a restaurant´s list of outlet. */		
		ArrayList<Restaurants> restaurants = entity().getRestaurants();
		
		/* Sort the restaurant´s list by name */		
		Collections.sort(restaurants);
		Display d = new Display(title());		
	
		/* Show all restaurants sorted by name. */		
		for(Restaurants c : restaurants){
			d.addNewLine(c.toString() + "   " +c.getEmail());
    		}
		d.display();
    }
}
