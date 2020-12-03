package arnak;

import java.util.ArrayList;
import java.util.Map;

public class View {
	
	public View(Player player, Board board, String viewType) {	
		
		switch (viewType) {
		case "deck":
			updateCardsView(player.name, player.deck, "DECK");
			break;
		case "hand":
			updateCardsView(player.name, player.hand, "HAND");
			break;
		case "playarea":
			updateCardsView(player.name, player.playArea, "PLAY-AREA");
			break;
		case "resources":
			updateResourcesView(player, board);
			break;
		}
	}
	
	// Update Card List View
	public void updateCardsView(String playerName, ArrayList<Card> cardList,  String cardListType) {
		
		System.out.println();
		System.out.println(playerName +  "'s " + cardListType);		
		System.out.println("---------------------------------------------");
		System.out.println("INX\tFREE\tTYPE\tTRAVEL\tEFFECT");
		System.out.println("---------------------------------------------");
		
		for (int i = 0; i < cardList.size(); i++) {				
			System.out.print(i+"\t");
	        System.out.print(cardList.get(i).free +"\t");	
			System.out.print(cardList.get(i).cardInfo.get("Type") + "\t");			
			
			// Accessing travelCost Map entry
	        for (Map.Entry<String,Integer> entry : cardList.get(i).getTravelCost().entrySet())  
	            System.out.print(entry.getValue() + " " + entry.getKey()); 	
	        
	        System.out.println("\t"+ cardList.get(i).cardInfo.get("effectID"));	
		}
		System.out.println("");		
	}
	
	// Update Resource Info View
	public void updateResourcesView (Player player, Board board) {		
		
		System.out.println("RESOURCE LEFT ON BOARD");	
		System.out.println("-----------------------------------");
		System.out.println("Gold coin: " + board.resourceLeft("coin"));
		System.out.println("Compass: " + board.resourceLeft("compass"));
		System.out.println("Arrowhead: " + board.resourceLeft("arrowhead"));
		System.out.println("Jewel: " + board.resourceLeft("jewel"));
		System.out.println("Tablet: " + board.resourceLeft("tablet"));
		
		System.out.println("");		
			
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
	
	}
}
	
