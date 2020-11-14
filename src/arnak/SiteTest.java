package arnak_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SiteTest {

	@Test
	void testGetTravelCost()
	{
		Site site = new Site(0);
		site.addSpace("b", 1);
		site.addSpace("b", 2);
		
		Player p1 = new Player("Bob");
		Player p2 = new Player("Joe");
		
		assertEquals(site.getTravelCost().get("b"), 1);
		
		site.addPlayer(p1);
		
		assertEquals(site.getTravelCost().get("b"), 2);
		
		site.addPlayer(p2);
		site.removePlayer(0);
		
		assertEquals(site.getTravelCost().get("b"), 1);
	}

	@Test
	void testAddAndRemovePlayer()
	{
		Site site = new Site(0);
		site.addSpace("b", 1);
		site.addSpace("b", 2);
		
		Player p1 = new Player("Bob");
		Player p2 = new Player("Joe");
		
		site.addPlayer(p1);
		site.addPlayer(p2);
		
		assertEquals(site.getPlayer(0).getName(), "Bob");
		assertEquals(site.getPlayer(1).getName(), "Joe");
		
		site.removePlayer(1);
		
		assertEquals(site.getPlayer(1), null);
	}
}
