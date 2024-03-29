package rest.textui.restaurant;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for Main Course key
	 */
	public static final String reqKey() {
		return "Identificador do prato do dia (nome): ";
	}

	/**
	 * @return prompt for quantity
	 */
	public static final String reqQuantity() {
		return "Quantidade do alimento (inteiro): ";
	}

	/**
	 * @return prompt for price
	 */
	public static final String reqPrice() {
		return "Preço do prato do dia (inteiro): ";
	}

	/**
	 * @return prompt for food key
	 */
	public static final String reqFoodKey() {
		return "Identificador do alimento (nome): ";
	}

	/**
	 * @return prompt for discount
	 */
	public static final String reqDiscount() {
		return "desconto a aplicar ao prato do dia (inteiro entre 0 e 100): ";
	}

	/**
	 * @return tag for vegetarian main courses
	 */
	public static final String typeVeg() {
		return "VEG";
	}
	
	/**
	 * @return tag for non vegetarian main courses
	 */
	public static final String typeNoVeg() {
		return "NOVEG";
	}

	/**
	 * @return TRUE tag
	 */
	public static final String typeTrue() {
		return "TRUE";
	}
	
	/**
	 * @return FALSE tag
	 */
	public static final String typeFalse() {
		return "FALSE";
	}

}
