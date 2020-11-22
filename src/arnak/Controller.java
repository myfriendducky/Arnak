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
		
		// Adding items and artifacts card to board deck/row
		for (int i = 0; i < 40; i++)
			board.addCard("item", new Card());
		for (int i = 0; i < 35; i++)
			board.addCard("artifact", new Card());
		board.refillCardRow(1);		
		
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

		Map<String, Integer> temp = new HashMap<String, Integer>();
		
		Card a = new Card();
		a.setOwner(p);
		a.setInfo("effectID", "none");
		a.setInfo("Type", "Fear");
		temp.put("boot", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card b = new Card();
		b.setOwner(p);
		b.setInfo("effectID", "none");
		b.setInfo("Type", "Fear");
		a.setTravelCost(temp);
		a.setToFree();
		
		Card c = new Card();
		c.setOwner(p);
		c.setInfo("effectID", "3 gold");
		c.setInfo("Type", "Gold");
		temp.clear();
		temp.put("ship", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card d = new Card();
		d.setOwner(p);
		d.setInfo("effectID", "2 gold");
		d.setInfo("Type", "Gold");
		temp.clear();
		temp.put("ship", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card e = new Card();
		e.setOwner(p);
		e.setInfo("effectID", "2 compass");
		e.setInfo("Type", "Explore");
		temp.clear();
		temp.put("ship", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		Card f = new Card();
		f.setOwner(p);
		f.setInfo("effectID", "3 compass");
		f.setInfo("Type", "Explore");
		temp.clear();
		temp.put("ship", 1);
		a.setTravelCost(temp);
		a.setToFree();
		
		
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
		
		System.out.print(player.getName() + " > Enter Card Num to Discard from HAND:"); 
		Scanner in = new Scanner(System.in);
		in = new Scanner(System.in);		
		int cardToDiscard = in.nextInt();			
		while (cardToDiscard  < 1 || cardToDiscard > player.sizeOf("hand")) {
			  System.out.print("Invalid entry, try again!"); 
			  in = new Scanner(System.in);		
			  cardToDiscard = in.nextInt();	
		}		    
		
		Card discardCard = player.discard(cardToDiscard - 1); //Adjusting 1 for Array index start value
		
		System.out.println(player.getName() +  "'s " + "DISCARDED CARD");		
		System.out.println("-----------------------------------");
		System.out.println("TYPE\tTRAVEL\tEFFECT");
		System.out.println("-----------------------------------");
		System.out.println(discardCard.cardInfo.get("Type") + "\t" + discardCard.cardInfo.get("travelValue") + "\t" + discardCard.cardInfo.get("effectID"));
		System.out.println("");
		
		// Effect option availalble only for card except Fear
		if (discardCard.cardInfo.get("Type") != "Fear")
			System.out.println(player.getName() + "> Select 1 for gaining: "+ discardCard.cardInfo.get("effectID"));
		
		System.out.println(player.getName() + "> Select 2 for Travel-Value of: "+ discardCard.cardInfo.get("travelValue"));
		
		int cardOption = in.nextInt();
		if (cardOption == 1)
			discardCard.effect.resolveEffect(discardCard.getInfo("effectID"), player, board);
		
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
			System.out.print("    [Type] " + player.cardAt("hand", i).getInfo("type"));
			System.out.print("    [Travel cost] " + player.cardAt("hand", i).getInfo("travel cost"));
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