package arnak;

public class Main
{
	public static void main(String[] args)
	{
		Player player = new Player("Bob", 1);
		funding_car a = new funding_car(player);
		System.out.println(a.getName());
		System.out.println(a.getType());
		System.out.println(a.getTravelValue());
	}
}
