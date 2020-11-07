package arnak;

import java.util.ArrayList;
import java.util.Arrays;

public class Site
{
	Player activePlayer;
	
	int numSpace;
	
	ArrayList<String> travelCost = new ArrayList<String>();
	ArrayList<Player> occupyingPlayers = new ArrayList<Player>();
	
	public Site()
	{
	}
	
	public void setupSpaces(String cost)
	{
		travelCost.add(cost);
		occupyingPlayers.add(null);
		numSpace++;
	}
	
	public String getTravelCost()
	{
		if(occupyingPlayers.size() < numSpace)
		{
			for(int i = 0; i < travelCost.size(); i++)
			{
				if(occupyingPlayers.get(i) == null)
				{
					return travelCost.get(i);
				}
			}
		}
		
		return null;
	}
	
	public void addPlayer(Player player, ArrayList<Integer> cardsToUse)
	{
		if(occupyingPlayers.size() < numSpace && player.getResource("archaeologist") > 0)
		{
			activePlayer = player;
			
			String accumulatedTotal = "";
			for(int i = 0; i < cardsToUse.size(); i++)
			{
				accumulatedTotal += player.getCard(cardsToUse.get(i)).getTravelValue();
			}
			
			char tempAccumulated[] = accumulatedTotal.toCharArray();
			char tempActualCost[] = getTravelCost().toCharArray();
			
			Arrays.sort(tempAccumulated);
			Arrays.sort(tempActualCost);
			
			int startHere = 0;
			int counter = 0;
			for(int i = 0; i < tempActualCost.length; i++)
			{
				for(int j = startHere; j < tempAccumulated.length; j++)
				{
					if(tempActualCost[i] == tempAccumulated[j])
					{
						startHere = j + 1;
						counter++;
						break;
					}
				}
			}
		
			if(counter == tempActualCost.length)
			{
				for(int i = 0; i < cardsToUse.size(); i++)
				{
					player.discard(cardsToUse.get(i));
				}
				
				player.addResource("archaeologist", -1);
				
				for(int i = 0; i < occupyingPlayers.size(); i++)
				{
					if(occupyingPlayers.get(i) == null)
					{
						occupyingPlayers.add(i, player);
					}
				}
			}
		}
	}
	
	public void removePlayer(int i)
	{
		occupyingPlayers.get(i).addResource("archaeologist", 1);
		occupyingPlayers.add(i, null);
	}
}
