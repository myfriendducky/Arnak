package arnak;

public class funding_car extends Card
{
	public funding_car(Player owner, Effects effect)
	{
		super(owner, effect);
		
		name = "funding";
		type = "basic";
		travelValue = "c";
		
		freeAction = true;
	}
}
