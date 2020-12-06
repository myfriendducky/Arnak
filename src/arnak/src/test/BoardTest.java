package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Board;
import arnak.Card;

public class BoardTest {

	Board board = null;
	
	@BeforeEach
	void setUp() throws Exception {
		board = new Board();
	}
	
	@Test
	public void testResourcesLeft() {
		board.addResource("coin", 10);
		board.addResource("compass", 20);
		board.addResource("coin", 34);
		board.addResource("compass", 10);
		int coins = board.resourceLeft("coin");
		int compass = board.resourceLeft("compass");
		assertTrue(coins==71);
		assertTrue(compass==57);
	}
		
}
