package net.katerberg.roman;

import java.util.Random;

public class TestingUtil {
	private final static String charVals = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	private final static Random random = new Random();
	
	public static int getRandomInteger(){
		return random.nextInt();
	}
	public static Integer getRandomInteger(int maxPositiveValue){
		if (maxPositiveValue < 1) {
			return null;
		}
		
		return random.nextInt(maxPositiveValue);
	}
	
	public static String getRandomString() {
		StringBuilder returnVal = new StringBuilder();
		for (int i=0; i<random.nextInt(200)+10; i++){
			returnVal.append(getRandomCharacter());
		}
		return returnVal.toString();
	}
	
	public static char getRandomCharacter() {
		return charVals.charAt(random.nextInt(charVals.length()-1));
	}
	
	
}
