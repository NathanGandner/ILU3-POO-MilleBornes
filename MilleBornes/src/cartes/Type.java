package cartes;

public enum Type {
	FEU("FeuRouge", "FeuVert", "VehiculePrioritaire"),
	ESSENCE("Panne d'essence", "Bidon d'essence", "Citerne"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "R�paration", "As du volant");
	
	private String attaque;
	private String parade;
	private String botte;
	
	Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}
	
	public String getBotte() {
		return botte;
	}
	
	public String getParade() {
		return parade;
	}
	
	public String getAttaque() {
		return attaque;
	}
}