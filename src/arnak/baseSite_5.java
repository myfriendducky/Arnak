package arnak;

public class baseSite_5 extends Site
{
	public baseSite_5()
	{
		setupSpaces("b");
		setupSpaces("bb");
	}
	
	public void resolveEffect(int i)
	{
		activePlayer.discard(i);
		activePlayer.addResource("jewel", 1);
	}
}
