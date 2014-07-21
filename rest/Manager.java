package rest;

import rest.menu.manager.ManagerMenuBuilder;
import pt.utl.ist.po.ui.*;
import rest.core.Outlet;
/**
 * This class represent the management of an outlet  
 *
 * @author Francisco Ferreira, Sebastião Melo, Tiago Agostinho
 * @version 1.0
 */
public class Manager{
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		/* Create an outlet */		
		Outlet o = new Outlet("Ola");
		
		/* Read an Import file, if any */	
		String filename = System.getProperty("Import");
		if(filename != null) o.parseInputFile(filename);
		o.setExecutado(false);
		
		/* Open the main menu of outlet management */		
		ManagerMenuBuilder m = new ManagerMenuBuilder();
		m.openMainMenu(o);
		
		/* Saves the application state if it has been modified since last save and quit */ 
		try{
			o.quit();
		}catch(Exception e){}
	}
}
