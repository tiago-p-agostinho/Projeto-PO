
package rest.core;
import rest.core.Outlet;
import rest.core.DishOfTheDay;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.io.*;
import java.lang.*;

/**
 * Class restaurants contains information about their dishes of the day.
 * Each restaurant knows their spents and how many dishes sold.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Restaurants implements Serializable, Comparable{

	/** The Restaurant´s name.*/
	private String _name;
	
	/** The Restaurant´s e-mail.*/	
	private String _email;
	
	/** The Restaurant´s number of dishes sold.*/	
	private int _dishesSold;
	
	/** The Restaurant´s spent.*/
	private double _spent;
	
	/** The Restaurant´s state of discounts. **/
	private boolean _discounts;

	/** The Restaurtant´s Menu of dishes of the day.*/	
	private ArrayList<DishOfTheDay> _dishes = new ArrayList<DishOfTheDay>();
	
	/** The Restaurant´s Outlet. */
	private Outlet _outlet;
	
	
	/**
	 * Constructor (initializes _name, _email and _outlet).
	 * 
	 * @param name
	 *            The Restaurant´s name.
	 * @param email
	 *            The Restaurant´s e-mail.
	 * @param outlet
	 *            The Restaurant´s outlet.
	 */
	public Restaurants(Outlet outlet, String name, String email){
		_name=name;
		_email=email;
		_outlet=outlet;	
		_discounts=false;
	}
	
	/**
		* Change _discount´s state.
		*
		* @param value
		*							New Restaurant´s _discount state
		*/ 	
	
	public void setDiscounts(boolean value){
		_discounts=value;
	}

	/**
		* Returns a Restaurant´s discount state
		*
		*@return a Restaurant´s _discount value
		*/
	public boolean getDiscounts(){
		return _discounts;
	}

	/**
		* Updates the number of dishes sold by Restaurant.
		*
		* @param no
		*							number of dishes sold by Restaurant
		*/ 	
	public void setNoDishes(int no){
		_dishesSold=no;
	}

	/**
		* Updates the Restaurant Spent.
		*
		* @param value
		*							total Restaurant´s spent.
		*/ 	
	public void setSpent(double value){
		_spent=value;
	}

	/**
		* Returns Restaurant´s name
		*
		* @return the restaurant's name.
		*/
	public String getName(){
		return _name;
	}
	
	/**
		*	Resturns Restaurant´s e-mail	
		*
		* @return the restaurant's email.
		*/
	public String getEmail(){
		return _email;
	}

	/**
		* Returns the number of dishes sold by Restaurant
		*		
		* @return the restaurant's number of dishes sold.
		*/
	public int getDishesSold(){
		return _dishesSold;
	}
	
/**
	* Returns the total restaurant´s spent
	*			
	* @return the total restaurant's spent.
	*/
	public double getSpent(){
		return _spent;
	}

	/**
		* Returns the restaurants outlet
		*	
		* @return the restaurant's outlet.
		*/
	public Outlet getOutlet(){
		return _outlet;
	}

	/**
		* Returns the list with all dishes of the day of restaurant	
		*	
		* @return the restaurant's list of dishes of the day.
		*/
	public ArrayList<DishOfTheDay> getDishes(){
		return _dishes;
	}

/**
	*	add a dish to list of the dishes of the day
	*
	* @param dish
	*						add a dish to list of the dishes of the day.
	*/
	public void addDish(DishOfTheDay dish){
		_dishes.add(dish);
	}


/** 
	* Returns a string respresentation of a restaurant. His name, total dishes sold and total spent.
	*
	* @return a string representation of a restaurant (name, dishes sold and total spent).
	*/
	public String toString(){
		return  getName() + "|" + getDishesSold() + "|" + (int)getSpent();
	}

	/**
		* Check if two restaurants are equals. Two restaurants are considered equals if
		* they have the same name.
		*		
		* @param res
		* 	     Receive an object of the restautant type.
		* 
		* @return two restaurants are equals if they have the same name and return 0. 
		* 
		*/
	public int compareTo(Object res){
		Restaurants restaurant = (Restaurants)res;
		return _name.compareTo(restaurant.getName());
	}

}
