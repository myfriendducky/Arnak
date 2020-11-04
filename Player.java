package arnak;

public class Player
{
	String playerName;
	int playOrder;
	boolean hasPassed;
	
	int numCoin;
	int numCompass;
	int numTablet;
	int numArrowhead;
	int numJewel;
	
	public Player(String newName, int newPlayOrder)
	{
		playerName = newName;
		playOrder = newPlayOrder;
		hasPassed = false;
		
		numCoin = 0;
		numCompass = 0;
		numTablet = 0;
		numArrowhead = 0;
		numJewel = 0;
	}
	
	public String getPlayerName()
	{
		return playerName;
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
		case "jewel":
			return numJewel;
		default:
			break;
		}
		return 0;
	}
	
	public void setResource(String resource, int amountToAdd)
	{
		switch(resource)
		{
		case "coin":
			numCoin += amountToAdd;
			break;
		case "compass":
			numCompass += amountToAdd;
			break;
		case "tablet":
			numTablet += amountToAdd;
			break;
		case "jewel":
			numJewel += amountToAdd;
			break;
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
