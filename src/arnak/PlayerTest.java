package arnak_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testAddToDeck()
	{
		Player p1 = new Player("Bob");
		
		int round = 0;
		int numCard = 6;
		
		for(int i = 0; i < numCard; i++)
		{
			Card temp = new Card();
			String type = "";
			
			if(i < round + 1)
			{
				type = "artifact";
			}
			else
			{
				type = "item";
			}
			
			temp.setInfo("name", type + i);
			temp.setInfo("type", type);
			p1.addToDeck(temp, "top");
		}
		
		p1.shuffle("deck");
				
		Card c = new Card();
		c.setInfo("name", "test");
		c.setInfo("type", "basic");
		
		p1.addToDeck(c, "top");
		p1.draw(1);
		assertEquals(p1.cardAt("hand", 0).getInfo("name"), "test");
	}
}
