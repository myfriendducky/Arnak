// stores and manipulates data related to the dig sites

package arnak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Site
{
	int level;
	
	Player activePlayer;
	
	Effect effect = new Effect();
	String effectID;
	
	ArrayList<Map<String, Integer>> travelCost = new ArrayList<Map<String, Integer>>();
	ArrayList<Player> players = new ArrayList<Player>();
	
	
	public Site(int newLevel)
	{
		level = newLevel;
	}
	
	// use this when making a site, start with the left most travel cost, then add each travel
	// cost to the site
	public void addSpace(String cost, int amount)
	{
		Map<String, Integer> temp = new HashMap<String, Integer>();
		temp.put(cost, amount);
		travelCost.add(temp);
		players.add(null);
	}
	
	// sets the effectID to the given String
	public void setEffect(String effect)
	{
		effectID = effect;
	}
	
	// gets the travel cost of the first empty space on the site as a Map
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
	
	// gets the number of occupied spaces on the site
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
	
	// adds a player to the site if there is space and sets the player resolveEffect() will work on to
	// the player passed in as argument
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
		activePlayer = player;
	}
	
	// removes a player from the given index on the site
	public void removePlayer(int i)
	{
		players.set(i, null);
	}
	
	// returns a player on the given index on the site
	public Player getPlayer(int i)
	{
		return players.get(i);
	}
	
	// gets what level this site is, 0 for base, 1 for 1, etc
	public int getLevel()
	{
		return level;
	}
	
	// resolves the effect tied to this site on the last player added to this site
	public void resolveEffect()
	{
		effect.resolveEffect(effectID, activePlayer);
	}
}
