package net.katerberg.roman;

import java.util.HashMap;
import java.util.Map;

public class Numerals {

	private static Map<Character, Integer> _INSTANCE;
	
	private void Numerals(){
	}
	
	//This will always be a bidirectional map. I super-promise. We'll ensure this with BiDiMap when I get internet access.
	//TODO: Make this bidirectional.
	public synchronized static Map<Character, Integer> getInstance(){
		if (null == _INSTANCE) {
			createNewInstance();
		}
		return _INSTANCE;
	}

	private static void createNewInstance() {
		_INSTANCE=new HashMap<Character, Integer>();
		_INSTANCE.put('I', 1);
		_INSTANCE.put('V', 5);
		_INSTANCE.put('X', 10);
		_INSTANCE.put('L', 50);
		_INSTANCE.put('C', 100);
		_INSTANCE.put('D', 500);
		_INSTANCE.put('M', 1000);
	}
}
