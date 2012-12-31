package net.katerberg.roman;

import static org.junit.Assert.*;
import static net.katerberg.roman.TestingUtil.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ProcessorTest {

	private Processor testObject;
	private final Map<String, Integer> testCases= new HashMap<String, Integer>();
	
	@Before
	public void setUp() throws Exception {
		testObject = new Processor();
		
		createTestCases();
	}

	@Test
	public void testProcessor_converts_latin_to_arabic() {
		
		for(String testCase : testCases.keySet()){
			assertEquals(testCases.get(testCase), testObject.convert(testCase));
		}
	}
	
	@Test
	public void testProcessor_converts_arabic_to_latin() {
		
		for(Integer testCase : testCases.values()){
			String returnVal = testObject.convert(testCase);
			assertTrue("Returned " + returnVal + " for " + testCase + " rather than the right answer", testCases.containsKey(returnVal));
			assertEquals(testCase, testCases.get(returnVal));
		}
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
	
	
	private void createTestCases() {
		//These aren't meant to be comprehensive, just a few basic test cases
		testCases.clear();
		testCases.put("I", 1);
		testCases.put("III", 1);
		testCases.put("IV", 4);
		testCases.put("VI", 6);
		testCases.put("DCII", 602);
		testCases.put("MCMLIV", 1954);
	}
}
