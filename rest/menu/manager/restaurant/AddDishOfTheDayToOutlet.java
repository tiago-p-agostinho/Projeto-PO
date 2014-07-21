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
import rest.core.Outlet;
import rest.core.DishOfTheDay;
import rest.core.Food;
import rest.core.Client;
import rest.core.ClientMessage;
/**
 * Class <code>AddDishOfTheDayToOutlet</code> is a command for adding
 * a selected dish to the dishes of the day of the outlet.
 *
 * @version 1.0
 * @author PO
 **/

public class AddDishOfTheDayToOutlet extends Command<Restaurants> {
  /**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
    public AddDishOfTheDayToOutlet(Restaurants restaurants) {
			super(false, MenuEntry.MAKE_AVAILABLE, restaurants);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
 /**
	 * Executes the command (available a dish of the day in outlet).
	 * 
	 * @throws InvalidOperation
	 */	
	 @Override
    public final void execute() throws InvalidOperation {
					
			int i = 0;
			Form f = new Form(title());
			/* Receives a food identifier */			
			InputString name = new InputString(f, Message.reqKey());
			f.parse();
		
			DishOfTheDay dish = null;
		/* Checks if dish exists in food´s list of restaurant.*/ 
	for(DishOfTheDay d : entity().getDishes()){
		if((d.getName().equals(name.value()))){
			d.setAvailable(true);
			dish = d;
			i = 1;
			break;	
		}		
	}
	/* If the dish of the day does not exist in restaurant throws an exception. */	
	if(i == 0)
		throw new InvalidKeyException(name.value());
    	
	Outlet outlet = entity().getOutlet();
	/* Inform all clients subscribed in novelty list that was available a new dish of the day. */	
	for(Client c : outlet.getClients()){
		if((c.getAcceptNovelty())&&((c.getType().equals("OMNIVOROUS")) || (c.getType().equals("VEGETARIAN")&&(dish.getClasses().equals("VEG"))))) {
			c.addMessage(new ClientMessage("NOVELTY",dish.getName()));
		}
    	}
	}
}
