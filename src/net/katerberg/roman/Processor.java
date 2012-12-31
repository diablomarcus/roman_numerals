package net.katerberg.roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {
	//TODO: Make this bidirectional
	Map<String, Integer> numerals;
	Map<Integer, String> arabics;
	
	public Processor() {
		numerals = Numerals.getInstance();
		arabics = new HashMap<Integer, String>();
		//This is ugly as hell, but I need BiMap or BiDiMap to make it cleaner.
		for(String value : numerals.keySet()){
			arabics.put(numerals.get(value), value);
		}
		
	}

	public String convert(int unconverted) {
		List<Integer> sortedVals = new ArrayList<Integer>(numerals.values());
		Collections.sort((List<Integer>)sortedVals);
		Collections.reverse((List<Integer>)sortedVals);
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
