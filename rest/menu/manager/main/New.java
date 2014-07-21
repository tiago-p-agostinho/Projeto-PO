package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;
import rest.textui.DuplicateKeyException;


import rest.core.Outlet;
/**
 * Class <code>New</code> represents a command to create a new application. The state of the previous
 * application may be stored.
 *
 * @version 1.0
 * @author PO
 **/

public class New extends Command<Outlet> {
  /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
    public New(Outlet o) {
	super(false, MenuEntry.NEW, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
   
	/**
	 * Executes the command (creates a new file).
	 * 
	 * @throws InvalidOperation
	 */	
 @Override
	public final void execute() throws InvalidOperation, DuplicateKeyException {
		Form f = new Form();
		
		/* Ask if need save the application before exit */	
		InputBoolean valor = new InputBoolean(f, Message.saveBeforeExit());
    f.parse();
    
		/* Execute if is need save the application before exit */  
		if (valor.value()) {
				Form g = new Form();
				
				/* Receives a file name to save the application. */				
				InputString file = new InputString (g, Message.saveAs());
				g.parse();
			
				/* Saves and if already exits that file name  launch an exception. */				
				try{		
					entity().saveAs(file.value());
			} catch(Exception e) {
				throw new DuplicateKeyException(file.value());
			}
	}
				/* Delete all clients of client´s list */
        entity().getClients().clear();
        
				/* Delete all restaurants of restaurant´s list */			
				entity().getRestaurants().clear();
        
				/* Delete all food in food´s list */	
				entity().getFood().clear();
    }
}
