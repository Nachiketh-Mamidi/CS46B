package exam;

public class LegendaryCreature {
	String name;

	public LegendaryCreature(String name) {
		this.name = name;
	}

	public void power() {
		System.out.println("All creatures are powerful");
	}

	public static void main(String[] args) {
		Mermaid ariel = new Mermaid("Ariel");
		LegendaryCreature lc = ariel;
		LegendaryCreature buckbeak = new Hippogriff("Buckbeak", "Black and White");
		lc.power();
		ariel.swim();
		buckbeak.swim();
		lc.swim();
	}
}