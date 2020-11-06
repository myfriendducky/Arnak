package arnak;

public class baseSite_3 extends Site
{
	public baseSite_3()
	{
		setupSpaces("b");
		setupSpaces("bb");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("tablet", 2);
	}
}
