package arnak;

public class baseSite_5 extends Site
{
	public baseSite_5()
	{
		addSpace("w");
		addSpace("ww");
	}
	
	public void resolveEffect(int i)
	{
		activePlayer.discard(i);
		activePlayer.addResource("jewel", 1);
	}
}
