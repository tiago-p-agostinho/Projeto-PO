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

import rest.core.Vegetable;
import rest.core.Food;
import rest.core.PreparedFood;
import rest.core.Outlet;
import rest.core.SimpleFood;
/**
 * Class <code>ShowVegetarianFood</code> represents a command for listing all vegeterian food.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowVegetarianFood extends Command<Outlet> {
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public ShowVegetarianFood(Outlet o) {
	super(false, MenuEntry.SHOW_ALL_VEGETERIAN, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
  

 /**
	 * Executes the command (show vegetarian food).
	 * 
	 * @throws InvalidOperation
	 */		
	  @Override
    public final void execute() {
		Display d = new Display();
		/* Receive a food´s list of outlet. */			
		ArrayList<Food> food = entity().getFood();
		Collections.sort(food);		
		for(Food f : food){
			/* shows food is it vetetable or prepared food of veg type */			
			if((f instanceof Vegetable)||((f instanceof PreparedFood)&&((f.getType())=="VEG"))){
			d.addNewLine(f.toString());
			}
		}
		d.display();
	}
}


