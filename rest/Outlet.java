package rest;

import rest.menu.outlet.OutletMenuBuilder;
import pt.utl.ist.po.ui.*;
import rest.textui.outlet.Message;

/**
 * This class represent the interaction between an outlet and their clients  
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Outlet{
	
	/**
	 * @param args
	 */
	public static void main(String args[]) throws InvalidOperation {
		/* Create an outlet */		
		rest.core.Outlet o = new rest.core.Outlet("Ola");
		
		/* Load the file with serealizable data */
		Form f = new Form();
		InputString nome = new InputString (f, Message.openFile());
		f.parse();
		try{
		    o.load(nome.value());
		  
		}catch(Exception e){
		    (new Display()).addNewLine(Message.fileNotFound()).display();
		}		
		
		/* Read an Import file, if any */
		String filename = System.getProperty("Import");
		if(filename != null) o.parseInputFile(filename);
		o.setExecutado(false);
		
		/* Open the main menu for outle´s clients */	
		OutletMenuBuilder.menuFor(o);
		
		/* Save the application before exit */		
		Form g = new Form();
	  InputString valor = new InputString(g, Message.saveFile());
		g.parse();
		try{
			o.saveAs(valor.value());
		}catch(Exception e){}
	
	}
}
