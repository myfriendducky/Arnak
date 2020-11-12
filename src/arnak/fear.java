package arnak;

public class fear extends Card
{
	public fear(Player owner, Effects effect)
	{
		super(owner, effect);
		
		name = "fear";
		type = "fear";
		travelValue = "b";
		
		freeAction = false;
	}
}
