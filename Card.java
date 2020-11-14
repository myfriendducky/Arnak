package arnak;

import java.util.HashMap;
import java.util.Map;

public class Card
{
	Board board;
	Player owner;
	Effect effect = new Effect();
	
	Map<String, String> cardInfo = new HashMap<String, String>();
	
	boolean free;
	
	public Card()
	{
	}
	
	public void setOwner(Player player)
	{
		owner = player;
	}
	
	public String getInfo(String target)
	{
		return cardInfo.get(target);
	}
	
	public void setInfo(String target, String result)
	{
		cardInfo.put(target, result);
	}
	
	public boolean isFree()
	{
		return free;
	}
	
	public void setFree(boolean flag) 
	{
		free = flag;
	}
	
	public void resolveEffect()
	{
		effect.resolveEffect(getInfo("effectID"), owner, board);
	}
}
