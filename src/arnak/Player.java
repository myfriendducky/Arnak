package arnak;

import java.util.ArrayList;
import java.util.Collections;

public class Player
{
	ArrayList<Card> deck = new ArrayList<Card>();
	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> playArea = new ArrayList<Card>();
	
	String name;
	int playOrder;
	boolean hasPassed;
	
	int numCoin;
	int numCompass;
	int numTablet;
	int numArrowhead;
	int numJewel;
	int numArchaeologist;
	
	public Player(String playerName, int order)
	{
		name = playerName;
		playOrder = order;
		hasPassed = false;
		
		numCoin = 0;
		numCompass = 0;
		numTablet = 0;
		numArrowhead = 0;
		numJewel = 0;
		numArchaeologist = 2;
	}
	
	public void addToDeck(Card card, String position)
	{
		if(position == "top")
		{
			deck.add(0, card);
		}
		else if(position == "bottom")
		{
			deck.add(card);
		}
	}
	
	public void addToPlayArea(Card card)
	{
		playArea.add(card);
	}
	
	public void addToHand(Card card)
	{
		hand.add(card);
	}
	
	public void shuffle(String target)
	{
		if(target == "deck")
		{
			Collections.shuffle(deck);
		}
		else if(target == "play area")
		{
			Collections.shuffle(playArea);
		}
	}
	
	public void draw(int numCard)
	{
		for(int i = 0; i < numCard; i++)
		{
			hand.add(deck.get(0));
			deck.remove(0);
		}
	}
	
	public void discard(int i)
	{
		playArea.add(hand.get(i));
		hand.remove(i);
	}
	
	public Card cardAt(int i)
	{
		return hand.get(i);
	}
	
	public int handSize()
	{
		return hand.size();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPlayOrder()
	{
		return playOrder;
	}
	
	public boolean hasPassed()
	{
		return hasPassed;
	}
	
	public void passTurn()
	{
		hasPassed = true;
	}
	
	public int getResource(String resource)
	{
		switch(resource)
		{
		case "coin":
			return numCoin;
		case "compass":
			return numCompass;
		case "tablet":
			return numTablet;
		case "arrowhead":
			return numArrowhead;
		case "jewel":
			return numJewel;
		case "archaeologist":
			return numArchaeologist;
		default:
			break;
		}
		return 0;
	}
	
	public void addResource(String resource, int amount)
	{
		switch(resource)
		{
		case "coin":
			numCoin += amount;
			break;
		case "compass":
			numCompass += amount;
			break;
		case "tablet":
			numTablet += amount;
			break;
		case "arrowhead":
			numArrowhead += amount;
		case "jewel":
			numJewel += amount;
			break;
		case "archaeologist":
			numArchaeologist += amount;
		default:
			break;
		}
	}
	
	public void cleanUp()
	{
		if(--playOrder <= 0)
		{
			playOrder = 4;
		}
		
		hasPassed = false;
	}
}
