package arnak;

import java.util.Scanner;

public class Controller
{

	
	public Controller()
	{
		
		// Setup Board and adding Site
		Board board = new Board();
		
		// Adding items and artifacts card to board deck/row
		for (int i = 0; i < 40; i++)
			board.addCard("item", new Card());
		for (int i = 0; i < 35; i++)
			board.addCard("artifact", new Card());
		board.refillCardRow(1);
		
		
		Site site1 = new Site(1);
		site1.addSpace("level1", 2);
		//site1.addPlayer(new Player("takku"));		
		board.addSite(new Site(1));
		board.addSite(new Site(2));
		board.addSite(new Site(3));
		
		// Initial Card setup for players
		
		Scanner in = new Scanner(System.in);
    	System.out.print("Enter Player1 Name:"); 
		in = new Scanner(System.in);
		String firstPlayerName = in.nextLine();
		
	 	System.out.print("Enter Player2 Name:"); 
		in = new Scanner(System.in);
		String secondPlayerName = in.nextLine();	
		System.out.println();
	
	    Player firstPlayer = new Player (firstPlayerName);
	    setupCardForPlayer(firstPlayer);
	    Player secondPlayer = new Player (secondPlayerName);
	    setupCardForPlayer(secondPlayer);	    
	    
	    // Games Starts
	    while (true) {
		    playGame(firstPlayer, board);
		    playGame (secondPlayer, board);
	    }

	    
	}
	
	public void setupCardForPlayer (Player p) {

		Card a = new Card();
		a.setOwner(p);
		a.setInfo("effectID", "none");
		a.setInfo("Type", "Fear");
		a.setInfo("travelValue", "Boot");
		a.setFree(true);
		
		Card b = new Card();
		b.setOwner(p);
		b.setInfo("effectID", "none");
		b.setInfo("Type", "Fear");
		b.setInfo("travelValue", "Boot");
		b.setFree(true);
		
		Card c = new Card();
		c.setOwner(p);
		c.setInfo("effectID", "3 gold");
		c.setInfo("Type", "Gold");
		c.setInfo("travelValue", "Ship");
		c.setFree(false);
		
		Card d = new Card();
		d.setOwner(p);
		d.setInfo("effectID", "2 gold");
		d.setInfo("Type", "Gold");
		d.setInfo("travelValue", "Ship");
		d.setFree(false);
		
		Card e = new Card();
		e.setOwner(p);
		e.setInfo("effectID", "2 compass");
		e.setInfo("Type", "Explore");
		e.setInfo("travelValue", "Ship");
		e.setFree(false);
		
		Card f = new Card();
		f.setOwner(p);
		f.setInfo("effectID", "3 compass");
		f.setInfo("Type", "Explore");
		f.setInfo("travelValue", "Ship");
		f.setFree(false);
		
		
		//p.addToDeck(card, position);
		// Add Initial card to deck
		p.addToDeck(a, "top");
		p.addToDeck(b, "top");
		p.addToDeck(c, "top");
		p.addToDeck(d, "top");
		p.addToDeck(e, "top");
		p.addToDeck(f, "top");
		
		
		p.shuffle("deck"); // Shufftle deck		
		p.draw(5); // Draw 5 card to the hand for start of game
	
	}
	
	public void playGame (Player player, Board board) 
	{
		View v = new View(player,board); // Update View
		System.out.println("");		
		
		System.out.print(player.getName() + " > Enter Card Num to Discard:"); 
		Scanner in = new Scanner(System.in);
		in = new Scanner(System.in);		
		int cardToDiscard = in.nextInt();			
		while (cardToDiscard  < 1 || cardToDiscard > player.sizeOf("hand")) {
			  System.out.print("Invalid entry, try again!"); 
			  in = new Scanner(System.in);		
			  cardToDiscard = in.nextInt();	
		}		    
		
		Card discardCard = player.discard(cardToDiscard - 1); //Adjusting 1 for Array index start value
		
		System.out.println(player.getName() + "> Discarded card: " + discardCard.cardInfo.get("Type") + "\t" + discardCard.cardInfo.get("travelValue") + "\t" + discardCard.cardInfo.get("effectID")); 
		
		// Effect option availalble only for card except Fear
		if (discardCard.cardInfo.get("Type") != "Fear")
			System.out.println("Select 1 for gaining: "+ discardCard.cardInfo.get("effectID"));
		
		System.out.println("Select 2 for Travel-Value of: "+ discardCard.cardInfo.get("travelValue"));
		
		int cardOption = in.nextInt();
		if (cardOption == 1)
			discardCard.effect.resolveEffect(discardCard.getInfo("effectID"), player, board);	    
	}
	
}
