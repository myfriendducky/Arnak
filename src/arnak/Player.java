package arnak_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Player
{
	String name;
	
	Map<String, Integer> resources = new HashMap<String, Integer>();
	
	ArrayList<Card> deck = new ArrayList<Card>();
	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> playArea = new ArrayList<Card>();
	
	public Player(String newName)
	{
		name = newName;
		
		resources.put("coin", 0);
		resources.put("compass", 0);
		resources.put("tablet", 0);
		resources.put("arrowhead", 0);
		resources.put("jewel", 0);
		resources.put("archaeologist", 2);
		resources.put("idolUnused", 0);
		resources.put("idolUsed", 0);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getResource(String resource)
	{
		return resources.get(resource);
	}
	
	public void addResource(String resource, int amount)
	{
		resources.put(resource, resources.get(resource) + amount);
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
			addToHand(deck.get(0));
			deck.remove(0);
		}
	}
	
	public void discard(int target)
	{
		addToPlayArea(hand.get(target));
		hand.remove(target);
	}
	
	public Card cardAt(int target)
	{
		return hand.get(target);
	}
	
	public int sizeOf(String target)
	{
		switch(target)
		{
		case "deck":
			return deck.size();
		case "hand":
			return hand.size();
		case "play area":
			return playArea.size();
		default:
			return 0;
		}
	}
	
	public void useIdol()
	{
		if(getResource("idolUnused") > 0 && getResource("idolUsed") < 4)
		{
			addResource("idolUnused", -1);
			addResource("idolUsed", 1);
		}
	}
}
