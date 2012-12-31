package net.katerberg.roman;

import static net.katerberg.roman.TestingUtil.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

public class NumeralsTest {
	

	@Test
	public void testNumerals_is_singleton() {
		
		String testKey = getRandomString();
		int testValue = getRandomInteger();
		
		Map<String, Integer> testObject = Numerals.getInstance();

		assertNotNull(testObject);
		assertFalse(testObject.containsKey(testKey));
		testObject.put(testKey, testValue);
		assertNotNull(Numerals.getInstance().get(testKey));
	}
	
	
}
