// stores and manipulates data related to the player

package arnak;

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
	
	// gets the player's name
	public String getName()
	{
		return name;
	}
	
	// gets how many of the given resource the player has
	public int getResource(String resource)
	{
		return resources.get(resource);
	}
	
	// adds an amount of the resource, given in String, to the total resource count
	public void addResource(String resource, int amount)
	{
		resources.put(resource, resources.get(resource) + amount);
	}
	
	// adds the given card to either the top or bottom or the deck, depending on position
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
	
	// adds the given card to the play area
	public void addToPlayArea(Card card)
	{
		playArea.add(card);
	}
	
	// adds the given card to hand
	public void addToHand(Card card)
	{
		hand.add(card);
	}
	
	// shuffles either the deck or the play area, depending on target
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
	
	// draws [numCard] numbers of cards from the deck
	public void draw(int numCard)
	{
		for(int i = 0; i < numCard; i++)
		{
			addToHand(deck.get(0));
			deck.remove(0);
		}
	}
	
	// discards a card from the player's hand, depending on the index
	public Card discard(int target)
	{
		Card card = hand.get(target);
		addToPlayArea(card);
		hand.remove(target);
		return card;
	}
	
	// gets a card from the player's deck, play area, or hand, depending on the index
	public Card cardAt(String target, int index)
	{
		switch(target)
		{
		case "deck":
			return deck.get(index);
		case "hand":
			return hand.get(index);
		case "play area":
			return playArea.get(index);
		default:
			return null;
		}
	}
	
	// removes a card from the player's deck, play area, or hand, depending on the index
	public Card removeCard(String target, int index)
	{
		switch(target)
		{
		case "deck":
			return deck.remove(index);
		case "hand":
			return hand.remove(index);
		case "play area":
			return playArea.remove(index);
		default:
			return null;
		}
	}
	
	// gets the size of either the deck, hand, or play area
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
	
	// uses up an unused idol and adds to the total number of used idols
	public void useIdol()
	{
		if(getResource("idolUnused") > 0 && getResource("idolUsed") < 4)
		{
			addResource("idolUnused", -1);
			addResource("idolUsed", 1);
		}
	}
}
