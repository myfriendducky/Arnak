package arnak;

public class baseSite_2 extends Site
{
	public baseSite_2()
	{
		addSpace("w");
		addSpace("ww");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("exploration", 2);
	}
}
