package arnak;

public class Effects {
	private int id;
	
	public Effects (int id) {
		this.id = id;
	}
	
	public String useEffect() {
		
		switch(id)
		{
		case 1:
			return "Gained 2 golden coins";
		case 2:
			return "Gained 2 compasses";
		default:
			return "Gained 2 golden coins";
		}
	}
	
}
