package arnak;

public class baseSite_3 extends Site
{
	public baseSite_3()
	{
		addSpace("w");
		addSpace("ww");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("tablet", 2);
	}
}
