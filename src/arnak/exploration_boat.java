package arnak;

public class exploration_boat extends Card
{
	public exploration_boat(Player owner, Effects effect)
	{
		super(owner, effect);
		
		name = "exploration";
		type = "basic";
		travelValue = "b";
		
		freeAction = true;
	}
}
