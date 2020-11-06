package arnak;

public class fear extends Card
{
	public fear(Player owner)
	{
		super(owner);
		
		name = "fear";
		type = "fear";
		travelValue = "b";
		
		freeAction = false;
	}
}
