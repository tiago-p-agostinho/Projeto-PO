package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.DuplicateKeyException;
import rest.textui.UnknownKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;
import rest.textui.food.PercentageTooHighException;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;


import rest.core.Outlet;
import rest.core.Food;
import rest.core.PreparedFood; 
import rest.core.SimpleFood;
import rest.core.Vegetable;
/**
 * This class implements the command for registering a new prepared food.
 *
 * @version 1.0
 * @author PO
 **/

public class RegisterPreparedFood extends Command<Outlet> {
   
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public RegisterPreparedFood(Outlet outlet) {
		super(false, MenuEntry.REGISTER_PREPRARED, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
    
 /**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 */
		@Override
    public void execute() throws InvalidOperation {
		Form f = new Form(title());
		
		/* Creates a new list of food */		
		ArrayList<Food> newFood = new ArrayList<Food>();
		
		/* Creates a new list with each percentage of food in newfood */
		ArrayList<Integer> newPercentage = new ArrayList<Integer>();
		
		/* Receives a new prepared food name */		
		InputString name = new InputString(f,Message.reqName());
		f.parse();
		
		for(Food f1 : entity().getFood()){
			/* Check if food exists in food´s list. Case true launch an exception. */
			if(name.value().equals(f1.getName())){
				throw new DuplicateKeyException(name.value());
			}
		}
		f = new Form(title());
		String type;
		boolean vegetable=true;
		int percentage=0;
		boolean exist=false;
		while(true){
			/* Check if prepared food is complete. */			
			if(percentage==100)
				break;
			
			/* Check if total percentege is exceeded. Case true launch an exception. */			
			if(percentage>100){
				throw new PercentageTooHighException(percentage);			
			}
			/* Receives an identifier of food in food´s list */
			InputString food = new InputString(f,Message.reqKey());
			f.parse();
			for(Food f1 : entity().getFood()){
				/* Check if food exists in food´s list in outlet. */ 				
				if((f1.getName().equals(food.value()))){
					f = new Form(title());
					
					/* Receives a percentage of food present in food´s list */					
					InputInteger per = new InputInteger(f,Message.reqPercentage());
					f.parse();
					
					/* Updates total percentage of prepared food. */
					percentage+=per.value();
				
					/* Add the food present in food´s list in outlet to newFood */					
					newFood.add(f1);

					/* Add to newPercentege the percentage of food present in food´s list in prepared food. */					
					newPercentage.add(per.value());
					
					/* Checks if food present in food´s list is type vegetable */					
					if(((f1.getType().equals("VEG"))|| (f1 instanceof Vegetable))&&vegetable){
						vegetable=true;
					} else {
						vegetable=false;
							}
					exist=true;					
					break;			
				}
				
			}		
			/* If food receives does not exists in food´s list launch an exception */
			if(!exist){
				throw new UnknownKeyException(food.value());		
			}
			f = new Form(title());
    	}
		
	/* Check the prepared food type. */		
	if(vegetable){
			type = Message.typeVeg();
		} else {
			type = Message.typeNoVeg();
				}		
		/* Creates and saves a new prepared food. */		
		Food pFood = new PreparedFood(entity(),name.value(),newFood,newPercentage, type);
		entity().addFood(pFood);	
	}
}
	
