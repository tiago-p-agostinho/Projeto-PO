package rest.menu.manager.restaurant;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;
import rest.core.Restaurants;
import rest.core.Outlet;
import rest.core.DishOfTheDay;
import rest.core.Food;
import rest.core.Client;
import rest.core.ClientMessage;

/**
 * Class <code>RegisterDishOfTheDay</code> is a command for creating
 * a dish of the day.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterDishOfTheDay extends Command<Restaurants> {
    /**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
    public RegisterDishOfTheDay(Restaurants restaurants) {
			super(false, MenuEntry.CREATE_DISH_OF_THE_DAY, restaurants);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
	 /**
	 * Executes the command (Registe a dish of the day in restaurant).
	 * 
	 * @throws InvalidOperation
	 */		
	 @Override
    public final void execute() throws InvalidOperation {
			/* Number for test */
			int sucesso = 0;
			Form f = new Form(title());
			
			/* Receives the food´s identifier. */		
			InputString food = new InputString(f,Message.reqFoodKey());
			
			/* Receives the food´s quantity. */		
			InputInteger quantity = new InputInteger(f,Message.reqQuantity());
			
			/* Receives the food´s price. */					
			InputInteger price = new InputInteger(f,Message.reqPrice());
			f.parse();
			Outlet outlet = entity().getOutlet();
			DishOfTheDay dish = null;
			
			/* Checks if food exists in food´s list in outlet. Case true creates a new dish of the day. */ 			
			for(Food f1 : outlet.getFood()){
				if((f1.getName().equals(food.value()))){
					sucesso = 1;
					dish = new DishOfTheDay(entity().getName(),f1,quantity.value(),price.value(), 0);
				}
			}
		/* If was created a new dish of the day save it in restauran´s list. Case else throws an exception. */			
		if(sucesso == 1)
				entity().addDish(dish);
			else throw new UnknownKeyException(food.value());
  	}
}
