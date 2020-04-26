import java.util.HashMap;

/**
 * @author Mario de Leon
 * @author Oscar de Leon
 *
 */
public class DictionaryFactory {

	public Object getObject(String tipo) {
		if(tipo.equalsIgnoreCase("SBST")) {
			return new SplayBST<String, String>();
		}else if(tipo.equalsIgnoreCase("HashMap")) {
			return new HashMap<String, String>();
		}
		return null;		
	}
}
