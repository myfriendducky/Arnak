package arnak;

public class Card
{
	Player player;
	
	String name;
	String type;
	String travelValue;
	
	boolean freeAction;
	
	public Card(Player owner)
	{
		player = owner;
	}
	
	public Player getOwner()
	{
		return player;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getTravelValue()
	{
		return travelValue;
	}
	
	public boolean isFree()
	{
		return freeAction;
	}
}
