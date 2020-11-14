package arnak_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testRefillCardRow()
	{
		Board board = new Board();
		
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
			board.addCard(type, temp);
		}
		
		board.refillCardRow(round + 1);
		
		for(int i = 0; i < numCard; i++)
		{
			String type = "";
			
			if(i < round + 1)
			{
				type = "artifact";
			}
			else
			{
				type = "item";
			}
			
			assertEquals(board.cardAt(i).getInfo("type"), type);
		}
	}
}
