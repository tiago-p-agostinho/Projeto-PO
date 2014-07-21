package rest.core;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import rest.core.Client;
import rest.core.Restaurants;
import rest.core.Food;
import rest.core.*;
import java.io.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.Message;

/**
 * Class outlet contains information about their food, restaurants and clients.
 * An outlet manages their food, restaurants and clients.
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Outlet implements Serializable {

	/* the aplication state since last time that was saved. */
	private boolean executado = false;
	
	/* The outlet name */	
	private String _name;
	
	/* The load file name */	
	private String _nomeDoFicheiroAberto = null;
	
	/* The client´s list of an outlet */	
	private ArrayList<Client> _clients = new ArrayList<Client>() ;
	
	/* The food´s list of an outlet */		
	private ArrayList<Food> _food = new ArrayList<Food>();
	
	/* The restaurant´s list of an outlet */		
	private ArrayList<Restaurants> _restaurants = new ArrayList<Restaurants>();

	
	
	/**
	 * Constructor (initializes _name).
	 * 
	 * @param name
	 *            The Outlet´s name.
	 */
	public Outlet(String name){
		_name=name;
	}
	
	
	/**
		* Returns the outlet´s name
		*
		*@return the outlet´s name
		*/
	public String getName() {
		return _name;
	}
	
	/**
		* Change executado state. Represent the application state since last time that was saved.
		*
		* @param value
		*							 the application state.
		*/ 	
	public void setExecutado(boolean value){
		executado = value;
	}
	
	
	/**
		* Returns the file name.
		*
		* @return
		*					the file name
		*/ 	
	public String getFicheiro() {
		return _nomeDoFicheiroAberto;
	}
	

	/**
		* Change the file name.
		*
		* @param file
		*							 the file name.
		*/ 	
	public void setFicheiro(String file){
		_nomeDoFicheiroAberto = file;	
	}


	/**
		* Returns the outlet client´s list.	
		*
		* @return
		*					the outlet client´s list.			
		*/ 	
	public ArrayList<Client> getClients(){
		return _clients;
	}
	

	/**
		* Returns the outlet restaurant´s list.		
		*
		* @return
		*					the outlet restaurant´s list.			
		*/ 
	public ArrayList<Restaurants> getRestaurants(){
		return _restaurants;
	}
	
	
	/**
		* Returns the outlet food´s list.		
		*
		* @return
		*					the outlet food´s list.			
		*/ 
	public ArrayList<Food> getFood(){
		return _food;
	}


	/**
		* add a client to client´s list of outlet
		*
		* @param client
		*							 a new client of the outlet.
		*/ 	
	public void addClient(Client client){
		_clients.add(client);
		
	}


	/**
		* add a restaurant to restaurant´s list of outlet
		*
		* @param restaurant
		*							 a new restaurant of the outlet.
		*/ 
	public void addRestaurant(Restaurants restaurant){
		_restaurants.add(restaurant);
		
	}


	/**
		* add a food to food´s list of outlet
		*
		* @param food
		*							 a new food of the outlet.
		*/ 
	public void addFood(Food food){
		_food.add(food);
		
	}
	
	
	/** 
		* Read in each line the first value and veriry if correspond to one of expected value.
		* Case true create and save a correspondent object with remaining values of that line.
		* 
		* @param file
		*							the file name to read.
		*/ 
	public void parseInputFile(String file) {
	      int lineno = 0;
	      try {
			BufferedReader in = new BufferedReader(new FileReader(file));
		  	String s;

		  	while ((s = in.readLine()) != null) {
		      	String line = new String(s.getBytes(), "UTF-8");
		      	lineno++;
		      	String[] split = line.split("\\|");
		      	if (split[0].equals("OMNIV")){
			    		addClient(new Client(this, split[1], split[2], "OMNIVOROUS"));
				}else if(split[0].equals("VEGET")){
			    		addClient(new Client(this, split[1], split[2], "VEGETARIAN"));
		      	}else if(split[0].equals("RESTAURANT")){
			  		addRestaurant(new Restaurants(this, split[1], split[2]));
		      	}else if(split[0].equals("MEAT")){
			  		addFood(new Meat(this, split[1], Integer.parseInt(split[2])));
		      	}else if(split[0].equals("FISH")){
			  		addFood(new Fish(this, split[1], Integer.parseInt(split[2])));
		      	}else if(split[0].equals("VEGETABLE")){
			 		addFood(new Vegetable(this, split[1], Integer.parseInt(split[2])));
		      	}else if(split[0].equals("PREPARED")){
			  		ArrayList<Food> listFood = new ArrayList<Food>();
			  		ArrayList<Integer> listPercent = new ArrayList<Integer>();
			  		String vegetable = "VEG";
			  		for(int i=2;i<split.length;++i){
			      		String[] igual = split[i].split("=");
			     			for(Food food : _food){
				  			if(food.getName().equals(igual[0])){
				      			if(!(food instanceof Vegetable)) 
				      				vegetable = "NOVEG"; 
				      			listFood.add(food);
				      			listPercent.add(new Integer(Integer.parseInt(igual[1])));
				      			break;
				  			}
			      		}
			  		}
			  		addFood(new PreparedFood(this, split[1], listFood, listPercent, vegetable));
		      	}else if(split[0].equals("DOTD")){
			  		for(Restaurants rest : _restaurants){
			     	 		if(rest.getName().equals(split[1])){
				  			for(Food food : _food){
				      			if(food.getName().equals(split[2])){
					  				rest.addDish(new DishOfTheDay(rest.getName(), food, Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5])));
					  				break;
				      			}
				  			}
				  			break;
			      		}
			  		}
		      	}
		  	}
	      } catch (FileNotFoundException e) {
		  	System.out.println("Erro (file not found):"+file+": "+e);
	      } catch (IOException e) {
		  	System.out.println("Erro (IO):"+file+":"+lineno+": line "+e);
	      }
	}
	
	
		/**
			* Before exit verify if the application was updated since last serealize.
			* Case true make a serealize an quit.
			**/
    public void quit() throws InvalidOperation{
		if(executado){
	    		Form f = new Form();
	    		InputBoolean valor = new InputBoolean(f, Message.saveBeforeExit());
	    		f.parse();
	    		if(valor.value() && _nomeDoFicheiroAberto == null){
				Form g = new Form();
				InputString nome = new InputString (g, Message.newSaveAs());
				g.parse();
				try{
		    			saveAs(nome.value());
					}catch(Exception e){
		    				throw new InvalidOperation();
					}
	    		} else if (valor.value()) {
	    			try{
		    			saveAs(_nomeDoFicheiroAberto);
					}catch(Exception e){
		    				throw new InvalidOperation();
					}
	    		}
		}
    	}
	
 /**
	 * Load the file that save the previous state of application.
	 * 
	 *
	 * @param name
	 *						 the name of file with serealize data.
	 *
	 **/	
	public void load(String name) throws Exception{
		setFicheiro(name);
	 	ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
		Outlet ret = (Outlet)in.readObject();
		_name = ret.getName();
		_clients = ret.getClients();
		_food = ret.getFood();
		_restaurants = ret.getRestaurants();
		in.close();
	}
	

	/**
	 * Save the actual state of application.
	 *
	 * @param file 
	 *             the file name to serealize.
	 *
	 *
	 **/
	public void saveAs(String file) throws Exception {
		executado = false;
		if((new File(file)).exists()) throw new Exception();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(this);
		out.close();
	
	}
	/**
	 * Descrive a prepared food and all constituens of prepared food
	 *
	 * @param pf 
	 *            the prepared food to be discribe
	 *
	 *
	 **/
	public void mostraPreparedFood (PreparedFood pf) {
		Display d = new Display();
		d.addNewLine(pf.getDescription());
		for(int i = 0; i < pf.getFood().size(); i++) {
			d.addNewLine(pf.getFood().get(i).getDescription()+"|"+pf.getPercentage().get(i));
			if(pf.getFood().get(i) instanceof PreparedFood)
				mostraPreparedFood((PreparedFood)pf.getFood().get(i));
		}
		d.display();
	}
}
