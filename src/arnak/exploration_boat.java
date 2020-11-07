package arnak;

public class exploration_boat extends Card
{
	public exploration_boat(Player owner)
	{
		super(owner);
		
		name = "exploration";
		type = "basic";
		travelValue = "b";
		
		freeAction = true;
	}
}
