package arnak;

public class Main
{
	public static void main(String[] args)
	{
		//Player player = new Player("Bob", 1);
		//funding_car a = new funding_car(player);
		//System.out.println(a.getName());
		//System.out.println(a.getType());
		//System.out.println(a.getTravelValue());
		
		Board c = new Board();
		BoardData b;
		
		b = c.pickItemCard(2);	
		System.out.println("Card Deck");
		for (int x=0; x < b.itemCardDeckLeft.size(); x++)
			System.out.println(b.itemCardDeckLeft.get(x));
		System.out.println();
		System.out.println("Card Row");
		for (int x=0; x < b.itemCardRowLeft.size(); x++)
			System.out.println(b.itemCardRowLeft.get(x));
		System.out.println();
		System.out.println("Picked Card");
		System.out.println(b.pickedCard);
		
		b = c.pickItemCard(2);	
		System.out.println("Card Deck");
		for (int x=0; x < b.itemCardDeckLeft.size(); x++)
			System.out.println(b.itemCardDeckLeft.get(x));
		System.out.println();
		System.out.println("Card Row");
		for (int x=0; x < b.itemCardRowLeft.size(); x++)
			System.out.println(b.itemCardRowLeft.get(x));
		System.out.println();
		System.out.println("Picked Card");
		System.out.println(b.pickedCard);
		
		b = c.pickItemCard(4);	
		System.out.println("Card Deck");
		for (int x=0; x < b.itemCardDeckLeft.size(); x++)
			System.out.println(b.itemCardDeckLeft.get(x));
		System.out.println();
		System.out.println("Card Row");
		for (int x=0; x < b.itemCardRowLeft.size(); x++)
			System.out.println(b.itemCardRowLeft.get(x));
		System.out.println();
		System.out.println("Picked Card");
		System.out.println(b.pickedCard);


	}
}
