package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arnak.Player;
import arnak.Site;

public class SiteTest {

	Site site = null;
	Player playerOne, playerTwo = null;
	
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
		playerOne = new Player("player 1", 1);
		playerTwo = new Player("player 2", 2);
	}
	
	@Test
	public void testGetMaxSpace() {
		site.addSpace("1");
		site.addSpace("2");
		assertTrue(site.maxSpace()==2);
	}
	
	@Test
	public void testGetOccupyingPlayers() {
		site.addPlayer(playerOne);
		site.addPlayer(playerTwo);
		site.addSpace("1");
		site.addSpace("2");
		ArrayList<Player> players = site.getOccupyingPlayers();
		assertNotNull(players);
		assertTrue(players.size()==2);
	}

	@Test
	public void testTravelCost() {
		site.addPlayer(playerOne);
		site.addPlayer(playerTwo);
		site.addSpace("1");
		site.addSpace("2");
		assertNotNull(site.getTravelCost());
	}
	
	@Test
	public void testTravelCostNull() {
		assertNull(site.getTravelCost());
	}
	
	
}
