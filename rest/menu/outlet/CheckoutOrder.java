package rest.menu.outlet;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.outlet.MenuEntry;
import rest.textui.outlet.Message;
import rest.core.Outlet;
import rest.core.Restaurants;
import rest.core.Orders;
import rest.core.Client;
import rest.core.DishOfTheDay;
/**
 * This class implements the command that finalizes an order.
 *
 * @version 1.0
 * @author PO
 **/

public class CheckoutOrder extends Command<Outlet> {
   
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	 public CheckoutOrder(Outlet outlet) {
			super(false, MenuEntry.CHECKOUT, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   

	 /**
	 * Executes the command (the client pay).
	 * 
	 * @throws InvalidOperation
	 */	
	 @Override
    public void execute() throws InvalidOperation {
			/* Number for tests */			
			int sucesso = 0;
			Form f = new Form(title());
			
			/* Receive a client identifier (email) */		
			InputString clientKey = new InputString(f, Message.reqClientId());
			f.parse();
			
			/** Checks if the client exists in client´s list of outlet.*/
			for(Client c : entity().getClients()){
				if((c.getKey().equals(clientKey.value()))){
					sucesso = 1;
					
					/** Checks if the order exists in client´s order list.*/					
					for(Orders o : c.getTemporaryOrders()){
						DishOfTheDay dish = o.getDish();
						double spent = o.getSpent();
						
						/* Updates the restaurant */
						Restaurants res = o.getRestaurant();
						
						/* Updates the numbero of dishes sold of restaurant */						
						res.setNoDishes(res.getDishesSold()+o.getNoDishes());
						
						/* Updates the restaurant total spent */	
						res.setSpent(res.getSpent()+spent);
						
						/* Updates client´s total spent */						
						c.setSpent(c.getSpent()+spent);
						
						/* Updates the number of dishes purchased by client. */
						c.setNoDishes(c.getDishes()+o.getNoDishes());
						
						
					}
					/* Updates the client´s number of orders. */					
					c.setOrders(c.getOrders()+1);
					c.newOrders();
				}
			}
		/* Throws the exception */			
		if(sucesso == 0)
				throw new UnknownKeyException(clientKey.value());
    }
}
