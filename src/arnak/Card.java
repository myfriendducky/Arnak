// stores and manipulates data related to cards

package arnak_test;

import java.util.HashMap;
import java.util.Map;

public class Card
{
	Player owner;
	Effect effect = new Effect();
	
	Map<String, String> cardInfo = new HashMap<String, String>();
	
	boolean free;
	
	public Card()
	{
		free = false;
	}
	
	// sets the owner this card belongs to, should be used when giving out this card to a player
	public void setOwner(Player player)
	{
		owner = player;
	}
	
	// pass in a String and get the appropriate info stored on the card
	public String getInfo(String target)
	{
		return cardInfo.get(target);
	}
	
	// sets the info to the target, for example, set "name" to "funding", by default there's no info on
	// the card, so this should be used when making a card. Also, make sure one of the info stored is
	// called "effectID" and that should be storing a String of the effect this card is tied to
	public void setInfo(String target, String result)
	{
		cardInfo.put(target, result);
	}
	
	// sets the card's effect to free action, by default it's not free
	public void setToFree()
	{
		free = true;
	}
	
	// gives back whether this card's effect is a free action
	public boolean isFree()
	{
		return free;
	}
	
	// uses the effect this card is attached to
	public void resolveEffect()
	{
		effect.resolveEffect(getInfo("effectID"), owner);
	}
}
