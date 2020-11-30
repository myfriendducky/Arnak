package arnak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestController {

	@Test
	void digASite() {
		
		Player p = new Player("Prabin Newa");
		
		Map<String, Integer> temp = new HashMap<String, Integer>();
		
		Card a = new Card();
		a.setOwner(p);
		a.setInfo("effectID", "none");
		a.setInfo("Type", "Fear");
		temp.put("boot", 1);
		a.setTravelCost(temp);
		
		Card b = new Card();
		b.setOwner(p);
		b.setInfo("effectID", "none");
		b.setInfo("Type", "Fear");
		a.setTravelCost(temp);
		
		Card c = new Card();
		c.setOwner(p);
		c.setInfo("effectID", "1 gold");
		c.setInfo("Type", "Funding");
		temp.clear();
		temp.put("boat", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card d = new Card();
		d.setOwner(p);
		d.setInfo("effectID", "1 gold");
		d.setInfo("Type", "Funding");
		temp.clear();
		temp.put("car", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card e = new Card();
		e.setOwner(p);
		e.setInfo("effectID", "1 compass");
		e.setInfo("Type", "Explore");
		temp.clear();
		temp.put("boat", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card f = new Card();
		f.setOwner(p);
		f.setInfo("effectID", "1 compass");
		f.setInfo("Type", "Explore");
		temp.clear();
		temp.put("car", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		// Add Initial card to deck
		p.addToDeck(a, "top");
		p.addToDeck(b, "top");
		p.addToDeck(c, "top");
		p.addToDeck(d, "top");
		p.addToDeck(e, "top");
		p.addToDeck(f, "top");		
		
		p.shuffle("deck"); // Shufftle deck		
		p.draw(5); // Draw 5 card to the hand for start of game	
		
		// Setup Site
		Site site = new Site(0);		
		site.addSpace("boot", 1);
		site.addSpace("boot", 2);
		site.setEffect("2 jewels");
		
		Assert.assertTrue(site.canAddPlayer());
		
		// Controller
		Controller controller = new Controller();
		controller.digAtSite(p, site);
		Assert.assertEquals(2, 3);
		//p.hand.size()
		controller.digAtSite(p, site);		
		controller.digAtSite(p, site);
		
	
		Assert.assertTrue(site.canAddPlayer());

		Assert.assertTrue(false);
		
	}

}
