package test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Card;
import arnak.Player;

public class CardTest {

	Player player = null;
	Card cardOne = null;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player("player 2", 2);
		cardOne = new Card(player);
	}
	
	@Test
	public void testGetPlayer() {
		assertNotNull(cardOne.getOwner());
	}
	
}
