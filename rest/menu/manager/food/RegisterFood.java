package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.DuplicateKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;
import rest.core.Outlet;
import rest.core.Food;
import rest.core.SimpleFood;
import rest.core.Meat;
import rest.core.Fish;
import rest.core.Vegetable;
/**
 * This class implements the command that register a new food.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterFood extends Command<Outlet> {
    
	/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public RegisterFood(Outlet outlet) {
		super(false, MenuEntry.REGISTER_FOOD, outlet);
    }
	
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
	/**
	 * Executes the command (register a food).
	 * 
	 * @throws InvalidOperation
	 */
 @Override
 public void execute() throws InvalidOperation {
	Form f = new Form(title());
	
	/* Receives a food type */ 
	InputString type = new InputString(f, Message.reqType());
	f.parse();	
	while(true){
		/* Check if type received corresponds to one expected type. Repeat the cicle until condicion be true. */		
		if((type.value().equals(Message.typeMeat())) || (type.value().equals(Message.typeFish())) || (type.value().equals(Message.typeVegetable()))){
			break;
		}		
		f = new Form(title());
		type = new InputString(f, Message.reqType());
		f.parse();
	}
	f = new Form(title());	
	
	/* Receives a food´s name */	
	InputString name = new InputString(f, Message.reqName());
	
	/* Receives the number of calories */	
	InputInteger calories = new InputInteger(f, Message.reqCalories());
	Food food = null;
	f.parse();
	boolean tests = true;
	for(Food fo : entity().getFood()){
		/* Check if food exists in food´s list */ 		
		if(name.value().equals(fo.getName())){
			tests = false;				
			/* Case food already exists in list launch an exception */
			throw new DuplicateKeyException(name.value());
			
		}
	}
	if(tests){
		/* If type is meat creates a meat´s instance */		
		if((type.value().compareTo(Message.typeMeat()))==0){
			food = new Meat(entity(), name.value(), calories.value());
		}
		/* If type is fish creates a fish´s instance */			
		if((type.value().compareTo(Message.typeFish()))==0){
		food = new Fish(entity(), name.value(), calories.value());
			}
		/* If type is vegetable creates a vegetable´s instance */			
		if((type.value().compareTo(Message.typeVegetable()))==0){
			food = new Vegetable(entity(), name.value(), calories.value());
			}
		/* Saves the food created in food´s list in outlet */	
		entity().addFood(food);
	}
	}
}
