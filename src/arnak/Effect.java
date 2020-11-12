package arnak;

public class Effect {
	private int id;
	
	public Effect (int id) {
		this.id = id;
	}
	
	public String useEffect() {
		
		switch(id)
		{
		case 1:
			return "Gained 2 golden coins";
		case 2:
			return "Gained 2 compasses";
		case 3:
			return "Gained 3 golden coins";
		case 4:
			return "Gained 3 compasses";
		case 5:
			return "Gained 1 perl";
		case 6:
			return "Gained 2 perls";
		case 7:
			return "Gained 2 golden coins";
		case 8:
			return "Draw Card";
		case 9:
			return "Make Trade";
		case 10:
			return "Gain Fear Card";
		default:
			return "Gained 2 golden coins";
		}
	}
	
}
