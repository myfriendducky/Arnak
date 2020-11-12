package arnak;

public class funding_boat extends Card
{
	public funding_boat(Player owner, Effects effect)
	{
		super(owner, effect);
		
		name = "funding";
		type = "basic";
		travelValue = "b";
		
		freeAction = true;
	}
}
