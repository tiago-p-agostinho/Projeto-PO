package rest.core;

import rest.textui.clients.Message;
import java.io.*;

/**
 * Class ClientMessage represent a alert message to client.
 * Each ClientMessage can be type of discount or novelty.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class ClientMessage implements Serializable{
	
	/* The ClientMessage´s type */	
	private String _type;
	
	/* dish that originated the alert */	
	private String _dish;

	/* message to be transmitted to the client */	
	private String _message;

	
 /**
	 * Constructor (initializes _type, _dish).
	 * 
	 * @param dish
	 *            The dish that originated the alert
	 *
	 * @param type
	 *            The ClientMessage´s type
	 */
	public ClientMessage(String type, String dish){
		_type=type;
		_dish=dish;
		this.setMessage(_type, _dish);		
		}
	

	/**
		* Create the message to send to client.
		*
		* @param type
		*							The ClientMessage´s type
		*	
		* @param	dish	
		*							The dish that originated the alert
		*/ 	
	public void setMessage(String type, String dish){
		if(type=="NOVELTY"){
			_message=Message.alertNovelty(dish);
		}
		else{
			_message=Message.alertDiscount(dish);
		}
	}
	
	/**
		* Returns the message to send to client
		*
		* @return the message to send to client
		*/
	public String getMessage(){
		return _message;
	}

		/**
		* Returns the client message type
		*
		* @return the client message type
		*/
	public String getType(){
		return _type;
	} 	
		
/** 
	* Returns a string respresentation of a ClientMessage. His type and message.
	*
	* @return a string representation of a ClientMessage (type and message).
	*/
	public String toString(){
		return getType() + "|" + getMessage();
	} 
}
	

