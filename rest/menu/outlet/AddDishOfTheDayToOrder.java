package rest.menu.outlet; 

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;


import rest.textui.UnknownKeyException;
import rest.textui.outlet.InvalidKeyException;
import rest.textui.outlet.MenuEntry;
import rest.textui.outlet.Message;
import rest.textui.outlet.NotAdequateException;
import rest.core.*;

/**
 * This class implements the command that adds a dish to the order of a client.
 *
 * @version 1.0
 * @author PO
 **/

public class AddDishOfTheDayToOrder extends Command<Outlet> {
   
	/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	 public AddDishOfTheDayToOrder(Outlet outlet) {
			super(false, MenuEntry.ADD_TO_BASKET, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   

 /**
	 * Executes the command (open food´s menu of outlet).
	 * 
	 * @throws InvalidOperation
	 */		
	 @Override
    public void execute() throws InvalidOperation {
			int noDishes=0;	
			Form f = new Form(title());
			
			/* Receive a client key */		
			InputString email = new InputString(f, Message.reqClientId());
			
			/* Receive a name of dish */	
			InputString dishName = new InputString(f, Message.reqDishOfTheDayName());

			/* Receive a number of dishes to order */				
			InputInteger quantity = new InputInteger(f, Message.reqQuantity());
			f.parse();
			
			/* Creates a list of dishes of the day */			
			ArrayList<DishOfTheDay> dishes = new ArrayList<DishOfTheDay>();
			Client client = null;
			DishOfTheDay disDay = null;	
			boolean exists = false;
			boolean clientExist = false;
			for(Client c : entity().getClients()){
				/** Check if the client exists in client´s list of outlet.*/
				if(email.value().equals(c.getKey())){
					client = c;
					clientExist = true;
					break;
				}
			}
			if(clientExist){
				String type = client.getType();
				
			/* Receives the restaurant´s list in outlet */				
			ArrayList<Restaurants> rest = entity().getRestaurants();
				/* Sorts the restaurant´s list by name */			
				Collections.sort(rest);
				for(Restaurants r : rest){
					for(DishOfTheDay d : r.getDishes()){
						/* Checks if dish is available and there is in a restaurant*/
						if((d.getAvailable())&&(dishName.value().equals(d.getName()))){
							/* Checks client´s type and food´s class */
							if((type.equals("OMNIVOROUS"))||((type.equals("VEGETARIAN"))&&(d.getClasses().equals("VEG")))){
								disDay=d;						
								dishes.add(disDay);
								++noDishes;
								exists = true;
								break;		
							} else 
								/* Throws an exception if can not find dish or client */									
								throw new NotAdequateException(dishName.value(),email.value());
						}
					}
				}
				if(exists){		
					if(noDishes>1){
						Display d = new Display();
						boolean exist = false;
						for(DishOfTheDay dish : dishes){
							/* Calculates the price of each dish with discount */ 							
							double finalPrice = dish.getPrice() - dish.getPrice()*dish.getDiscount()*0.01;
							/* Shows restaurant, final price and quantity ordered. */							
							d.addNewLine(dish.getRestaurantName()+"|"+(int)finalPrice+"|"+dish.getQuantity());
						}			
						d.display();
						f = new Form(title());
	
						/* Receives a restautant name */						
						InputString resName = new InputString(f, Message.reqRestId());
						f.parse();
						Restaurants res = null;
						
						for(DishOfTheDay r : dishes){
							/* Checks if the restaurant has a dish of the day*/							
							if(resName.value().equals(r.getRestaurantName())){
								disDay = r;
								exist = true;
								/* Checks if restaurant exists in restaurant´s list of outlet */								
								for(Restaurants re : rest){
									if(resName.value().equals(re.getName())){
										res = re;	
										break;
									}
								} 
							}				
						}	
						if(!exist){
							double lowPrice = 1000;	
					
							for(DishOfTheDay di : dishes){
								/* Updates the price of dish of the day */	
								if(lowPrice > di.getFinalPrice(quantity.value())){
									lowPrice = di.getFinalPrice(quantity.value());
									disDay = di;
									
								}						
							}
							
							for(Restaurants r : rest){
								/* If restaurant has a dish add a order to client´s order list */ 
								if(disDay.getRestaurantName().equals(r.getName())){
									client.addOrder(new Orders(disDay,r,disDay.getFinalPrice(quantity.value()),quantity.value()));
								}
							}
						}else{
							for(DishOfTheDay di : dishes){
								/* If the received name is equal to restaurant of dish, add a order to client´s order list */							
								if(resName.value().equals(di.getRestaurantName())){
									client.addOrder(new Orders(disDay,res,disDay.getFinalPrice(quantity.value()),quantity.value()));
									break;		
								}
							}
						}
					} else {
						Restaurants resi = null;		
						for(Restaurants r : entity().getRestaurants()){
							/* If restaurant´s are the same add a order to client´s order list */							
							if(disDay.getRestaurantName().equals(r.getName())){
								resi=r;
							}
						}
						client.addOrder(new Orders(disDay,resi,disDay.getFinalPrice(quantity.value()),quantity.value()));		
					}		
					entity().setExecutado(true);
					/* Throws exceptions */				
				}else throw new InvalidKeyException(dishName.value());
			}else throw new UnknownKeyException(email.value());
	}
			
}
