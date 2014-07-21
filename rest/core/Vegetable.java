package rest.core;

import rest.core.Outlet;
import rest.core.SimpleFood;
import rest.textui.food.Message;
import java.io.*;

/**
 * Class Vegetable represent a type of simple food.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Vegetable extends SimpleFood implements Serializable{

	/**
	 * Constructor (initializes _outlet, _name and _calories).
	 * 
	 * Call the constructor of super class		
	 *
	 * @param outlet
	 *             The outlet that vegetable belongs.
	 * @param name
	 *             The vegetable´s name.
	 * @param calories
	 *          	 The vegetable´s calories.
	 */	
	public Vegetable(Outlet outlet, String name, int calories){
		super(outlet,name,calories);
	}

	/** 
	* Returns a string respresentation of a vegateble. His type, name and calories.
	*
	* @return a string representation of a vegetable (type, name and calories).
	*/
	public String toString(){
		return Message.typeVegetable() + "|" + super.getName() + "|" + (int)super.getCalories();
	}

/** 
	* Returns a string respresentation of a vegetable. His type and name.
	*
	* @return a string representation of a vegetable (type and name).
	*/
	public String getDescription(){
		return Message.typeVegetable() + "|" + super.getName();
	}
}
