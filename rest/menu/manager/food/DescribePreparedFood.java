package rest.menu.manager.food;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import rest.textui.UnknownKeyException;
import rest.textui.food.InvalidKeyException;
import rest.textui.food.MenuEntry;
import rest.textui.food.Message;
import rest.core.Food;
import rest.core.PreparedFood;
import rest.core.Outlet;
/**
 * This class implements the command for describing a prepared food.
 *
 * @version 1.0
 * @author PO
 **/

public class DescribePreparedFood extends Command<Outlet> {
    
		/**
	 * Constructor.
	 * 
	 * @param o
	 *            object on which the command will be executed
	 */	
	public DescribePreparedFood(Outlet outlet) {
		super(false, MenuEntry.DESCRIBE_PREPARED, outlet);
    }

    /**
     * @see pt.utl.ist.po.ui.Command#execute()
     **/
  
	/**
	 * Executes the command (describe the prepared food and their all constituents).
	 * 
	 * @throws InvalidOperation
	 */
	  @Override
    public void execute() throws InvalidOperation,InvalidKeyException {
        Form f = new Form(title());
	
				/* Receives a food identifier (name) */        
				InputString id = new InputString(f, Message.reqKey());
        f.parse();
		
				/* Number for tests */						
				int sucesso = 0;
		
        for(Food comida : entity().getFood()) 
					/* Check if food exists in food´s list */             
					if(comida.getName().equals(id.value())){
						/* Check if comida is a prepared food */                 
						if(comida instanceof PreparedFood){
										sucesso = 1; 
                    PreparedFood aux = (PreparedFood)comida;
                    Display d = new Display();
                    
										/* display the prepared food descrition */
										d.addNewLine(aux.getDescription());
										d.display();
                    

										for(int i=0; i<aux.getFood().size();++i) {
											Display tudo = new Display();
											/* Display all constituints of prepared food their percentage */                      
											tudo.addNewLine(aux.getFood().get(i).getDescription()+"|"+aux.getPercentage().get(i));
											tudo.display();
											if(aux.getFood().get(i) instanceof PreparedFood) 
												entity().mostraPreparedFood((PreparedFood) aux.getFood().get(i));
										}  
									/* If the identifier of food does not corespond a prepared food, launch an exception */			                
									}else throw new InvalidKeyException(id.value());
            }
	/* If client does not exists in client´s list in outlet launch an exception */	
	if(sucesso == 0)
			throw new UnknownKeyException(id.value());
    }
}
