// stores and manipulates data related to the board

package arnak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board
{
	Map<String, Integer> resourcesLeft = new HashMap<String, Integer>();
	
	ArrayList<Card> items = new ArrayList<Card>();
	ArrayList<Card> artifacts = new ArrayList<Card>();
	
	Card cardRow[] = {null, null, null, null, null, null};
	
	ArrayList<Site> sites = new ArrayList<Site>();
	
	public Board()
	{
		resourcesLeft.put("coin", 27);
		resourcesLeft.put("compass", 27);
		resourcesLeft.put("tablet", 16);
		resourcesLeft.put("arrowhead", 12);
		resourcesLeft.put("jewel", 9);
	}
	
	// gets the amount of the resource, given in String, still left on the board
	public int resourceLeft(String resource)
	{
		return resourcesLeft.get(resource);
	}
	
	// adds an amount of the resource, given in String, to the total amount of that resource
	// left on the board
	public void addResource(String resource, int amount)
	{
		resourcesLeft.put(resource, resourcesLeft.get(resource) + amount);
	}
	
	// substracts an amount of the resource, given in String, to the total amount of that resource
	// left on the board
	public void subtractResource(String resource, int amount)
	{
		resourcesLeft.put(resource, resourcesLeft.get(resource) - amount);
	}
	
	
	// adds the given card to either the artifact or the item deck
	
	public void addCard(String type, Card card)
	{
		switch(type)
		{
		case "item":
			items.add(card);
			return;
		case "artifact":
			artifacts.add(card);
			return;
		default:
			return;	
		}
	}
	
	// for each empty space on the card row, adds either an random artifact or an item
	// to that space from the artifact or the item deck, the artifact or item placement
	// changes depending on which round is passed in as an argument
	
	public void refillCardRow(int round)
	{
		Random rand = new Random();
		
		for(int i = 0; i < cardRow.length; i++)
		{
			if(cardRow[i] == null)
			{
				int cardPos;
				
				if(i < round)
				{
					cardPos = rand.nextInt(artifacts.size());
					cardRow[i] = artifacts.get(cardPos);
					artifacts.remove(cardPos);
				}
				else if(i >= round)
				{
					cardPos = rand.nextInt(items.size());
					cardRow[i] = items.get(cardPos);
					items.remove(cardPos);
				}
			}
		}
	}
	
	// removes the card at the given index on the card row
	public void removeCard(int i)
	{
		cardRow[i] = null;
	}
	
	// gets the card at the given index on the card row
	public Card cardAt(int i)
	{
		return cardRow[i];
	}
	
	// adds a site
	public void addSite(Site site)
	{
		sites.add(site);
	}
	
	// gets the site on the given index
	public Site getSite(int i)
	{
		return sites.get(i);
	}
}
