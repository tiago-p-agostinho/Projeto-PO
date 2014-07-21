package rest.menu.outlet;

/**
 * This class implements the menu of the outlet application.
 **/
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import rest.textui.outlet.MenuEntry;
import rest.core.Outlet;

public final class OutletMenuBuilder {
	
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */
    public static void menuFor(Outlet outlet) {
	Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
		new ShowDishesOfTheDay(outlet), 		// Show dishes of the day
		new AddDishOfTheDayToOrder(outlet),	// Placing an order
		new CheckoutOrder(outlet),					// Purchased an order
	    });
	menu.open();
    }
}
