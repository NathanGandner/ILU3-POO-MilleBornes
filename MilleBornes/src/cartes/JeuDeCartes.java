package cartes;

public class JeuDeCartes extends Carte {
	private Configuration[] typesDeCartes;
	
	public JeuDeCartes() {
		typesDeCartes= new Configuration[] {
		new Configuration(new Borne(25), 10),
		new Configuration(new Borne(50), 10),
		new Configuration(new Borne(75), 10),
		new Configuration(new Borne(100), 12),
		new Configuration(new Borne(200), 4),
		new Configuration(new Attaque(Type.FEU), 5),
		new Configuration(new Parade(Type.FEU), 14),
		new Configuration(new Botte(Type.FEU), 1),
		new Configuration(new Attaque(Type.ESSENCE), 3),
		new Configuration(new Parade(Type.ESSENCE), 6),
		new Configuration(new Botte(Type.ESSENCE), 1),
		new Configuration(new Attaque(Type.CREVAISON), 3),
		new Configuration(new Parade(Type.CREVAISON), 6),
		new Configuration(new Botte(Type.CREVAISON), 1),
		new Configuration(new Attaque(Type.ACCIDENT), 3),
        new Configuration(new Parade(Type.ACCIDENT), 6),
        new Configuration(new Botte(Type.ACCIDENT), 1),
        new Configuration(new DebutLimite(), 4),
        new Configuration(new FinLimite(), 6),
		};
	}

	public void affichageJeuDeCartes() {
		for (int i = 0; i < typesDeCartes.length; i++) {
			System.out.println(typesDeCartes[i].getNbExemplaire() + " " + typesDeCartes[i].getCarte());
		}
	}
	
	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for(int i = 0; i < typesDeCartes.length; i++) {
			nbCartes += typesDeCartes[i].getNbExemplaire();
		}
		Carte[] cartes = new Carte[nbCartes];
		
		nbCartes=0;
		for(int i = 0; i<typesDeCartes.length; i++) {
			for(int j = 0; j<typesDeCartes[i].getNbExemplaire(); j++) {
				cartes[nbCartes]=typesDeCartes[i].getCarte();
				nbCartes++;
			}
		}
		return cartes;
	}
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		int nbCartes = 0;
		for(int i = 0; i<typesDeCartes.length; i++) {
			for(int j = 0; j<typesDeCartes[i].getNbExemplaire(); j++) {
				if(cartes[nbCartes]!=typesDeCartes[i].getCarte())
					return false;
				nbCartes++;
			}
		}
		return true;
	}
	
	private static class Configuration {
		private Carte carte;
		private int nbExemplaire;
		
		public Configuration(Carte carte, int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaire = nbExemplaire;
		}
		
		public Carte getCarte() {
			return carte;
		}
		
		public int getNbExemplaire() {
			return nbExemplaire;
		}
	}

}
