package arnak;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller
{

	
	public Controller()
	{
		
		// Setup Board and adding Site
		Board board = new Board();
		
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
	    
		// Setup Site
		Site site = new Site(0);		
		site.addSpace("boot", 2);
		site.setEffect("2 jewels");						
	
	    
	    // Games Starts
	    while (true) {
		    playGame(firstPlayer, board, site);
		    playGame (secondPlayer, board, site);
	    }

	    
	}
	
	public void setupCardForPlayer (Player p) {

		Map<String, Integer> travelCostA = new HashMap<String, Integer>();
		Map<String, Integer> travelCostB = new HashMap<String, Integer>();
		Map<String, Integer> travelCostC = new HashMap<String, Integer>();
		Map<String, Integer> travelCostD = new HashMap<String, Integer>();
		Map<String, Integer> travelCostE = new HashMap<String, Integer>();
		Map<String, Integer> travelCostF = new HashMap<String, Integer>();
		
		Card a = new Card();
		a.setOwner(p);
		a.setInfo("effectID", "none");
		a.setInfo("Type", "Fear");
		travelCostA.put("boot", 3);
		a.setTravelCost(travelCostA);

		Card b = new Card();
		b.setOwner(p);
		b.setInfo("effectID", "none");
		b.setInfo("Type", "Fear");
		travelCostB.put("boot", 1);
		b.setTravelCost(travelCostB);
		
		Card c = new Card();
		c.setOwner(p);
		c.setInfo("effectID", "1 gold");
		c.setInfo("Type", "Funding");
		travelCostC.put("ship", 1);
		c.setTravelCost(travelCostC);
		c.setToFree();
		
		Card d = new Card();
		d.setOwner(p);
		d.setInfo("effectID", "1 gold");
		d.setInfo("Type", "Funding");
		travelCostD.put("plane", 1);
		d.setTravelCost(travelCostD);
		d.setToFree();
		
		Card e = new Card();
		e.setOwner(p);
		e.setInfo("effectID", "1 compass");
		e.setInfo("Type", "Explore");
		travelCostE.put("ship", 1);
		e.setTravelCost(travelCostE);
		e.setToFree();
		
		Card f = new Card();
		f.setOwner(p);
		f.setInfo("effectID", "1 compass");
		f.setInfo("Type", "Explore");
		travelCostF.put("plane", 1);
		f.setTravelCost(travelCostF);
		f.setToFree();
		
		
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
	
	public void playGame (Player player, Board board, Site site) 
	{
		
		System.out.print(player.getName() + " > 1) Play Card \t 2) Dig A Site \t 3) Pass :"); 
		Scanner in = new Scanner(System.in);
		Card discardedCard;
		
		// Game Action Selection
		int cardOption = in.nextInt();
		if (cardOption == 1) {		
			
			// Play A Card to resolve an effect
			do { // Free Actions
				discardedCard = discardCard(player, board);
				discardedCard.effect.resolveEffect(discardedCard.getInfo("effectID"), player, board);
				new View(player, board, "resources"); // Update View of Resource to show change of resolvedEffect
			} while (discardedCard.free);
			
		} // Dig A Site to resolve an effect			
		else if (cardOption == 2) {		
			if (site.canAddPlayer()) {
				
				// Printing Site Cost Info
				String[] keySite = site.getTravelCost().keySet().toArray(new String[0]);	
				String siteTravelItem = keySite[0];
				String siteEffect = site.getEffect();
				int siteTravelCost = site.getTravelCost().get(siteTravelItem);
				System.out.println();
				System.out.println("The travel cost of this site is: " + siteTravelCost + " " + siteTravelItem);
				System.out.println("You will gain " + siteEffect + " after as return" );
				
				discardedCard = discardCard(player, board);
				String[] keyCard = discardedCard.getTravelCost().keySet().toArray(new String[0]);
				String cardTravelItem = keyCard[0];
				int cardTravelFund = discardedCard.getTravelCost().get(cardTravelItem);
				
				if (cardTravelFund >= siteTravelCost) {
					player.addResource("archaeologist", -1);
					site.addPlayer(player);
					site.effect.resolveEffect(site.getEffect(), player, board);
					new View(player, board, "resources");				
				} else {
					
					System.out.println("Sorry, looks like you can't go on the site with the cards entered");
					player.Undiscard(discardedCard);// Discard card back to play area as travelFund is not sufficient
				}
			} else {
				System.out.println("Sorry, this site is already occupied!");
			}	
			
			new View(player, board, "playarea");
			new View(player, board, "hand");
				
		}
		else {
			// Pass the turn
			return;
		}				
	}
	
	public Card discardCard (Player player, Board board) {
		Scanner in = new Scanner(System.in);		
		System.out.println();
		System.out.println("Enter Card index to Discard from HAND: ");
		new View(player,board, "hand");
		int cardToDiscard = in.nextInt();			
		while (cardToDiscard  < 0 || cardToDiscard > player.sizeOf("hand") - 1) {
			  System.out.print("Invalid entry, try again!"); 
			  in = new Scanner(System.in);		
			  cardToDiscard = in.nextInt();	
		}
		Card discardedCard = player.discard(cardToDiscard);
		return discardedCard;		
	}	
}