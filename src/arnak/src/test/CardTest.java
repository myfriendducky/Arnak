package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Card;
import arnak.Player;

public class CardTest {

	Card cardOne = null;
	
	@BeforeEach
	void setUp() throws Exception {
		cardOne = new Card("Fear", "None", "Boot", true);
	}
	
	@Test
	public void testGetEffect() {
		assertNotNull(cardOne.getEffect());
		assertEquals("Boot", cardOne.getEffect());
	}
	
	@Test
	public void testGetType() {
		assertNotNull(cardOne.getType());
		assertEquals("Fear", cardOne.getType());
	}
	
	@Test
	public void testGetTravelValue() {
		assertNotNull(cardOne.getTravelValue());
		assertEquals("None", cardOne.getTravelValue());
	}
	
	@Test
	public void testGetFreeAction() {
		assertNotNull(cardOne.isFree());
		assertEquals(true, cardOne.isFree());
	}
	
}
