package rest.menu.manager.restaurant;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;
import rest.textui.UnknownKeyException;
import rest.core.Restaurants;
import rest.core.DishOfTheDay;
import rest.core.PreparedFood;
/**
 * Class <code>ShowDishOfTheDayCalories</code> is a command for showing
 * the calories of a given dish of the day.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowDishOfTheDayCalories extends Command<Restaurants> {
  /**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
	public ShowDishOfTheDayCalories(Restaurants restaurant) {
		super(false, MenuEntry.COMPUTE_CALORIES, restaurant);
	    }
    
	/**
	* @see pt.utl.ist.po.ui.Command#execute()
	**/
    	
 /**
	 * Executes the command (show the calories of the dish of the day).
	 * 
	 * @throws InvalidOperation
	 */				
		@Override
    public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		
		/* Receives a food identifier */		
		InputString name = new InputString(f, Message.reqKey());
		f.parse();
		
		double calories = -1;
		String print = null;
		
		/* Checks if dish exists in food´s list of restaurant. Case true print dish name and their calories. */ 
		for(DishOfTheDay d : entity().getDishes()){
			if((d.getName().equals(name.value()))){
				calories = d.getCalories();
				print=d.getName()+"|"+(int)calories;
				break;
			}
		}
		if(calories != -1){
			Display s = new Display();
			s.addNewLine(print.toString());
			s.display();
			/* If the dish of the day does not exist in restaurant throws an exception. */		
		}else throw new UnknownKeyException(name.value());
	}
}
