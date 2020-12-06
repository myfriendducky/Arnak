package arnak;

public class Card
{
	private Player player;
	
	String type;
	String travelValue;
	String effect;
	
	boolean freeAction;
	
	public Card(String type, String travelValue, String effect, boolean freeAction )
	{
		this.type = type;
		this.effect = effect;
		this.travelValue = travelValue;
		this.freeAction = freeAction;
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
	
	public String getEffect() 
	{
		return effect;
	}
}
