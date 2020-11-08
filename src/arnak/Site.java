package arnak_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Site
{
	String name;
	
	ArrayList<Map<String, Integer>> travelCost = new ArrayList<Map<String, Integer>>();
	ArrayList<Player> players = new ArrayList<Player>();
	
	public Site()
	{
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void addSpace(String cost, int amount)
	{
		Map<String, Integer> temp = new HashMap<String, Integer>();
		temp.put(cost, amount);
		
		travelCost.add(temp);
		players.add(null);
	}
	
	public int maxSpace()
	{
		return travelCost.size();
	}
	
	public Map<String, Integer> getTravelCost()
	{
		for(int i = 0; i < maxSpace(); i++)
		{
			if(players.get(i) == null)
			{
				return travelCost.get(i);
			}
		}
		
		return null;
	}
	
	public int numPlayer()
	{
		int temp = 0;
		
		for(int i = 0; i < players.size(); i++)
		{
			if(players.get(i) != null)
			{
				temp++;
			}
		}
		
		return temp;
	}
	
	public void addPlayer(Player player)
	{
		if(numPlayer() < maxSpace())
		{	
			for(int i = 0; i < maxSpace(); i++)
			{
				if(players.get(i) == null)
				{
					players.set(i, player);
					break;
				}
			}
		}
	}
	
	public void removePlayer(int target)
	{
		players.set(target, null);
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
}
