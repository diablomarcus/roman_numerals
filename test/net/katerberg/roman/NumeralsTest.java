package net.katerberg.roman;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class NumeralsTest {

	Random random;
	@Before
	public void setUp() throws Exception {
		random=new Random();
	}

	@Test
	public void testNumeralsIsSingleton() {
		
		String testKey = random.nextInt()+"never is there";
		int testValue = random.nextInt();
		
		Map<String, Integer> testObject = Numerals.getInstance();

		assertNotNull(testObject);
		assertFalse(testObject.containsKey(testKey));
		testObject.put(testKey, testValue);
		assertNotNull(Numerals.getInstance().get(testKey));
		
	}

}
