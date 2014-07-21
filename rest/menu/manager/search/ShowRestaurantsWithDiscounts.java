package rest.menu.manager.search;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.textui.search.MenuEntry;
import rest.textui.search.Message;
import rest.core.DishOfTheDay;
import rest.core.Restaurants;
import rest.core.Outlet;
/**
 * Class <code>ShowRestaurantsWithDiscounts</code> represents a command for listing all
 * restaurants with discouts.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowRestaurantsWithDiscounts extends Command<Outlet> {
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public ShowRestaurantsWithDiscounts(Outlet o) {
	super(false, MenuEntry.SHOW_RESTAURANTS_WITH_DISCOUNTS, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command (show restaurants with discounts).
	 * 
	 * @throws InvalidOperation
	 */	
		@Override
    public final void execute() {
		Display d = new Display();
		/* Receive a restaurant´s list of outlet. */			
		ArrayList<Restaurants> res = entity().getRestaurants();
		
		/* Sort the restaurant´s list by name */		
		Collections.sort(res);			
		for(Restaurants r: res){
			/* Shows the restaurant if it have discounts. */			
			if(r.getDiscounts())		
				d.addNewLine(r.toString());
			else {
				for(DishOfTheDay dish : r.getDishes()){
					/* Shows the resturant if it have dishes of the day with discounts*/					
						if(dish.getDiscount()>0)
						d.addNewLine(r.toString());
				}
			}
		}
		d.display();
		}
}
