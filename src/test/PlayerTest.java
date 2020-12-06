package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Card;
import arnak.Player;

class PlayerTest {

	
	Player player = null;
	Card cardOne,cardTwo = null;
	
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player("player 1", 1);
		cardOne = new Card("Fear", "None", "Boot", true);
		cardTwo = new Card("Fear", "None", "Boot", true);
		player.addToHand(cardOne);
		player.addToHand(cardTwo);
	}

	@Test
	void testCardAt() {
		Card cardAtIndexZero = player.cardAt(0);
		Card cardAtIndexOne = player.cardAt(1);
		Assertions.assertNotNull(cardAtIndexOne);
		Assertions.assertNotNull(cardAtIndexZero);
	}

	

	@Test
	public void testHandSize() {
		int size = player.handSize();
		assertTrue(size==2);
	}
	
	@Test
	public void testGetName() {
		assertTrue(player.getName().equals("player 1"));
	}
	
	@Test
	public void testPlayerOrder() {
		assertTrue(player.getPlayOrder()==1);
	}
	
	@Test
	public void testPlayerGetResource() {
		player.addResource("coin", 10);
		player.addResource("compass", 20);
		player.addResource("coin", 34);
		player.addResource("compass", 10);
		int coins = player.getResource("coin");
		int compass = player.getResource("compass");
		assertTrue(coins==44);
		assertTrue(compass==30);
	}
	
	@Test
	public void testCleanUp() {
		player.cleanUp();
		boolean hasPassed = player.hasPassed();
		assertFalse(hasPassed);
	}
	
}
