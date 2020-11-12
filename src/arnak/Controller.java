package arnak;

public class Controller
{

	
	public Controller()
	{
		
		// Setup Board
		Board b = new Board();
		
		// Setup Player
		Player Prabin = new Player ("Prabin Newa", 1);	
		Player Ducky = new Player ("Ducky Bro", 2);		
		
		// Setup up card for Players 
		Card a1 = new Card("Fear", "None", "Boot", true);
		Card a2 = new Card("Fear", "None", "Boot", true);
		Card a3 = new Card("Gold", "Gained 1 Golden coin", "Ship", false);
		Card a4 = new Card("Gold", "Gained 1 Golden coin", "Ship", false);
		Card a5 = new Card("Exploration", "Gain 1 Compass", "Ship", false);
		Card a6 = new Card("Exploration", "Gain 1 Compass", "Ship", false);

		// Add Initial card to deck
		Prabin.addToDeck(a1, "top");
		Prabin.addToDeck(a2, "top");
		Prabin.addToDeck(a3, "top");
		Prabin.addToDeck(a4, "top");
		Prabin.addToDeck(a5, "top");
		Prabin.addToDeck(a6, "top");		
		
		Prabin.shuffle("deck"); // Shufftle deck		
		Prabin.draw(5); // Draw 5 card to the hand for start of game
		Prabin.discard(3);
	
	
		System.out.println("DECK");		
		System.out.println("-----------------------------------");
		for (int i = 0; i < Prabin.deck.size(); i++)
			System.out.println(Prabin.deck.get(i).type);
		System.out.println("");
		System.out.println("");
	
		System.out.println("HAND");		
		System.out.println("-----------------------------------");
		
		for (int i = 0; i < Prabin.hand.size(); i++)
			System.out.println(Prabin.hand.get(i).type);
		System.out.println("");
		System.out.println("");
		
		System.out.println("PLAY AREA");	
		System.out.println("-----------------------------------");
		
		for (int i = 0; i < Prabin.playArea.size(); i++)
			System.out.println(Prabin.playArea.get(i).type);

	}
}
