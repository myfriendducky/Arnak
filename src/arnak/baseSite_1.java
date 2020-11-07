package arnak;

public class baseSite_1 extends Site
{
	public baseSite_1()
	{
		setupSpaces("b");
		setupSpaces("bb");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("coin", 2);
	}
}
