package net.katerberg.roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Processor {
	private final Map<String, Integer> numerals;
	private final Map<Integer, String> arabics;

	private final List<Integer> descendingValues;
	
	public Processor() {
		numerals = Numerals.getInstance();
		arabics = new HashMap<Integer, String>();
		//This is ugly as hell, but BiDiMap seems to make it even worse.
		for(String value : numerals.keySet()){
			arabics.put(numerals.get(value), value);
		}
		
		//Make sure we have things ordered from biggest to smallest
		descendingValues = new ArrayList<Integer>(numerals.values());
		Collections.sort((List<Integer>)descendingValues);
		Collections.reverse((List<Integer>)descendingValues);
	}
	
	
	/**
	 * Converts a positive integer into the Roman numeral representation of it.
	 * 
	 * @param elementToConvert	Item to convert from Arabic integer to Latin integer
	 * @return 					Converted Latin numeral or NULL if a non-positive value is passed to it
	 */
	public String convert(int elementToConvert) {
		if (elementToConvert <= 0) {
			return null;
		}
		
		StringBuilder latinVal = new StringBuilder();
		for (Integer value : descendingValues) {
			while (elementToConvert / value >= 1){
				elementToConvert -= value;
				latinVal.append(arabics.get(value));
			} 
		}
		
		return latinVal.toString();
	}
	
	
	/**
	 * <p>Converts a Roman numeral into the Arabic integer representation of it.
	 * Assumes input of:</p>
	 * <p>You can combine letters to add values, by listing them largest to smallest from left to right: </p>
	 * 
	 * <p>II is 2</p>
	 * <p>VIII is 8</p>
	 * <p>XXXI is 31</p>
	 *
	 * <p>However, you may only list three consecutive identical letters. That requires a special rule to express numbers like 4 and 900. That rule is that a single lower value may proceed a larger value, to indicate subtraction. This rule is only used to build values not reachable by the previous rules:</p>
	 *
	 * <p>IV is 4</p>
	 * <p>CM is 900</p>
	 *
	 * <p>But 15 is XV, not XVX.</p> 
	 * 
	 * -Thanks to RubyQuiz.com for these rules -
	 * 
	 * @param elementToConvert	Item to convert from Latin integer to Arabic integer
	 * @return					Converted Arabic integer or NULL if blatantly invalid value is passed to it
	 */
	public Integer convert(String elementToConvert) {
		if (!Numerals.isValidNumeral(elementToConvert)) {
			return null;
		}

		//I'm not a huge fan of this bit. It feels like it should be better devolved into objects
		Integer returnVal = 0;
		while(!elementToConvert.isEmpty()){
			for (Integer value : descendingValues) {
				String prefixToCheck = arabics.get(value);
				if (elementToConvert.startsWith(prefixToCheck)) {
					returnVal += value;
					//Cut off the piece we just used
					elementToConvert = elementToConvert.substring(prefixToCheck.length(), elementToConvert.length());
				}
			}	
		}
		return returnVal;
	}
	
}
