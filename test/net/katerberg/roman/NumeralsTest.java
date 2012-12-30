package net.katerberg.roman;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class NumeralsTest {
	String charVals = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	Random random;
	@Before
	public void setUp() throws Exception {
		random=new Random();
	}

	@Test
	public void testNumerals_is_singleton() {
		
		Character testKey = getRandomCharacter();
		int testValue = random.nextInt();
		
		Map<Character, Integer> testObject = Numerals.getInstance();

		assertNotNull(testObject);
		assertFalse(testObject.containsKey(testKey));
		testObject.put(testKey, testValue);
		assertNotNull(Numerals.getInstance().get(testKey));
	}
	
	private Character getRandomCharacter() {
		return charVals.charAt(random.nextInt(charVals.length()-1));
	}
}
