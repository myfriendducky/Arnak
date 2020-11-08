package arnak;

import java.util.LinkedList;

public class Board
{
	private int numOfCoinLeft;
	private int numOfCompassLeft;
	private int numOfTabletLeft;
	private int numOfArrowheadLeft;
	private int numOfJewelLeft;
	private int numOfArchaeologistLeft;
	
	private LinkedList<Integer> itemCardDeck=new LinkedList<Integer>();
	private LinkedList<Integer> itemCardRow=new LinkedList<Integer>();
	private LinkedList<Integer> artifactsCardDeck=new LinkedList<Integer>();
	private LinkedList<Integer> artifactsCardRow=new LinkedList<Integer>();
	
	
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
	
	public int pickItemCard (int position) {		
		int pickedCard = 0;
		
		if (itemCardRow.size() > 0) // Make sure Row Card exist before pick
		{
			pickedCard = itemCardRow.remove(position); // Remove card from pick position - gap will be filled by shifting of card from tail side			
			if (itemCardDeck.size() > 0) // Make sure Deck Card exist before pick
				itemCardRow.addLast(itemCardDeck.removeFirst()); // Get new card from Deck and add to tail
		}
		
		return pickedCard;
	}
	
	public int pickArtifactsCard (int position) {
		int pickedCard = 0;
		
		if (artifactsCardRow.size() > 0) // Make sure Row Card exist before pick
		{
			pickedCard = artifactsCardRow.remove(position); // Remove card from pick position - gap will be filled by shifting of card from tail side			
			if (artifactsCardDeck.size() > 0) // Make sure Deck Card exist before pick
				artifactsCardRow.addLast(artifactsCardDeck.removeFirst()); // Get new card from Deck and add to tail
		}
		
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
	
	public int getResource(String resource)
	{
		switch(resource)
		{
		case "coin":
			return numOfCoinLeft;
		case "compass":
			return numOfCompassLeft;
		case "tablet":
			return numOfTabletLeft;
		case "arrowhead":
			return numOfArrowheadLeft;
		case "jewel":
			return numOfJewelLeft;
		case "archaeologist":
			return numOfArchaeologistLeft;
		default:
			break;
		}
		return 0;
	}
	
	public LinkedList<Integer> getItemCardDeck() {
		return itemCardDeck;
	}
	
	public LinkedList<Integer> getItemCardRow() {
		return itemCardRow;
	}
	
	public LinkedList<Integer> getArtifactsCardDeck() {
		return artifactsCardDeck;
	}
	
	public LinkedList<Integer> getArtifactsCardRow() {
		return artifactsCardRow;
	}
	
	
	
	
}
