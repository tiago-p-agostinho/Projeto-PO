package rest.core;

import rest.core.Outlet;
import rest.core.SimpleFood;
import rest.textui.food.Message;
import java.io.*;

/**
 * Class Meat represent a type of simple food.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Meat extends SimpleFood implements Serializable{


	/**
	 * Constructor (initializes _outlet, _name and _calories).
	 * 
	 * Call the constructor of super class		
	 *
	 * @param outlet
	 *             The outlet that meat belongs.
	 * @param name
	 *             The meat´s name.
	 * @param calories
	 *          	 The meat´s calories.
	 */	
	public Meat(Outlet outlet, String name, int calories){
		super(outlet,name,calories);
	}

	
	/** 
	* Returns a string respresentation of a meat. His type, name and calories.
	*
	* @return a string representation of a meat (type, name and calories).
	*/
	public String toString(){
		return Message.typeMeat() + "|" + super.getName() + "|" + (int)super.getCalories();
	}

/** 
	* Returns a string respresentation of a meat. His type and name.
	*
	* @return a string representation of a meat (type and name).
	*/	
	public String getDescription(){
		return Message.typeMeat() + "|" + super.getName();
	}
}
