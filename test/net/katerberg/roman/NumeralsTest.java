package net.katerberg.roman;

import static org.junit.Assert.*;
import static net.katerberg.roman.TestingUtil.*;

import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class NumeralsTest {
	

	@Test
	public void testNumerals_is_singleton() {
		
		Character testKey = getRandomCharacter();
		int testValue = getRandomInteger();
		
		Map<Character, Integer> testObject = Numerals.getInstance();

		assertNotNull(testObject);
		assertFalse(testObject.containsKey(testKey));
		testObject.put(testKey, testValue);
		assertNotNull(Numerals.getInstance().get(testKey));
	}
	
	
}
