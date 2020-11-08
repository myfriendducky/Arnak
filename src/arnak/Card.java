package arnak_test;

import java.util.HashMap;
import java.util.Map;

public class Card
{
	Map<String, String> cardInfo = new HashMap<String, String>();
	
	boolean free;
	
	public Card()
	{
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
}
