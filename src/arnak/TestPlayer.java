package arnak;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestPlayer {
	
		@Test
	void cardLeftOnHandAfterDiscard() {
		Card a = new Card();
		Player p = new Player("Prabin Newa");
		
		a.setOwner(p);
		a.setInfo("effectID", "none");
		a.setInfo("Type", "Fear");
		a.setInfo("travelValue", "Boot");
		a.setToFree();
		
		Card b = new Card();
		b.setOwner(p);
		b.setInfo("effectID", "none");
		b.setInfo("Type", "Fear");
		b.setInfo("travelValue", "Boot");
		b.setToFree();
		
		Card c = new Card();
		c.setOwner(p);
		c.setInfo("effectID", "3 gold");
		c.setInfo("Type", "Gold");
		c.setInfo("travelValue", "Ship");
		
		Card d = new Card();
		d.setOwner(p);
		d.setInfo("effectID", "2 gold");
		d.setInfo("Type", "Gold");
		d.setInfo("travelValue", "Ship");
		
		Card e = new Card();
		e.setOwner(p);
		e.setInfo("effectID", "2 compass");
		e.setInfo("Type", "Explore");
		e.setInfo("travelValue", "Ship");
		
		Card f = new Card();
		f.setOwner(p);
		f.setInfo("effectID", "3 compass");
		f.setInfo("Type", "Explore");
		f.setInfo("travelValue", "Ship");
	

		// Add Initial card to deck
		p.addToDeck(a, "top");
		p.addToDeck(b, "top");
		p.addToDeck(c, "top");
		p.addToDeck(d, "top");
		p.addToDeck(e, "top");
		p.addToDeck(f, "top");

		p.shuffle("deck"); // Shufftle deck		
		p.draw(5); // Draw 5 card to the hand for start of game
	
		Assert.assertEquals(p.sizeOf("hand"), 5);
		p.discard(1); // Discard 1st card out of 5 cards
		Assert.assertEquals(p.sizeOf("hand"), 4);
		p.discard(3); // Discard 3rd card out of 4 cards
		Assert.assertEquals(p.sizeOf("hand"), 3);
				
	}

}
