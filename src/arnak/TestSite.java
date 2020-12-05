package arnak;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestSite {
	
		@Test
	void canAddPlayer() {
	    
		// Setup Site
		Site site = new Site(0);		
		site.addSpace("boot", 1);
		site.addSpace("boot", 2);
		site.addSpace("boot", 3);
		site.setEffect("2 jewels");		
		
		Player player = new Player("Prabin");
		site.addPlayer(player);
		Assert.assertTrue(site.canAddPlayer()); // Space Available
		site.addPlayer(player);
		Assert.assertTrue(site.canAddPlayer());  // Space Available		
		site.addPlayer(player);
		Assert.assertFalse(site.canAddPlayer()); //  // Space Not Avaialble since we already occupied three spaces
				
	}

}
