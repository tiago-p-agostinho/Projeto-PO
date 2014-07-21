package rest.menu.manager;

/**
 * This class is responsible for creating all menus that appear in the manager application.
 * There is a static method for each available menu.
 *
 * @version 1.0
 * @author PO
 **/

import pt.utl.ist.po.ui.*;

import rest.menu.manager.main.*;
import rest.menu.manager.client.*;
import rest.menu.manager.food.*;
import rest.menu.manager.restaurants.*;
import rest.menu.manager.restaurant.*;
import rest.menu.manager.search.*;

import rest.core.*;
import rest.textui.manager.MenuEntry; 

/**
 * This class create all menus of application 
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public final class ManagerMenuBuilder {
	
 /**
	 * Open the main menu of outlet management
	 *
	 * @param o
	 *				the outlet of this menu
	 */    
	public static void openMainMenu(Outlet o) {
	Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
		new New(o),									// Create a new file
		new Open(o),								// Open a created file
		new Save(o),								// Save the actual state of application
		new SaveAs(o),							// Save the actual state of application
		new OpenClientsMenu(o),			// Open the clients menu
		new OpenFoodMenu(o),				// Open the food menu
		new OpenRestaurantsMenu(o),	// Open the restaurants menu
		new OpenSearchMenu(o)
	    });
	menu.open();
    }

 /**
	 * Open the menu client´s menu of outlet management
	 *
	 * @param o
	 *				the outlet of this menu
	 */  
    public static void openClientMenu(Outlet o) {
	Menu menu = new Menu(rest.textui.clients.MenuEntry.TITLE, new Command<?>[] {
		new ShowClients(o), 			// List all clients
		new RegisterClient(o),  	// Register new client
		new ChangeClientType(o),	// Change client type
		new SubscribeClient(o),		// Add client to alert list
		new UnsubscribeClient(o),	// Remove client from alert list
		new ShowClientAlerts(o),   // List alert messages for a given client
	  new ChangeClientName(o)});
	menu.open();
    }

   
 /**
	 * Open the food´s menu of outlet management
	 *
	 * @param o
	 *				the outlet of this menu
	 */  
	public static void openFoodMenu(Outlet o) {
		Menu menu = new Menu(rest.textui.food.MenuEntry.TITLE, new Command<?>[] { 
			new ShowAllFood(o),						// List all foods in outlet
			new RegisterFood(o),					// Register new simple food
			new RegisterPreparedFood(o),	// Register new prepared food
			new ChangeFoodProperties(o),	// Change a simple food properties
			new DescribePreparedFood(o)		// Describe a prepared food
	    });

	menu.open();
  }

 /**
	 * Open the restaurant´s menu of outlet management
	 *
	 * @param o
	 *				the outlet of this menu
	 */  
	public static void openRestaurantsMenu(Outlet o) {
		Menu menu = new Menu(rest.textui.restaurants.MenuEntry.TITLE, new Command<?>[] {
			new ShowAllRestaurants(o),		// List all restaurants
			new RegisterRestaurant(o),		// Register a new restaurant
			new ManageRestaurant(o)				// Manage of one restaurant
		});
	menu.open();
   }

 /**
	 * Open the restaurant´s menu of a restaurant
	 *
	 * @param restaurant
	 *					the restaurant of this menu
	 */  
    public static void openRestaurantMenu(Restaurants restaurant) {
		Menu menu = new Menu(rest.textui.restaurant.MenuEntry.TITLE, new Command<?>[] {
			new ShowDishesOfTheDay(restaurant),						// List all dishes of the day 
			new RegisterDishOfTheDay(restaurant),					// Register a new dish of the day
			new ShowDishOfTheDayCalories(restaurant),			// Show the calories of determinate dish of the day
			new AddDishOfTheDayToOutlet(restaurant),			// Available determinate dish of the day
			new RemoveDishOfTheDayFromOutlet(restaurant),	// Unvailable determinate dish of the day
			new ChangeDishOfTheDayDiscount(restaurant)		// Change the discount of determinate dish of the day
	    });
			menu.open();
  }

 /**
	 * Open the search´s menu of outlet management
	 *
	 * @param o
	 *				the outlet of this menu
	 */  
    public static void openSearchMenu(Outlet o) {
		Menu menu = new Menu(rest.textui.search.MenuEntry.TITLE, new Command<?>[] {
			new ShowVegetarianFood(o),							// List all vegetarian food
			new ShowClientsWithoutAlerts(o),				// List all clients with alerts 
			new ShowClientsWithClosedOrders(o),			// List all clients with closed orders
			new ShowRestaurantsWithDiscounts(o),
			new RestaurantWithOutDishes(o),
				// List all restaurants with discounts
		});
		menu.open();
    }
}
