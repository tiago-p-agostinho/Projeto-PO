package rest.core;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import rest.textui.clients.Message;
import java.io.*;

/**
 * Class Client represent a client of an outlet.
 * Each client is identified by an email.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Client implements Serializable, Comparable{

	/* The client´s identifier */	
	private String _key;
	
	/* The client´s name */	
	private String _name;
	
	/* The client´s type */	
	private Type _type;
	
	/* The client´s outlet */	
	private Outlet _outlet;
	
	/* The client´s number orders */	
	private int _orders;
	
	/* The client´s number dishes */
	private int _numberDishes;
	
	/* The total spent of client */	
	private double _spent;
	
	/* The client´s subscribe in novelty list */	
	private boolean _acceptNovelty;
	
	/* The client´s subscribe in discount list */	
	private boolean _acceptDiscount;
	
	/* The client´s list of orders. */	
	private ArrayList<Orders> _temporaryOrders = new ArrayList<Orders>();
	
	/* The client´s list of messages */	
	private ArrayList<ClientMessage> _messageList = new ArrayList<ClientMessage>();

	/*
	 * Constructor()
	 */
	public Client(){}

 	/**
	 * Constructor (initializes _key, _name, _acceptNovelty, _acceptDiscount, _type and _outlet).
	 * 
	 * @param name
	 *            The client´s name.
	 * @param key
	 *            The clients´s identifier (e-mail).
	 * @param outlet
	 *            The client´s outlet.
	 * @param type
	 *            The client´s type.
	 */
	public Client(Outlet outlet, String name, String key, String type){
		_key=key;
		_name=name;
		_outlet=outlet;
		_acceptNovelty=false;
		_acceptDiscount=false;
		if((type.compareTo("VEGETARIAN"))==0)
			_type = new Vegetarian();
		else if((type.compareTo("OMNIVOROUS"))==0)
			_type = new Omnivorous();
	}		
	
	/**
		* Updates the client´s total spent.
		*
		* @param value
		*							Total client´s spent
		*/ 	
	public void setSpent(double value){
		_spent=value;
	}

		/**
		* Updates the client´s number of dishes.
		*
		* @param no
		*							The number of dishes purchased by client.
		*/ 
	public void setNoDishes(int no){
		_numberDishes=no;
	}

	/**
		* Updates the client´s number of orders.
		*
		* @param no
		*							The number of orders purchased by client.
		*/ 	
	public void setOrders(int no){
		_orders=no;
	}

	/**
		* Change the client´s name.
		*
		* @param name
		*							The client´s name.
		*/ 	
	public void setName(String name){
		_name=name;	
	}

	/**
		* Change the client´s key.
		*
		* @param key
		*							The new client´s key.
		*/ 	
	public void setKey(String key){
		_key=key;	
	}

	/**
		* Change the client´s outlet.
		*
		* @param outlet
		*							The new client´s outlet.
		*/ 
	public void setOutlet(Outlet outlet){
		_outlet=outlet;
	}

	/**
		* Change the client´s type.
		*
		* @param type
		*							The new client´s type.
		*/ 
	public void setType(String type){
		if((type.compareTo("VEGETARIAN"))==0)
			_type = new Vegetarian();
		else
			_type = new Omnivorous();
	}		
 
	/**
		* Updates the client´s subscribe in discount list.
		*
		* @param value
		*							The new state of client in discount list.
		*/ 	
	public void setAcceptDiscount(boolean value){
		_acceptDiscount=value;
	}

	/**
		* Updates the client´s subscribe in novelty list.
		*
		* @param value
		*							The new state of client in novelty list.
		*/ 
	public void setAcceptNovelty(boolean value){
		_acceptNovelty=value;
	}

	/**
		* Returns client´s name
		*
		* @return the client's name.
		*/
	public String getName(){
		return _name;
	}

	/**
		* Returns client´s key
		*
		* @return the client's key.
		*/
	public String getKey(){
		return _key;
	}

	/**
		* Returns client´s type
		*
		* @return the client's type.
		*/
	public String getType(){
		if(_type instanceof Vegetarian)
			return Message.clientTypeVegetarian();
		else
			return Message.clientTypeOmnivorous();
	 
	}

	/**
		* Returns number of orders purchased by client.
		*
		* @return the number of orders purchased by client.
		*/	
	public int getOrders(){
		return _orders;	
	}
	
	/**
		* Returns number of dishes purchased by client
		*
		* @return number of dishes purchased by client
		*/
	public int getDishes(){
		return _numberDishes;	
	}

	/**
		* Returns client´s total spent
		*
		* @return the client's total spent.
		*/
	public double getSpent(){
		return _spent;
	}

	/**
		* Returns client´s subscribe state in discount list
		*
		* @return the client´s subscribe state in discount list
		*/	
	public boolean getAcceptDiscount(){
		return _acceptDiscount;
	}

	/**
		* Returns client´s subscribe state in novelty list
		*
		* @return the client´s subscribe state in novelty list
		*/	
	public boolean getAcceptNovelty(){
		return _acceptNovelty;
	}
	
	/**
		* Add a order to temporary order´s list.
		*
		* @param order
		*							order to add in temporary order list.
		*/ 
	public void addOrder(Orders order){
		_temporaryOrders.add(order);
	}
	
	/*
	 * clear the temporary order list
	 */
	public void newOrders(){
		_temporaryOrders.clear();
	}

	/**
		* Add a message to client´s message list.
		*
		* @param order
		*							new message to add in client´s message list.
		*/ 
	public void addMessage(ClientMessage message){
		_messageList.add(message);
	}

	/**
		* Returns client´s message list
		*
		* @return the client´s message list
		*/		
	public ArrayList<ClientMessage> getMessageList(){
		return _messageList;
	}
	
	/**
		* Returns client´s temporary orders list
		*
		* @return the client´s temporary orders list
		*/
	public ArrayList<Orders> getTemporaryOrders(){
		return _temporaryOrders;
	}
	
	/**
		* Check if two clients are equals. Two clients are considered equals if
		* they have the same key (email).
		*		
		* @param c
		* 	     Receive an object of the client type.
		* 
		* @return two clients are equals if they have the same key (email) and return 0. 
		* 
		*/
	public int compareTo(Object c){
		Client client = (Client)c;
		return _key.compareTo(client.getKey());
	}

	/** 
	* Returns a string respresentation of a client. His type, name, key, orders purchased, dishes purchased
	* and total spent.
	*
	* @return a string representation of a client (name, key, orders, dishes and total spent).
	*/
	public String toString(){
		return getType() + "|" + getName() + "|" + getKey() + "|" + getOrders() + "|" + getDishes() + "|" + (int)getSpent();
	} 
}
