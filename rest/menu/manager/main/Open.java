package rest.menu.manager.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.manager.MenuEntry;
import rest.textui.manager.Message;


import rest.core.Outlet;
/**
 * Class <code>Open</code> represents a command to open a file.
 *
 * @version 1.0
 * @author PO
 **/

public class Open extends Command<Outlet> {
 
 /**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */		  
	public Open(Outlet o) {
		super(false, MenuEntry.OPEN, o);
    }
    
    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     */
    

 /**
	 * Executes the command (open an existing file).
	 * 
	 * @throws InvalidOperation
	 */	
		@Override
    public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		
		/* Receives the file name to open */
		InputString nome = new InputString (f, Message.openFile());
		f.parse();

		/* If not find the file throws the exception */ 		
		try{
		    entity().load(nome.value());
		}catch(Exception e){
		    (new Display()).addNewLine(Message.fileNotFound(nome.value())).display();
		}
    }
}
