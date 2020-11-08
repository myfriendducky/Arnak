package arnak_test;

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
	
	ArrayList<ArrayList<Site>> sites = new ArrayList<ArrayList<Site>>();
	
	public Board()
	{
		resourcesLeft.put("coin", 27);
		resourcesLeft.put("compass", 27);
		resourcesLeft.put("tablet", 16);
		resourcesLeft.put("arrowhead", 12);
		resourcesLeft.put("jewel", 9);
	}
	
	public int resourceLeft(String resource)
	{
		return resourcesLeft.get(resource);
	}
	
	public void addResource(String resource, int amount)
	{
		resourcesLeft.put(resource, resourcesLeft.get(resource) + amount);
	}
	
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
	
	public void removeCard(int i)
	{
		cardRow[i] = null;
	}
	
	public Card cardAt(int i)
	{
		return cardRow[i];
	}
	
	public void addSite(int level, Site site)
	{
		
	}
}
