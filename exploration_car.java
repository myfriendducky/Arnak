package arnak;

public class exploration_car extends Card
{
	public exploration_car(Player owner)
	{
		super(owner);
		
		name = "exploration";
		type = "basic";
		travelValue = "c";
		
		freeAction = true;
	}
	
	public void useEffect()
	{
		player.addResource("exploration", 1);
	}
}
