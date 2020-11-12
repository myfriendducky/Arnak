package arnak;

public class Card
{
	private Player player;
	
	private String name;
	private String type;
	private String travelValue;
	private Effects effect;
	
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
