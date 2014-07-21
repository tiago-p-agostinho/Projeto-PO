package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;
import rest.core.Food;
import rest.core.SimpleFood;
import rest.core.Outlet;
/**
 * This class implements the command that updates the properties of food.
 *
 * @version 1.0
 * @author PO
 **/

public class ChangeFoodProperties extends Command<Outlet> {
   
	/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
	public ChangeFoodProperties(Outlet outlet) {
		super(false, MenuEntry.CHANGE_FOOD, outlet);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    

	/**
	 * Executes the command (Change simplefood calories).
	 * 
	 * @throws InvalidOperation
	 */
		@Override
    public void execute() throws InvalidOperation {
        Form f = new Form();
				/* Receives a food identifier (name) */        
				InputString id = new InputString(f, Message.reqKey());
        f.parse();
        
				/* Number for tests */ 
				int sucesso = 0; 
		
        for(Food comida : entity().getFood())
					/* Check if food exists in food´s list */           
					 if(comida.getName().equals(id.value())){
								/* Check if comida is a simple food */                
								if(comida instanceof SimpleFood){
		    						sucesso = 1;
                    SimpleFood aux = (SimpleFood)comida;
                    Form c = new Form();
                    
										/* Receives a new number of calories */
									  InputInteger calories = new InputInteger(c, Message.reqCalories());
                    c.parse();
   
	  								/* Change the number of calories */			               
										aux.changeCalories(calories.value());
                }
            }
	/* If client does not exists in client´s list in outlet launch an exception */		
	if(sucesso == 0)
	    throw new UnknownKeyException(id.value());
    }
}
