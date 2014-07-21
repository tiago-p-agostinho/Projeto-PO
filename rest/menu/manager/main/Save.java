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
 * Class <code>Save</code> represents a command to save the current state of application in the file
 * associated to the application.
 *
 * @version 1.0
 * @author PO
 **/

public class Save extends Command<Outlet> {
  /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
    public Save(Outlet o) {
	super(false, MenuEntry.SAVE, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    
 /**
	 * Executes the command (save the actual state of application).
	 * 
	 * @throws InvalidOperation
	 */	
		@Override
    public final void execute() throws InvalidOperation {
			/* Checks if exists a file. */		
			if(entity().getFicheiro() == null) {
			Form f = new Form(title());
			
			/* Case does not exists a file receive a new file name. */			
			InputString nome = new InputString (f, Message.newSaveAs());
			f.parse();
			
			/* Updates the file name. */			
			entity().setFicheiro(nome.value());
		}
		/* If not find the file throws the exception */ 			
		try{
			entity().saveAs(entity().getFicheiro());
		}catch(Exception e){}
    }
}
