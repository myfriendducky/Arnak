package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Board;

public class BoardTest {

	Board board = null;
	
	@BeforeEach
	void setUp() throws Exception {
		board = new Board();
	}
	
	@Test
	public void testGetResource() {
		board.addResource("coin", 10);
		board.addResource("compass", 20);
		board.addResource("coin", 34);
		board.addResource("compass", 10);
		int coins = board.getResource("coin");
		int compass = board.getResource("compass");
		assertTrue(coins==71);
		assertTrue(compass==57);
		board.subtractResource("coin", 10);
		board.subtractResource("compass", 10);
		coins = board.getResource("coin");
		compass = board.getResource("compass");
		assertTrue(coins==61);
		assertTrue(compass==47);
	}
	
	@Test
	public void testPickArtifactsCard() {
		int cardId = board.pickArtifactsCard(0);
		assertTrue(cardId==35);
	}
	
	@Test
	public void testPickItemCard() {
		int cardId = board.pickItemCard(0);
		assertTrue(cardId==36);
	}
	
	@Test
	public void testGetItemCardDeck() {
		assertTrue(board.getItemCardDeck().size()==35);
	}
	
	@Test
	public void testGetItemCardRowk() {
		assertTrue(board.getItemCardRow().size()==5);
	}
	
	@Test
	public void testGetArtifactsCardDeck() {
		assertTrue(board.getArtifactsCardDeck().size()==34);
	}
	
	@Test
	public void testGetArtifactsCardRow() {
		assertTrue(board.getArtifactsCardRow().size()==1);
	}
	
	
	
}
