package net.katerberg.roman;

import java.util.HashMap;
import java.util.Map;

public class Numerals {

	private static Map<String, Integer> _INSTANCE;
	
	private Numerals(){
	}
	
	//This will always be a bidirectional map. I super-promise. We'll ensure this with BiDiMap when I get internet access.
	//TODO: Make this bidirectional.
	public synchronized static Map<String, Integer> getInstance(){
		if (null == _INSTANCE) {
			createNewInstance();
		}
		return _INSTANCE;
	}
	
	public synchronized static boolean isValidNumeral(String testedString){
		return false;
	}

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
