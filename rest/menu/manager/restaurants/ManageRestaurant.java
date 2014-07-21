package rest.menu.manager.restaurants;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.menu.manager.ManagerMenuBuilder;
import rest.textui.restaurants.MenuEntry;
import rest.textui.restaurants.Message;
import rest.textui.UnknownKeyException;
import rest.core.Outlet;
import rest.core.Restaurants;
import rest.menu.manager.main.OpenRestaurantMenu;
/**
 * Class <code>ManageRestaurant</code> represents a command for openning the restaurant menu for
 * a selected restaurant.
 *
 * @version 1.0
 * @author PO
 **/

public class ManageRestaurant extends Command<Outlet> {
  /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public ManageRestaurant(Outlet outlet) {
		super(false, MenuEntry.OPEN_RESTAURANT_MENU, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
 /**
	 * Executes the command (open restaurant´s menu of outlet).
	 * 
	 * @throws InvalidOperation
	 */	
	 @Override
    public final void execute() throws InvalidOperation {
			/* Number for tests. */			
			int sucesso = 0;
			Form f = new Form();
			
			/* Receives a restaurant identifier */
			InputString name = new InputString(f,Message.reqKey());
			f.parse();
			
			/* Checks if restaurant exists in restaurant´s list in outlet */			
			for(Restaurants r : entity().getRestaurants()){
				if((name.value().compareTo(r.getName()))==0){
					sucesso = 1;
					/* Open menu of restaurant. */					
					ManagerMenuBuilder m = new ManagerMenuBuilder();
					m.openRestaurantMenu(r);
				}
			}
		/* If restaurant does not exist in restaurant´s list throws an exception. */				
		if(sucesso == 0)
				throw new UnknownKeyException(name.value());
		}

}
