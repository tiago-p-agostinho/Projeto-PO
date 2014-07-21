package rest.core;

import rest.core.Outlet;
import rest.core.SimpleFood;
import rest.textui.food.Message;
import java.io.*;

/**
 * Class Fish represent a type of simple food.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Fish extends SimpleFood implements Serializable{

/**
	 * Constructor (initializes _outlet, _name and _calories).
	 * 
	 * Call the constructor of super class		
	 *
	 * @param outlet
	 *             The outlet that fish belongs.
	 * @param name
	 *             The fishe´s name.
	 * @param calories
	 *          	 The fishe´s calories.
	 */	
	public Fish(Outlet outlet, String name, int calories){
		super(outlet,name,calories);
	}

	/** 
	* Returns a string respresentation of a fish. His type, name and calories.
	*
	* @return a string representation of a fish (type, name and calories).
	*/
	public String toString(){
		return Message.typeFish() + "|" + super.getName() + "|" + (int)super.getCalories();
	}

	/** 
	* Returns a string respresentation of a fish. His type and name.
	*
	* @return a string representation of a fish (type and name).
	*/	
	public String getDescription(){
		return Message.typeFish() + "|" + super.getName();
	}
}
