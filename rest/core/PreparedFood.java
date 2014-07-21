package rest.core;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import rest.core.Food;
import rest.core.SimpleFood;
import rest.core.Outlet;
import java.io.*;


/**
 * Class prepared food contains information about their constituents.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class PreparedFood extends Food implements Serializable{

	/* List with all food of an prepared food */
	private ArrayList<Food> _food = new ArrayList<Food>();
	
	/* List with a percentage of each food of prepared food */	
	private ArrayList<Integer> _percentage = new ArrayList<Integer>();

	/* The prepared food name */ 
	private String _type;

	
	/**
	 * Constructor (initializes _name, _outlet, _food, _percentage, _type).
	 * 
	 * @param outlet
	 *            The outlet that a prepared food belongs.
	 *
	 * @param name
	 *            The prepared food name.
	 *
	 * @param food
	 *            The list with all food of prepared food.
	 *
	 * @param precentage
	 *           	 The percentage of each food in prepared food.
	 *
	 * @param type
	 *            The prepared food type. Can be vegetarian or no vegetarian 
	 */	
	public PreparedFood(Outlet outlet, String name, ArrayList<Food> food, ArrayList<Integer> percentage, String type){
		super(outlet,name);
		_food=food;
		_percentage=percentage;
		_type=type;
	}

	/**
		* Returns the name of prepared food.
		*
		*@return the name of prepared food
		*/	
	public String getType(){
		return _type;
	}

	/**
		* Returns the list of food of prepared food.
		*
		*@return the list of food of prepared food
		*/	
	public ArrayList<Food> getFood(){
		return _food;
	}

	/**
		* Returns the list with each percentage of food in prepared food.
		*
		*@return the list with each percentage of food in prepared food
		*/
	public ArrayList<Integer> getPercentage(){
		return _percentage;
	}

	/**
		* Returns the number of calories in prepared food.
		*
		*@return the number of calories in prepared food
		*/
	public double getCalories(){
		int cont = 0;
		int index = 0;
		double calories = 0;
		ArrayList<Integer> percentage = getPercentage();
		ArrayList<Food> food = getFood();

		for(Food f : food){
			calories = f.getCalories()*percentage.get(index)+calories;
						
			++index;		
		}
		return calories*0.01;	
	}
	
	
 /**
	 * String representation of the preparedfood: show the type and name.
	 * 
	 * @return a string representation of the prepared food.
	 */
	public String toString(){
		return getType() + "|" + getName();
	}

 /**
	 * String representation of the preparedfood: show the type and name.
	 * 
	 * @return a string representation of the prepared food.
	 */
	public String getDescription(){
		return toString();
	}
	
}
