package net.katerberg.roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {
	//TODO: Make this bidirectional
	private final Map<String, Integer> numerals;
	private final Map<Integer, String> arabics;

	private final List<Integer> descendingValues;
	
	public Processor() {
		numerals = Numerals.getInstance();
		arabics = new HashMap<Integer, String>();
		//This is ugly as hell, but I need BiMap or BiDiMap to make it cleaner.
		for(String value : numerals.keySet()){
			arabics.put(numerals.get(value), value);
		}
		
		//Make sure we have things ordered from biggest to smallest
		descendingValues = new ArrayList<Integer>(numerals.values());
		Collections.sort((List<Integer>)descendingValues);
		Collections.reverse((List<Integer>)descendingValues);
	}
	
	public String convert(int unconverted) {
		if (!isInputValid(unconverted)) {
			return null;
		}
		
		StringBuilder latinVal = new StringBuilder();
		for (Integer value : descendingValues) {
			while (unconverted / value >= 1){
				unconverted -= value;
				latinVal.append(arabics.get(value));
			} 
		}
		
		return latinVal.toString();
	}
	
	
	public Integer convert(String numeral) {
		if (!Numerals.isValidNumeral(numeral)) {
			return null;
		}
		
		Integer returnVal = 0;
		while(!numeral.isEmpty()){
			for (Integer value : descendingValues) {
				String prefixToCheck = arabics.get(value);
				if (numeral.startsWith(prefixToCheck)) {
					returnVal += value;
					//Cut off the piece we just used
					numeral = numeral.substring(prefixToCheck.length(), numeral.length());
				}
			}	
		}
		return returnVal;
	}
	
	private boolean isInputValid(int test) {
		if (test > 0) {
			return true;
		}
		return false;
	}
}
