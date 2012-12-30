package net.katerberg.roman;

import static org.junit.Assert.*;
import static net.katerberg.roman.TestingUtil.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ProcessorTest {

	Processor testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new Processor();
	}

	@Test
	public void testProcessor_converts_latin_to_arabic() {
		
		fail(); //Not yet implemented
	}
	
	@Test
	public void testProcessor_converts_arabic_to_latin() {
		fail(); //Not yet implemented
	}
	
	@Test
	public void testProcessor_handles_negatives() {
		int negative = (getRandomInteger(200)+1) * -1;
		
		assertNull(testObject.convert(negative));
	}

	@Test
	public void testProcessor_handles_zero() {
		int zero = 0;
		
		assertNull(testObject.convert(zero));
	}
	
	@Test
	public void testProcessor_handles_null_string() {
		assertNull(testObject.convert(null));
	}
	
	@Test
	public void testProcessor_handles_nonlatin_strings() {
		String randomString;
		Map<Character, Integer> numerals = Numerals.getInstance();
		do {
		 randomString = getRandomString();
		 assertNotNull(randomString);
		 //Make sure this string isn't a valid one
		} while (randomString.isEmpty() || numerals.containsKey(randomString.charAt(0)));
		
		assertNull(testObject.convert(randomString));
	}
	
}
