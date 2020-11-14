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
		case "2 gold":
			String resource = "coin";
			int amount = 2;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);
			break;			
		case "2 compass":
			resource = "compass";
			amount = 2;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);	
			break;
		case "3 compass":
			resource = "compass";
			amount = 3;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);	
			break;
		case "3 gold":
			resource = "coin";
			amount = 3;
			target.addResource(resource, amount);	
			board.subtractResource(resource, amount);	
			break;
		default:	
		}	
	}
}
