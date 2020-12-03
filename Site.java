package arnak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Site
{
	int level;
	
	Board board;
	
	Effect effect = new Effect();
	String effectID;
	static ArrayList<Map<String, Integer>> playerLocation = new ArrayList<Map<String, Integer>>();
	ArrayList<Map<String, Integer>> travelCost = new ArrayList<Map<String, Integer>>();
	ArrayList<Player> players = new ArrayList<Player>();
	
	
	public Site(int newLevel)
	{
		level = newLevel;
	}
	
	public void addSpace(String cost, int amount)
	{
		Map<String, Integer> temp = new HashMap<String, Integer>();
		temp.put(cost, amount);
		travelCost.add(temp);
		players.add(null);
	}
	
	public void setEffect(String effect)
	{
		effectID = effect;
	}
	
	public Map<String, Integer> getTravelCost()
	{
		if(numPlayer() >= travelCost.size())
		{
			return null;
		}
		
		int i = 0;
		
		while(i < travelCost.size() && players.get(i) != null)
		{
			i++;
		}
		
		return travelCost.get(i);
	}
	
	private int numPlayer()
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
		if(numPlayer() >= travelCost.size())
		{	
			return;
		}
		
		int i = 0;
		
		while(i < players.size() && players.get(i) != null)
		{
			i++;
		}
		
		players.set(i, player);
		effect.resolveEffect(effectID, player, board);
	}
	
	public void removePlayer(int i)
	{
		players.set(i, null);
	}
	
	public Player getPlayer(int i)
	{
		return players.get(i);
	}
	
	public int getLevel()
	{
		return level;
	}
	// working on adding player location management so you can see players movement across the board
	//first we need to be able to find the players location
	
	public static void addLocation(String player, int location)
	{
		
		Map<String, Integer> temp = new HashMap<String, Integer>();
		temp.put(player, location);
		playerLocation.add(temp);
		
		
	}
	public void findLocation(Player player)
	{
		
		
		if(playerLocation.contains(player))
			for (Entry<String, Integer> entry : ((Map<String,Integer>) playerLocation).entrySet()) {
				  String key = entry.getKey();
				  int value = entry.getValue();
				  System.out.println("you are at location " + value);
				}
			else
				 System.out.println("you have not started out yet");
				return;
		
	}
	
}
