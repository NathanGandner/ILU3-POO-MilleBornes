package cartes;


public abstract class Carte {
	
	protected Carte() {
		super();
	}
	
	public static boolean equals(Carte carte1, Carte carte2) {
		if(carte1.getClass()== carte2.getClass()) {
			if(carte1.getClass() == (Borne.class)) {
				return ( ((Borne) carte1).getKm() == ((Borne) carte2).getKm() );
			}
			else if (carte1.getClass() == (Attaque.class)) {
				return( ((Attaque) carte1).getType() == ((Attaque) carte2).getType());
			}
			else if (carte1.getClass() == (Parade.class)) {
				return( ((Parade) carte1).getType() == ((Parade) carte2).getType() );
			}
			else if (carte1.getClass() == (Botte.class)) {
				return( ((Botte) carte1).getType() == ((Botte) carte2).getType() );
			}
			else
				return true;
		} else {
			return false;
		}
	}

	
}
