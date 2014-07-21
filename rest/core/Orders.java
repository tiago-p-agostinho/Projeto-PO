package rest.core;

import rest.core.DishOfTheDay;
import java.io.*;
import java.lang.*;

/**
 * Class Orders represent an order of a client.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Orders implements Serializable{

	/* The number of dishes of an order */ 
	private int _noDishes;
	
	/* The state of an order */
	private boolean _paid;

  /* Total spent in an order */ 	
	private double _totalSpent;
	
	/* The dish of the day ordered */	
	private DishOfTheDay _dish;
	
	/* The restaurant that dish of the day belongs */	
	private Restaurants _restaurant;

 /**
	 * Constructor (initializes _dish, _totalSpent, _noDishes, _paid and _restaurant).
	 * 
	 * @param dish
	 *            The dish of the day ordered.
	 * @param restaurant
	 *            The restaurant that dish of the day ordered belongs.
	 * @param cost
	 *            The total cost of order.
	 * @param noDishes
	 *            The number of dishes of the day that was ordered.
	 */	
	public Orders(DishOfTheDay dish, Restaurants restaurant, double cost, int noDishes){
		_dish=dish;
		_totalSpent=cost;
		_noDishes=noDishes;
		_paid=false;
		_restaurant=restaurant;
	}


	/**
		* Returns the restaurant that dish of the day belongs.
		*
		* @return the restaurant that dish of the day belongs.
		*/
	public Restaurants getRestaurant(){
		return _restaurant;
	}
	
	/**
		* Returns the totalSpent in this order.
		*
		* @return the totalSpent in this order.
		*/
	public double getSpent(){
		return _totalSpent;
	}
	
	/**
		* Returns the number of dishes of the day orederd in this order.
		*
		* @return the number of dishes of the day orederd in this order.
		*/
	public int getNoDishes(){
		return _noDishes;
	}

	/**
		* Returns the dish of the day ordered.
		*
		* @return the dish of the day ordered.
		*/	
	public DishOfTheDay getDish(){
		return _dish;
	}
}
