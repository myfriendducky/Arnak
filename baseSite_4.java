package arnak;

public class baseSite_4 extends Site
{
	public baseSite_4()
	{
		addSpace("w");
		addSpace("ww");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("arrowhead", 1);
	}
}
