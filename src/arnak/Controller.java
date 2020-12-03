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
	    
	    // Games Starts
	    while (true) {
		    playGame(firstPlayer, board);
		    playGame (secondPlayer, board);
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
		travelCostA.put("boot", 1);
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
	
	public void playGame (Player player, Board board) 
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

		}			
		else if (cardOption == 2) {
			// Dig A Site to resolve an effect
			
			// Setup Site
			Site site = new Site(0);		
			site.addSpace("boot", 1);
			site.addSpace("boot", 2);
			site.setEffect("2 jewels");			
			
			discardedCard = discardCard(player, board);
			
		//	if (site.canAddPlayer() && discardedCard.getTravelCost().get(key[0])) {
				player.addResource("archaelogist", -1);
				site.addPlayer(player);
				site.resolveEffect();
				new View(player, board, "resources");		
				
		//	}
				
		}
		else {
			// Pass the turn
			return;
		}				
	}
	
	public Card discardCard (Player player, Board board) {
		Scanner in = new Scanner(System.in);		
		System.out.println("Enter Card index to Discard from HAND: ");
		new View(player,board, "hand");
		int cardToDiscard = in.nextInt();			
		while (cardToDiscard  < 0 || cardToDiscard > player.sizeOf("hand") - 1) {
			  System.out.print("Invalid entry, try again!"); 
			  in = new Scanner(System.in);		
			  cardToDiscard = in.nextInt();	
		}
		Card discardedCard = player.discard(cardToDiscard);
		new View(player, board, "playarea");
		return discardedCard;		
	}
	
	public void digAtSite(Player player, Site site)
	{	
		Scanner in = new Scanner(System.in);
		
		String[] key = site.getTravelCost().keySet().toArray(new String[0]);
		
		System.out.println("The travel cost of this site is: " + site.getTravelCost().get(key[0]) + "x " + key[0]);
		System.out.println("Here's your hand: ");
		
		for(int i = 0; i < player.sizeOf("hand"); i++)
		{
			System.out.print("[" + i + "] " + "[Name] " + player.cardAt("hand", i).getInfo("name"));
			System.out.print("    [Type] " + player.cardAt("hand", i).getInfo("Type"));
			System.out.print("    [Travel cost] " + player.cardAt("hand", i).getTravelCost().get(key[0]) + "x " + key[0]);
			System.out.println();
		}
		
		System.out.print("Enter the card number to use it for its travel cost, enter -1 to stop");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		int numEntered;
		do
		{
			numEntered = in.nextInt();
			
			if(numEntered >= 0 && numEntered < player.sizeOf("hand"))
			{
				nums.add(numEntered);
			}
		}while(numEntered >= 0);
		
		int travelFund = 0;
		for(int i = 0; i < nums.size(); i++)
		{
			if(player.cardAt("hand", nums.get(i)).getTravelCost().containsKey(key[0]))
			{
				travelFund += player.cardAt("hand", nums.get(i)).getTravelCost().get(key[0]);
				System.out.println(player.cardAt("hand", nums.get(i)).getTravelCost().get(key[0]));
			}
		}
		
		if(travelFund >= site.getTravelCost().get(key[0]))
		{
			System.out.println("The operation was legal, now I will discard all the cards at the indices you gave");
			
			for(int i = 0; i < nums.size(); i++)
			{
				player.discard(nums.get(i));
			}
		}
		else
		{
			System.out.println("Sorry, looks like you can't go on the site with the cards entered");
			return;
		}
		
		player.addResource("archaelogist", -1);
		site.addPlayer(player);
		site.resolveEffect();
	}
}