package rest.core;

import rest.textui.food.Message;
import rest.core.Food;
import rest.core.SimpleFood;
import rest.core.PreparedFood;
import rest.core.Outlet;
import java.io.*;
import java.lang.*;

/**
 * Class DishOfTheDay represent a dish of a restaurant.
 * It´s constitued by food.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class DishOfTheDay implements Serializable, Comparable{

	/* The name of Dish of the day */
	private String _name;
	
	/* The food of Dish of the day */
	private Food _food;

	/* The quantity of Dishes of the day */	
	private int _quantity;
	
	/* The price of Dish of the day */	
	private int _price;
	
	/* The class of Dish of the day */	
	private String _class;

	/* The state of Dish of the day */
	private boolean _available;
	
	/* The discount of Dish of the day */	
	private int _discount;
	
	/* The restaurant of Dish of the day belongs */	
	private String _restaurant;
	
	/* The discount state of Dish of the day */	
	private boolean _discountType;


 	/**
	 * Constructor (initializes _restaurant, _name, _food, _price, _available and _discount).
	 * 
	 * @param restaurant
	 *             The restaurant that dish of the day belongs.
	 * @param food
	 *             The food that is the dish of the day.
	 * @param quantity
	 *          	 The quantity of Dishes of the day.
	 * @param price
	 *						 The price of Dish of the day. 
	 * @param discount
	 * 							The discount of Dish of the day.
	 */
	public DishOfTheDay(String restaurant, Food food, int quantity, int price, int discount){
		_restaurant= restaurant;
		_name=food.getName();
		_food=food;
		_quantity=quantity;
		_price=price;
		_available=false;
		_discount=discount;
		if(discount==0){
			_discountType=false;
		} else {
			_discountType=true;
		}
		if(food instanceof PreparedFood){
			PreparedFood pf = (PreparedFood) food;
			if((pf.getType()).equals("VEG"))
				_class=Message.typeVeg();
			else
				_class=Message.typeNoVeg();
		} else if(food instanceof Vegetable)			
				_class=Message.typeVeg();
			else
				_class=Message.typeNoVeg();
	} 

		/**
		* Returns the restaurant that dish of the day belongs
		*
		* @return the restaurant that dish of the day belongs
		*/
	public String getRestaurantName(){
		return _restaurant;
	}	

	
	/**
		* Returns the name of the dish of the day
		*
		* @return the name of the dish of the day
		*/
	public String getName(){
		return _name;
	}

	/**
		* Returns the number of calolries of the dish of the day
		*
		* @return the number of calories of the dish of the day
		*/
	public double getCalories(){
		double calories = ((getFood().getCalories())*getQuantity());
		return calories;
	}

		/**
		* Returns the state of dish of the day for client
		*
		* @return the state of dish of the day for client
		*/
	public boolean getAvailable(){
		return _available;
	}


	/**
		* Returns the quantity of food in dish of the day
		*
		* @return the quantity of food in dish of the day
		*/	
	public int getQuantity(){
		return _quantity;
	}

		/**
		* Returns the price of dish of the day
		*
		* @return the price of dish of the day
		*/	
	public int getPrice(){
		return _price;
	}


	/**
		* Returns the food that is the dish of the day
		*
		* @return the food that is the dish of the day
		*/	
	public Food getFood(){
		return _food;
	}
	
	/**
		* Returns the class of dish of the day
		*
		* @return the class of dish of the day
		*/	
	public String getClasses(){
		return _class;
	}

	/**
		* Returns the discount of dish of the day
		*
		* @return the discount of dish of the day
		*/	
	public int getDiscount(){
		return _discount;
	}

 	/*
		* Updates the discount of dish of the day
		*
		* @param discount
		*								the new discount of dish of the day
		*/
	public void setDiscount(int discount){
		_discount=discount;
	}	

	 /*
		* Updates the state of dish of the day to client
		*
		* @param value
		*								the new state of dish of the day to client
		*/
	public void setAvailable(boolean value){
		_available=value;
	}
	
	/**
		* Verify if a dish of the day have a discount
		*
		* @return the state of dish of the day discount
		*/		
	public boolean getDiscountType(){
		return _discountType;
	}

	/**
		* Returns the final of dish of the day with discount
		*
		* @param quantity
		*									the quantity of determinate food in dish of the day
		*
		* @return the final of dish of the day with discount
		*/	
	public double getFinalPrice(int quantity){
		double price;
		if(getDiscountType()){
			price = (getPrice() - getPrice()*getDiscount()*0.01);
			price = price * quantity;
			return price;
		} else {
			price = getPrice();
			price = price * quantity;
			return price;
			}
	}
	
	 /*
		* Updates the discount type state
		*
		* @param value
		*								new value of discount type
		*/
	public void setDiscountType(boolean value){
		_discountType=value;
	}


	/**
		* Check if two dishes of the day are equals. Two dishes of the day are considered equals if
		* they have the same name.
		*		
		* @param dot
		* 	     Receive an object of the dish of the day type.
		* 
		* @return two dishes of the day are equals if they have the same name and return 0. 
		* 
		*/
	public int compareTo(Object dot){
		DishOfTheDay dish = (DishOfTheDay)dot;
		return _name.compareTo(dish.getName());
	}

	/** 
	* Returns a string respresentation of a dish of the day. His class, name, price, discount and state.
	*
	* @return a string representation of a dish of the day (class, name, price and discount).
	*/
	public String toString(){
		if(getAvailable())
			return getClasses() + "|" + getName() + "|" + getPrice() + "|" + getDiscount() + "|" + "AVAILABLE";
		else
			return getClasses() + "|" + getName() + "|" + getPrice() + "|" + getDiscount() + "|" + "UNAVAILABLE"; 
	}

}
