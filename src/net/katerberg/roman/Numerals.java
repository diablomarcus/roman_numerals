package net.katerberg.roman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author diablo
 *
 */
public class Numerals {

	private static Map<String, Integer> _INSTANCE;
	
	private Numerals(){
	}
	
	//This will always be a bidirectional map. I super-promise. We'll ensure this with BiDiMap when I get internet access.
	//TODO: Make this bidirectional.
	/**
	 * Singleton map of available Latin numeral representations.
	 * 
	 * @return One-to-One map of valid Latin numeric representations to their Arabic counterparts
	 */
	public synchronized static Map<String, Integer> getInstance(){
		if (null == _INSTANCE) {
			createNewInstance();
		}
		return _INSTANCE;
	}
	
	/**
	 * Checks to see if <tt>testedString</tt> passes basic sanity tests based on the rules
	 * provided in Processor.
	 * 
	 * @param testedString Numeral to run basic tests against
	 * @return			   True if numeral passes sanity tests. False if not.
	 */
	public synchronized static boolean isValidNumeral(String testedString){
		//Make sure it's not empty
		if (null == testedString || testedString.isEmpty()) {
			return false;
		}
		//Make sure only valid characters are in it
		StringBuilder validValues = new StringBuilder();
		for (String value : _INSTANCE.keySet()) {
			if (value.length() == 1 && testedString.contains(value+value+value+value)){
				return false;
			}
			if (value.length() == 2 && testedString.contains(value+value)){
				return false;
			}
			validValues.append(value);
		}
		
		if (!testedString.matches("^["+validValues+"]+$")) {
			return false;
		}
		
		//No values can have more than 3 next to one another
		
		return true;
	}

	
	/**
	 * Creates and populates the map of valid Latin-to-Arabic numeric representations
	 */
	private static void createNewInstance() {
		_INSTANCE=new HashMap<String, Integer>();
		_INSTANCE.put("I", 1);
		_INSTANCE.put("IV", 4);
		_INSTANCE.put("V", 5);
		_INSTANCE.put("IX", 9);
		_INSTANCE.put("X", 10);
		_INSTANCE.put("XL", 40);
		_INSTANCE.put("L", 50);
		_INSTANCE.put("XC", 90);
		_INSTANCE.put("C", 100);
		_INSTANCE.put("CD", 400);
		_INSTANCE.put("D", 500);
		_INSTANCE.put("CM", 900);
		_INSTANCE.put("M", 1000);
	}
}
