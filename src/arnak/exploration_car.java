package arnak;

public class exploration_car extends Card
{
	public exploration_car(Player owner, Effects effect)
	{
		super(owner, effect);
		
		name = "exploration";
		type = "basic";
		travelValue = "c";
		
		freeAction = true;
	}
}
