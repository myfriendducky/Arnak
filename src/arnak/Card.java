package arnak;

public class Card
{
	private Player player;
	
	String name;
	String type;
	String travelValue;
	Effects effect;
	
	boolean freeAction;
	
	public Card(Player owner, Effects effect )
	{
		this.player = owner;
		this.effect = effect;
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
	
	public Effects getEffects() 
	{
		return effect;
	}
}
