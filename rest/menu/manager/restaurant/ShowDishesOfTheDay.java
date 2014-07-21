package rest.menu.manager.restaurant;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;
import rest.core.Restaurants;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.core.DishOfTheDay;
import rest.core.Restaurants;
/**
 * Class <code>ShowDishesOfTheDay</code> is a command for listing all dishes of the day.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowDishesOfTheDay extends Command<Restaurants> {
  /**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
    public ShowDishesOfTheDay(Restaurants restaurants) {
		super(false, MenuEntry.SHOW_DISHES_OF_THE_DAY, restaurants);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command (list all dishes of the day of restaurant).
	 * 
	 * @throws InvalidOperation
	 */			
		@Override
    public final void execute() {
		Display d = new Display(title());
		/* Receives a dishes of the day of restaurant	*/	
		ArrayList<DishOfTheDay> dishes = entity().getDishes();
		
		/* Sort the the dishes of the day	by name */
		Collections.sort(dishes);
		
		/* Show all dishes of the day sorted by name */		
		for(DishOfTheDay dish : dishes)
			d.addNewLine(dish.toString());
		d.display();
	}
    
}
