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
			itemCardRow.add(x);		
	}
	
	public void pickItemCard (int position) {
		itemCardRow.remove(position);
		itemCardRow.addLast(itemCardDeck.removeFirst());		
	}
	
	public void pickArtifactsCard (int position) {
		artifactsCardRow.remove(position);
		artifactsCardRow.addLast(itemCardDeck.removeFirst());		
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
