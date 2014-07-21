package rest.menu.outlet;

import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import rest.textui.outlet.MenuEntry;
import rest.textui.outlet.Message;
import rest.core.Outlet;
import rest.core.Restaurants;
import rest.core.DishOfTheDay;
/**
 * This class implements the command that shows all dishes of the day available
 * in the outlet
 *
 * @version 1.0
 * @author PO
 **/

public class ShowDishesOfTheDay extends Command<Outlet> {
	
		/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
	public ShowDishesOfTheDay(Outlet outlet) {
		super(false, MenuEntry.SHOW_DISHES_OF_THE_DAY, outlet);
	}	

	/**
	* @see pt.utl.ist.po.ui.Command#execute()
	**/
	
	/**
	 * Executes the command (show dishes of the day).
	 * 
	 * @throws InvalidOperation
	 */	
	@Override
	public void execute() throws InvalidOperation {
		/* Receive a restaurant´s list of outlet */		
		ArrayList<Restaurants> restaurants = entity().getRestaurants();
		Display d = new Display();
		
		/* Creates a new list */
		ArrayList<String> dishes = new ArrayList<String>();
		
		/* Creates a new list */
		ArrayList<DishOfTheDay> dishs = new ArrayList<DishOfTheDay>();
		for(Restaurants r : restaurants){
			/* Receives each restaurant´s dishes */			
			ArrayList<DishOfTheDay> restDish = r.getDishes();
			Collections.sort(restDish);
			/* If the dish is available add a dish to dishs*/			
			for(DishOfTheDay dish : restDish){
				if(dish.getAvailable())
					dishs.add(dish);
			}
		}
		/* Sorts all dishes by name */
		Collections.sort(dishs);
			
		boolean first = true;
		String dName = null;
		for(DishOfTheDay di : dishs){
			if(first){
				dName=di.getName();
				first = false;
				/* String representation */				
				String print = di.getClasses()+"|"+di.getName();
				/* Add a string representation to dishes */				
				dishes.add(print);
			}
			if(!(dName.equals(di.getName()))){
				dName=di.getName();
				/* String representation */				
				String print = di.getClasses()+"|"+di.getName();
				/* Add a string representation to dishes */	
				dishes.add(print);
			}
		} 
	/* Shows all dishes available */	
	for(String s : dishes){
			d.addNewLine(s.toString());
		}
		d.display();	
	}
}
