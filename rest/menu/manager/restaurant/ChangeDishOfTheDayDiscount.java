package rest.menu.manager.restaurant;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputInteger;

import rest.textui.UnknownKeyException;
import rest.textui.restaurant.MenuEntry;
import rest.textui.restaurant.Message;
import rest.textui.UnknownKeyException;
import rest.textui.restaurant.InvalidKeyException;
import rest.core.Restaurants;
import rest.core.DishOfTheDay;
import rest.core.Client;
import rest.core.ClientMessage;
/**
 * Class <code>ChangeDishOfTheDayDiscount</code> is a command for changing
 * the discount of a selected dish to the day.
 *
 * @version 1.0
 * @author PO
 **/

public class ChangeDishOfTheDayDiscount extends Command<Restaurants> {
/**
	 * Constructor.
	 * 
	 * @param restaurant
	 *            object on which the command will be executed
	 */	
	public ChangeDishOfTheDayDiscount(Restaurants restaurants) {
		super(false, MenuEntry.CHANGE_DISCOUNT, restaurants);
	}
    
    	/**
	* @see pt.utl.ist.po.ui.Command#execute()
     	**/
    
	
 /**
	 * Executes the command (change the discount in a dish of the day in restaurant).
	 * 
	 * @throws InvalidOperation
	 */	
		@Override
    public final void execute() throws InvalidOperation {
		/* Number for test */		
		int sucesso = 0;
		
		Form f = new Form (title());
		/* Receives the food´s identifier. */		
		InputString name = new InputString(f, Message.reqKey());
		f.parse();
		DishOfTheDay dish = null;
		
		/* Checks if dish exists in food´s list of restaurant.*/ 
		for(DishOfTheDay d : entity().getDishes()){
			if(d.getName().equals(name.value())){
				sucesso = 1;
				/* Checks if the dish of the day is available. Case false throws an exception. */				
				if(!d.getAvailable())
					throw new InvalidKeyException(name.value());				
				f = new Form (title());
				
				/* Receives a new discount percentage. */				
				InputInteger discount = new InputInteger (f, Message.reqDiscount());
				f.parse();
				
				/* Checks if discount is valid. Case true updates the discount of dish of the day. */				
				if(discount.value()>=0||discount.value()<=100){
					d.setDiscount(discount.value());
					d.setDiscountType(true);
					dish = d;
					entity().setDiscounts(true);
				}	
				break;
			}
		}
		if(sucesso == 1) {
			/* Inform all clients subscribed in discount list that exist a dish of the day with new discount. */			
			for(Client c : entity().getOutlet().getClients()){
				if((c.getAcceptDiscount())&&((c.getType().equals("OMNIVOROUS")) || (c.getType().equals("VEGETARIAN")&&(dish.getClasses().equals("VEG"))))) {
					c.addMessage(new ClientMessage("DISCOUNT",name.value()));
				}
			}
		}else throw new UnknownKeyException(name.value());
	}
}
