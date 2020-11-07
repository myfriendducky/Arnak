package arnak;

public class baseSite_4 extends Site
{
	public baseSite_4()
	{
		setupSpaces("b");
		setupSpaces("bb");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("arrowhead", 1);
	}
}
