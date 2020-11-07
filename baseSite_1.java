package arnak;

public class baseSite_1 extends Site
{
	public baseSite_1()
	{
		addSpace("w");
		addSpace("ww");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("coin", 2);
	}
}
