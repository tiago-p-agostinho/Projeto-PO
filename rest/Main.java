package rest;

import rest.menu.manager.ManagerMenuBuilder;
import pt.utl.ist.po.ui.*;
import rest.core.Outlet;

public class Main{
	
	public static void main(String args[]) {
		Outlet o = new Outlet("Ola");
		String filename = System.getProperty("Import");
		if(filename != null) o.parseInputFile(filename);
		o.setFicheiro(filename);
		o.setExecutado(false);
		ManagerMenuBuilder m = new ManagerMenuBuilder();
		m.openMainMenu(o);
		try{
			o.quit();
		}catch(Exception e){}
	}
}
