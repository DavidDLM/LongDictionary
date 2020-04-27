import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Usuario Dell
 *
 */
public class DictionaryTest {
	HashMap<String, String> map = new HashMap<String, String>();
	SplayBST<String, String> tree = new SplayBST<String, String>();
	@Test
	public void insertMapTest() {
		map.put("house", "casa");
		assertEquals("casa", map.get("house"));
	}
	
	@Test
	public void searchMapTest() {
		map.put("house", "casa");
		map.put("rat", "raton");
		map.put("car", "carro");
		assertEquals(true, map.containsKey("rat"));
	}
	
	@Test
	public void insertTreeTest() {
		tree.put("woman", "mujer");
		assertEquals("mujer", tree.get("woman"));
	}
	
	@Test
	public void searchTreeTest() {
		tree.put("house", "casa");
		tree.put("rat", "raton");
		tree.put("car", "carro");
		assertEquals(true, tree.contains("car"));
	}

}
