package arnak;

public class View {
	
	public View(Player player, Board board) {
		System.out.println(player.name +  "'s " + "DECK");		
		System.out.println("-----------------------------------");
		for (int i = 0; i < player.deck.size(); i++)
			System.out.println(player.deck.get(i).cardInfo.get("Type"));
		System.out.println("");
		System.out.println("");
		
		System.out.println(player.name +  "'s " + "HAND");		
		System.out.println("-----------------------------------");
		for (int i = 0; i < player.hand.size(); i++)
			System.out.println(player.hand.get(i).cardInfo.get("Type"));
		System.out.println("");
		System.out.println("");
		
		System.out.println(player.name +  "'s " + "PLAY AREA");		
		System.out.println("-----------------------------------");
		for (int i = 0; i < player.playArea.size(); i++)
			System.out.println(player.playArea.get(i).cardInfo.get("Type"));
		System.out.println("");
		System.out.println("");
		
		System.out.println("RESOURCE LEFT");	
		System.out.println("-----------------------------------");
		System.out.println("Coin: " + board.resourceLeft("coin"));
		System.out.println("Compass: " + board.resourceLeft("compass"));
	}

}
