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
 * Class <code>SaveAs</code> represents a command to save the current state of application in a new file
 *
 * @version 1.0
 * @author PO
 **/

public class SaveAs extends Command<Outlet> {
    /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		
    public SaveAs(Outlet o) {
	super(false, MenuEntry.SAVE_AS, o);
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
		Form f = new Form(title());
		
		/* Receives a file name */		
		InputString nome = new InputString (f, Message.saveAs());
		f.parse();
		
		/* If not find the file throws the exception */		
		try{
			entity().saveAs(nome.value());
		}catch(Exception e){}
	}

}

