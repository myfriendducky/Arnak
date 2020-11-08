package arnak;

import java.util.LinkedList;

public class BoardData {
	LinkedList<Integer> itemCardDeckLeft;
	LinkedList<Integer> itemCardRowLeft;
	int pickedCard;
	
	BoardData (LinkedList<Integer> icdl, LinkedList<Integer> icrl, int pc) {
		itemCardDeckLeft = icdl;
		itemCardRowLeft = icrl;
		pickedCard = pc;		
	}
}
