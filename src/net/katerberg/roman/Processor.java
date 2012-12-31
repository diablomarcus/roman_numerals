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

	private final List<Integer> sortedVals;
	
	public Processor() {
		numerals = Numerals.getInstance();
		arabics = new HashMap<Integer, String>();
		//This is ugly as hell, but I need BiMap or BiDiMap to make it cleaner.
		for(String value : numerals.keySet()){
			arabics.put(numerals.get(value), value);
		}
		
		sortedVals = new ArrayList<Integer>(numerals.values());
		Collections.sort((List<Integer>)sortedVals);
		Collections.reverse((List<Integer>)sortedVals);
	}
	
	public String convert(int unconverted) {
		if (!isInputValid(unconverted)) {
			return null;
		}
		
		StringBuilder latinVal = new StringBuilder();
		for (Integer value : sortedVals) {
			while (unconverted / value >= 1){
				unconverted -= value;
				latinVal.append(arabics.get(value));
			} 
		}
		
		return latinVal.toString();
	}
	
	
	public Integer convert(String numeral) {
		if (!isInputValid(numeral)) {
			return null;
		}
		
		Integer returnVal = 0;
		while(!numeral.isEmpty()){
			for (Integer value : sortedVals) {
				String prefixToCheck = arabics.get(value);
				if (numeral.startsWith(prefixToCheck)) {
					returnVal += value;
					//Cut off the piece we just used
					numeral = numeral.substring(prefixToCheck.length(), numeral.length());
				}
				
				arabics.get(value);
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
	
	private boolean isInputValid(String test) {
		//Make sure it's not empty
		if (null == test || test.isEmpty()) {
			return false;
		}
		//Make sure only valid characters are in it
		StringBuilder validValues = new StringBuilder();
		for (String value : arabics.values()) {
			validValues.append(value);
		}
		
		if (!test.matches("^["+validValues+"]+$")) {
			return false;
		}
		
		return true;
	}
}
