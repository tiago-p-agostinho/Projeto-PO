package rest.core;

import rest.core.Food;
import rest.core.Outlet;
import java.io.*;

/**
 * Class SimpleFood represent a type of food of an outlet.
 * SimpleFood can be type vegetable, meat or fish. 
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class SimpleFood extends Food implements Serializable{

	/* The calories of simple food. */
	private int _calories;	

	/**
	 * Constructor (initializes _outlet, _name and _calories).
	 * 
	 * Call the constructor of super class		
	 *
	 * @param calories
	 *             The calories of simple food.
	 */	
	public SimpleFood(Outlet outlet, String name, int calories){
		super(outlet,name);
		_calories=calories;
	}

	/**
		* Change the simplefood´s calories.
		*
		* @param calories
		*							the new number of calories of simple food.
		*/
	public void changeCalories(int calories){
		_calories=calories;
	}

	/**
		* Returns the simple food type.
		*
		* @return
		*					the simple food type.
		*/
	public String getType(){
		return "";
	}

	/**
		* Returns the number of calories of simple food.
		*
		* @return
		*					the number of calories of simple food.
		*/	
	public double getCalories(){
		return _calories;
	}

	/**
		* Returns the simple food description.
		*
		* @return
		*					the simple food description.
		*/
	public String getDescription(){
		return "";
	}			
}
