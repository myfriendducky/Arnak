package arnak;

import java.util.LinkedList;

public class Board
{
	int numOfCoinLeft;
	int numOfCompassLeft;
	int numOfTabletLeft;
	int numOfArrowheadLeft;
	int numOfJewelLeft;
	int numOfArchaeologistLeft;
	
	LinkedList<Integer> itemCardDeck=new LinkedList<Integer>();
	LinkedList<Integer> itemCardRow=new LinkedList<Integer>();
	LinkedList<Integer> artifactsCardDeck=new LinkedList<Integer>();
	LinkedList<Integer> artifactsCardRow=new LinkedList<Integer>();
	
	
	public Board() // Initialize
	{
		numOfCoinLeft = 27;
		numOfCompassLeft = 27;
		numOfTabletLeft = 16;
		numOfArrowheadLeft = 12;
		numOfJewelLeft = 9;
		numOfArchaeologistLeft = 0;	
		
		// Populating Item Card Deck - 35 cards on deck
		for (int x = 1 ; x<=35 ; x++)
			itemCardDeck.add(x);
		
		// Populating Item Card Row - 5 cards on row
		for (int x = 36 ; x<=40 ; x++)
			itemCardRow.add(x);		
		
		// Populating Artifacts Card Deck - 34 cards on deck
		for (int x = 1 ; x<=34 ; x++)
			artifactsCardDeck.add(x);
		
		// Populating Artifacts Card Row - 1 cards on row (1st round)
		for (int x = 35 ; x<=35 ; x++)
			artifactsCardRow.add(x);		
	}
	
	public BoardData pickItemCard (int position) {		
		int pickedCard = 0;
		
		if (itemCardRow.size() > 0) // Make sure Row Card exist before pick
		{
			pickedCard = itemCardRow.remove(position); // Remove card from pick position - gap will be filled by shifting of card from tail side			
			if (itemCardDeck.size() > 0) // Make sure Deck Card exist before pick
				itemCardRow.addLast(itemCardDeck.removeFirst()); // Get new card from Deck and add to tail
		}
		
		return new BoardData (itemCardDeck, itemCardRow, pickedCard);
	}
	
	public int pickArtifactsCard (int position) {
		int pickedCard = artifactsCardRow.remove(position); // Remove card from pick position - gap will be filled by shifting of card from tail side
		artifactsCardRow.addLast(itemCardDeck.removeFirst()); // Get new card from Deck and add to tail
		return pickedCard;
	}
	
	public void addResource(String resource, int amount)
	{
		switch(resource)
		{
		case "coin":
			numOfCoinLeft += amount;
			break;
		case "compass":
			numOfCompassLeft += amount;
			break;
		case "tablet":
			numOfTabletLeft += amount;
			break;
		case "arrowhead":
			numOfArrowheadLeft += amount;
		case "jewel":
			numOfJewelLeft += amount;
			break;
		case "archaeologist":
			numOfArchaeologistLeft += amount;
		default:
			break;
		}
	}
	
	public void subtractResource(String resource, int amount)
	{
		switch(resource)
		{
		case "coin":
			numOfCoinLeft -= amount;
			break;
		case "compass":
			numOfCompassLeft -= amount;
			break;
		case "tablet":
			numOfTabletLeft -= amount;
			break;
		case "arrowhead":
			numOfArrowheadLeft -= amount;
		case "jewel":
			numOfJewelLeft -= amount;
			break;
		case "archaeologist":
			numOfArchaeologistLeft -= amount;
		default:
			break;
		}
	}
	
	
}
