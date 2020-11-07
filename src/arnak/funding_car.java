package arnak;

public class funding_car extends Card
{
	public funding_car(Player owner)
	{
		super(owner);
		
		name = "funding";
		type = "basic";
		travelValue = "c";
		
		freeAction = true;
	}
	
	public void useEffect()
	{
		player.addResource("coin", 1);
	}
}
