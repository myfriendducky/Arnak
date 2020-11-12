package arnak;

public class Controller
{

	
	public Controller()
	{
		Card a = new Card(new Player ("Prabin", 1), new Effects (1));
		System.out.println(a.getEffects().useEffect());

	}
}
