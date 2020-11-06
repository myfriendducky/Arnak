package arnak;

public class baseSite_2 extends Site
{
	public baseSite_2()
	{
		setupSpaces("b");
		setupSpaces("bb");
	}
	
	public void resolveEffect()
	{
		activePlayer.addResource("exploration", 2);
	}
}
