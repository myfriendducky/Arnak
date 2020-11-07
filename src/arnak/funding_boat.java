package arnak;

public class funding_boat extends Card
{
	public funding_boat(Player owner)
	{
		super(owner);
		
		name = "funding";
		type = "basic";
		travelValue = "b";
		
		freeAction = true;
	}
}
