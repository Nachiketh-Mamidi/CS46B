package dotLab;


public class Dot 
{
	private static String[] 	LEGAL_COLOR_NAMES =
	{
		"RED", "YELLOW", "BLUE", "CYAN", "GREEN", "MAGENTA", "ORANGE", "BLACK"
	};
	
	private String color;
	private int x;
	private int y;
	private int radius;
	
	public String getColorName() {
		return color;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	
	public Dot(String c, int x1, int y1, int rad){
		this.color = c;
		this.x = x1;
		this.y = y1;
		this.radius = rad;
		String colors = "";
		boolean bool = false;
		System.out.println("Done" + c);
		for(int i = 0; i < LEGAL_COLOR_NAMES.length; i++) {
			if(color.equals(LEGAL_COLOR_NAMES[i])){
				bool = true; 
				}
			}
		if(bool == false) {
			IllegalArgumentException g = new IllegalArgumentException(color + " is an illegal name and doesn't work");
			throw g;
		}
	}
	
	public static void main(String[] args) {
		Dot red = new Dot("BLUE",5,5,2);
		//Dot pink = new Dot("PINK",5,5,2);
		System.out.println(red.toString());
	}
	

}
