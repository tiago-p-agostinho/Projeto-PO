package rest.textui;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a unknown key is used.
 */
public class UnknownKeyException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201207120943L;

	/** The key */
	private final String _key;

	/**
	 * @param key
	 *            object key
	 */
	public UnknownKeyException(String key) {
		_key = key;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "A entidade com o identificador '" + _key + "' não existe.";
	}
}
