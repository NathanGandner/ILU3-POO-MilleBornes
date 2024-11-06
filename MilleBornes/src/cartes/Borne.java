package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}
	
	@Override
	public String toString() {
		StringBuilder sortie = new StringBuilder();
		sortie.append(km);
		sortie.append(" KM");
		return sortie.toString();
	}
}
