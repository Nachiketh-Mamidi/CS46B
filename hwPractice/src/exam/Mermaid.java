package exam;
public class Mermaid extends LegendaryCreature {
	String hairColor;

	public Mermaid(String name) {
		super(name);
		hairColor = "red";
	}

	public void power() {
		System.out.println("magical singing");
	}

	public void swim() {
		System.out.println("keep on swimming");
	}
}