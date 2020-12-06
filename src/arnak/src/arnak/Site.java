package arnak;

import java.util.ArrayList;

public class Site
{
	Player activePlayer;
	
	ArrayList<String> travelCost = new ArrayList<String>();
	ArrayList<Player> occupyingPlayers = new ArrayList<Player>();
	
	public Site()
	{
	}
	
	public void addSpace(String cost)
	{
		travelCost.add(cost);
		occupyingPlayers.add(null);
	}
	
	public int maxSpace()
	{
		return travelCost.size();
	}
	
	public String getTravelCost()
	{
		if(numPlayer() < maxSpace())
		{
			for(int i = 0; i < maxSpace(); i++)
			{
				if(occupyingPlayers.get(i) == null)
				{
					return travelCost.get(i);
				}
			}
		}
		
		return null;
	}
	
	public int numPlayer()
	{
		int playerCount = 0;
		
		for(int i = 0; i < occupyingPlayers.size(); i++)
		{
			if(occupyingPlayers.get(i) != null)
			{
				playerCount++;
			}
		}
		
		return playerCount;
	}
	
	public void addPlayer(Player player)
	{
		if(numPlayer() < maxSpace() && player.getResource("archaeologist") > 0)
		{
			activePlayer = player;
			player.addResource("archaeologist", -1);
			
			for(int i = 0; i < numPlayer(); i++)
			{
				if(occupyingPlayers.get(i) == null)
				{
					occupyingPlayers.add(i, player);
				}
			}
		}
	}
	
	public void removePlayer(int i)
	{
		occupyingPlayers.get(i).addResource("archaeologist", 1);
		occupyingPlayers.add(i, null);
	}
	
	public ArrayList<Player> getOccupyingPlayers()
	{
		return occupyingPlayers;
	}
}
