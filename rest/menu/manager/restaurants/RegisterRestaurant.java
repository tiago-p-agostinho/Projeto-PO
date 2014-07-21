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
import rest.textui.DuplicateKeyException;
import rest.core.Outlet;
import rest.core.Restaurants;
/**
 * Class <code>ManageRestaurant</code> represents a command for registering a new restaurant.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterRestaurant extends Command<Outlet> {
   /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public RegisterRestaurant(Outlet outlet) {
	super(false, MenuEntry.REGISTER_RESTAURANT, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command (Registe a restaurant).
	 * 
	 * @throws InvalidOperation
	 */			
		@Override
    public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		
		/* Receives a restaurant identifier */		
		InputString name = new InputString(f, Message.reqName());
		
		/* Receives a restaurant email */
		InputString email = new InputString(f, Message.reqEmail());
		f.parse();
		
		/* Checks if restaurant already exists in restaurant´s list in outlet. Case true throws an exception. */
		for(Restaurants r : entity().getRestaurants()){
			if(name.value().equals(r.getName()))
				throw new DuplicateKeyException(name.value());
		}
		/* Case restaurant name does not exist in restaurant´s list is created a new restaurant. */		
		entity().addRestaurant(new Restaurants(entity(),name.value(), email.value()));
		}
}
