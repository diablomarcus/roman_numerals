package net.katerberg.roman;

import static org.junit.Assert.*;
import static net.katerberg.roman.TestingUtil.*;

import org.junit.Before;
import org.junit.Test;

public class ProcessorTest {

	Processor testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new Processor();
	}

	@Test
	public void testProcessor_has_valid_methods() {
		assertNotNull(testObject.convert(getRandomInteger(1000)+1));
		assertNotNull(testObject.convert(getRandomString()));
	}
	
	@Test
	public void testProcessor_converts_latin_to_arabic() {
		fail(); //Not yet implemented
	}
	
	@Test
	public void testProcessor_converts_arabic_to_latin() {
		fail(); //Not yet implemented
	}
}
