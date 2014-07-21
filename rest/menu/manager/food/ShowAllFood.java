package rest.menu.manager.food;

import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.textui.food.MenuEntry;
import rest.textui.food.Message;
import rest.core.Food;
import rest.core.Outlet;

import java.lang.*;

/**
 * This class implements the command for listing all food.
 *
 * @version 1.0
 * @author PO
 **/

public class ShowAllFood extends Command<Outlet>  {

   /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public ShowAllFood(Outlet outlet) {
	super(false, MenuEntry.LIST_FOOD, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
	/**
	 * Executes the command (list all food of outlet).
	 * 
	 * @throws InvalidOperation
	 */
	 @Override
    public void execute() throws InvalidOperation {
			/* Create a list with all food in outlet */		
			ArrayList<Food> food = entity().getFood();
	
			/* Sort the list of food */		
			Collections.sort(food);
			Display d = new Display(title());		
			
			/* Display each representation of food presents in food´s list sorted */	
			for(Food f : food){
				d.addNewLine(f.toString());
    	}
		d.display();
    }
}
