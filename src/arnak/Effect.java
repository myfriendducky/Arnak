package arnak;

public class Effect
{
	public Effect()
	{
	}
	
	public void resolveEffect(String effectID, Player target, Board board)
	{
		switch(effectID)
		{
		case "1 gold":
			String resource = "coin";
			int amount = 1;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);
			break;			
		case "1 compass":
			resource = "compass";
			amount = 1;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);	
			break;
		case "2  jewels":
			resource = "jewel";
			amount = 2;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);	
			break;
		case "2 tablets":
			resource = "tablet";
			amount = 2;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);	
			break;
		default:	
		}	
	}
}
