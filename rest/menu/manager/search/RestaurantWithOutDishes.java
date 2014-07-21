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
import java.util.ArrayList;
import rest.core.Outlet;
import rest.core.Client;
import rest.core.Restaurants;
/**
 * Class <code>ShowClientsWithoutAlerts</code> represents a command for listing all
 * clients without any alert.
 *
 * @version 1.0
 * @author PO
 **/

public class RestaurantWithOutDishes extends Command<Outlet> {
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public RestaurantWithOutDishes(Outlet o) {
	super(false, "Restaurantes sem Pratos do dia", o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command (show clients without alerts).
	 * 
	 * @throws InvalidOperation
	 */		
		@Override
    public final void execute() {
		Display d = new Display();

		ArrayList<Restaurants> lista = new ArrayList<Restaurants>();
		
		for(Restaurants r : entity().getRestaurants()){
			/* display all clients that have empty their message´s list */						
			if(r.getDishes().isEmpty()){
				lista.add(r);
			}
		}
	
	ArrayList<String> nome = new ArrayList<String>();

for(Restaurants r : lista){
			/* display all clients that have empty their message´s list */						
			nome.add(r.getName());
			}
		

	Collections.sort(nome);	

		for(String s : nome){
			for(Restaurants r :lista){
			/* shows food is it vetetable or prepared food of veg type */			
			if(r.getName()==s){
			d.addNewLine(r.toString());
			}
		}		
		
		d.display();
   }
}
}

