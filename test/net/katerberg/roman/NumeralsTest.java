package net.katerberg.roman;

import static net.katerberg.roman.TestingUtil.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testNumerals_knows_what_strings_are_valid() {
		assertTrue(Numerals.isValidNumeral("D")); //Basic
		assertTrue(Numerals.isValidNumeral("IV")); //Pre-vals
		assertTrue(Numerals.isValidNumeral("CMX")); //Concatenated things
		assertFalse(Numerals.isValidNumeral(null)); //Nulls
		assertFalse(Numerals.isValidNumeral("")); //Blank
		assertFalse(Numerals.isValidNumeral("FXSADF")); //Random chars
		assertFalse(Numerals.isValidNumeral("iv")); //Lowers
		assertFalse(Numerals.isValidNumeral("V13")); //Numerics
		assertFalse(Numerals.isValidNumeral("IIV")); //Double pre-vals
		assertFalse(Numerals.isValidNumeral("IC")); //Weird orderings
	}
	
	
}
