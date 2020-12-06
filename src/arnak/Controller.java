package arnak;

import java.util.Scanner;

public class Controller
{

	
	public Controller()
	{
		
		// Setup Board
		Board b = new Board();
		
		// Menu for Number of Players selection
	    System.out.println("============================");
	    System.out.println("|   SELECT NO. OF PLAYERS   |");
	    System.out.println("============================");
	    System.out.println("|        1. Solo Mode       |");
	    System.out.println("|        2. Dual Mode       |");
	    System.out.println("|        3. Exit            |");
	    System.out.println("============================");

        Scanner in = new Scanner(System.in);
        int swValue = in.nextInt();	   
	    switch (swValue) {
	    case 1:
	    	System.out.print("Enter Player Name:"); 
			in = new Scanner(System.in);
			String playerName = in.nextLine();
			
		    Player soloPlayer = new Player (playerName, 1); // Setup Player
		    setupCardForStart(soloPlayer); // Setup Card
		    
		    System.out.print("Enter Card Num to Discard:"); 
			in = new Scanner(System.in);		
			int cardToDiscard = in.nextInt();			
			while (cardToDiscard  < 1 || cardToDiscard > soloPlayer.handSize()) {
				  System.out.print("Invalid entry, try again!"); 
				  in = new Scanner(System.in);		
				  cardToDiscard = in.nextInt();	
			}
		    soloPlayer.discard(cardToDiscard - 1); //Adding 1 to adjust array index start - from 0
	      
		    break;
	    case 2:
	    	System.out.print("Enter First Player Name:"); 
			in = new Scanner(System.in);
			String firstPlayerName = in.nextLine();
			
			System.out.print("Enter Second Player Name:");
			in = new Scanner(System.in);
			String secondPlayerName = in.nextLine();
			
			// Setup Player
			Player firstPlayer = new Player (firstPlayerName, 1);	
			Player secondPlayer = new Player (secondPlayerName, 2);
			
			System.out.println(firstPlayerName);
			System.out.println(secondPlayerName);
	      break;
	    case 3:
	      System.out.println("Exit selected");
	      break;
	    default:
	      System.out.println("Invalid selection");
	    }	

/*	
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
	*/	
	}
	
	public void setupCardForStart (Player p) {

		// Add Initial card to deck
		p.addToDeck(new Card("Fear", "None", "Boot", true), "top");
		p.addToDeck(new Card("Fear", "None", "Boot", true), "top");
		p.addToDeck(new Card("Gold", "Gained 1 Golden coin", "Ship", false), "top");
		p.addToDeck(new Card("Gold", "Gained 1 Golden coin", "Ship", false), "top");
		p.addToDeck(new Card("Exploration", "Gain 1 Compass", "Ship", false), "top");
		p.addToDeck(new Card("Exploration", "Gain 1 Compass", "Ship", false), "top");		
		
		p.shuffle("deck"); // Shufftle deck		
		p.draw(5); // Draw 5 card to the hand for start of game
	
	}
	
}
