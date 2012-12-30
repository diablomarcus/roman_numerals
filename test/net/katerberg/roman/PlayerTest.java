package net.katerberg.roman;

import static org.junit.Assert.assertNotNull;

import net.katerberg.roman.Player;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

	Player testObject;
	
	@Before
	public void setUp() {
		testObject = Mockito.mock(Player.class);
	}
	
	@Test
	public void testPlayerSetup() {
		assertNotNull(testObject);
	}

}
