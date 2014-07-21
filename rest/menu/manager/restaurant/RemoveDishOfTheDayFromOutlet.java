package rest.menu.manager.restaurant;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;


import rest.textui.restaurant.InvalidKeyException;
import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;
import rest.core.Restaurants;
import rest.core.DishOfTheDay;

/**
 * Class <code>RemoveDishOfTheDayFromOutlet</code> is a command for removing
 * a selected dish to the dishes of the day of the outlet.
 *
 * @version 1.0
 * @author PO
 **/

public class RemoveDishOfTheDayFromOutlet extends Command<Restaurants> {
    /**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
	public RemoveDishOfTheDayFromOutlet(Restaurants restaurants) {
		super(false, MenuEntry.MAKE_UNAVAILABLE, restaurants);
   	 }	
    
   	 /**
    	* @see pt.utl.ist.po.ui.Command#execute()
    	 **/
	
	 /**
	 * Executes the command (unavailable a dish of the day in outlet).
	 * 
	 * @throws InvalidOperation
	 */	
	@Override
	public final void execute() throws InvalidOperation {
		/* Number for tests */		
		int i = 0;
		Form f = new Form(title());
		
		/* Receives a food identifier */			
		InputString name = new InputString(f, Message.reqKey());
		f.parse();
		
	/* Checks if dish exists in food´s list of restaurant.*/ 
		for(DishOfTheDay d : entity().getDishes()){
		/* If dish of the day exists, change their status to unvailable */			
		if((d.getName().compareTo(name.value()))==0){
				d.setAvailable(false);
				i=1;
				break;
			}
		}
		/* If the dish of the day does not exist in restaurant throws an exception. */		
		if(i==0)
			throw new InvalidKeyException(name.value());
   	 }	
}
