package arnak;

import java.util.Map;

public class View {
	
	public View(Player player, Board board) {
		System.out.println();
		System.out.println(player.name +  "'s " + "DECK");		
		System.out.println("-----------------------------------");
		System.out.println("TYPE\tTRAVEL\tEFFECT");
		System.out.println("-----------------------------------");
		for (int i = 0; i < player.deck.size(); i++) {			
			
			System.out.print(player.deck.get(i).cardInfo.get("Type") + "\t");
			
			// Accessing travelCost Map entry
	        for (Map.Entry<String,Integer> entry : player.deck.get(i).getTravelCost().entrySet())  
	            System.out.print(entry.getValue() + " " + entry.getKey()); 	
	        
	        System.out.println("\t"+ player.deck.get(i).cardInfo.get("effectID"));
		}

		System.out.println("");
		System.out.println("");
		
		System.out.println(player.name +  "'s " + "HAND");		
		System.out.println("-----------------------------------");
		System.out.println("TYPE\tTRAVEL\tEFFECT");
		System.out.println("-----------------------------------");
		
		for (int i = 0; i < player.hand.size(); i++) {			
			
			System.out.print(player.hand.get(i).cardInfo.get("Type") + "\t");
			
			// Accessing travelCost Map entry
	        for (Map.Entry<String,Integer> entry : player.hand.get(i).getTravelCost().entrySet())  
	            System.out.print(entry.getValue() + " " + entry.getKey()); 	
	        
	        System.out.println("\t"+ player.hand.get(i).cardInfo.get("effectID"));
		}
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(player.name +  "'s " + "PLAY AREA");		
		System.out.println("-----------------------------------");
		System.out.println("TYPE\tTRAVEL\tEFFECT");
		System.out.println("-----------------------------------");
		for (int i = 0; i < player.playArea.size(); i++)
			System.out.println(player.playArea.get(i).cardInfo.get("Type") + "\t" + player.playArea.get(i).cardInfo.get("travelValue") + "\t" + player.playArea.get(i).cardInfo.get("effectID"));
		
		System.out.println("");
		
		System.out.println(player.name +  "'s " + "RESOURCES");			
		System.out.println("-----------------------------------");
		System.out.println("Gold coin: " + player.getResource("coin"));
		System.out.println("Compass: " + player.getResource("compass"));
		System.out.println("Arrowhead: " + player.getResource("arrowhead"));
		System.out.println("Jewel: " + player.getResource("jewel"));
		System.out.println("Archaeologist: " + player.getResource("archaeologist"));
		System.out.println("Tablet: " + player.getResource("tablet"));		
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("RESOURCE LEFT ON BOARD");	
		System.out.println("-----------------------------------");
		System.out.println("Gold coin: " + board.resourceLeft("coin"));
		System.out.println("Compass: " + board.resourceLeft("compass"));
		System.out.println("Arrowhead: " + board.resourceLeft("arrowhead"));
		System.out.println("Jewel: " + board.resourceLeft("jewel"));
		System.out.println("Tablet: " + board.resourceLeft("tablet"));
		
		
	
	
		
	}

}
