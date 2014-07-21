package rest.core;

import rest.core.Outlet;
import rest.core.SimpleFood;
import rest.core.PreparedFood;
import java.io.*;
import java.lang.*;

/**
 * Class Food represent a food of an outlet.
 * The food can be type simplefood (meat, fish or vegetable) or preparedfood (veg or noveg) 
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public abstract  class Food implements Serializable, Comparable{
	
	/* The food´s name */
	private String _name;
	
	/* The food´s outlet */	
	private Outlet _outlet;


	/**
	 * Constructor (initializes _outlet and _name).
	 * 
	 * @param outlet
	 *             The outlet that food belongs.
	 * @param name
	 *             The food´s name.
	 */	
	public Food(Outlet outlet, String name){
		setName(name);
		setOutlet(outlet);
	}

	/**
		* Change the food´s name.
		*
		* @param name
		*							the new name of food.
		*/ 
	public void setName(String name){
		_name=name;
	}	
	
	/**
		* Retruns the food´s type.
		*
		* @return
		*					the food´s type.
		*/ 
	public abstract String getType();
		

	/**
		* Change the food´s outlet.
		*
		* @param outlet
		*							the new food´s outlet.
		*/ 
	public void setOutlet(Outlet outlet){
		_outlet=outlet;
	}
	
	/**
		* Retruns the food´s calories.
		*
		* @return
		*					the food´s calories.
		*/ 
	public abstract double getCalories();

	/**
		* Retruns the food´s name.
		*
		* @return
		*					the food´s name.
		*/ 	
	public String getName(){
		return _name;
	}
	
		/**
		* Check if two food are equals. Two food are considered equals if
		* they have the same name.
		*		
		* @param f
		* 	     Receive an object of the food type.
		* 
		* @return two food are equals if they have the same name and return 0. 
		* 
		*/
	public int compareTo(Object f){
		Food food = (Food)f;
		return _name.compareToIgnoreCase(food.getName());
	}

	/* Returns a description of food
	 *
	 * @return 
	 *					a description of food
	 */
	public String getDescription(){return "";}
}
