package testFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes extends Carte {

	public TestJeuDeCartes() {
		super();
	}
	
	public void affichageJeuDeCartes() {
		JeuDeCartes jeu = new JeuDeCartes();
		jeu.affichageJeuDeCartes();
	}
	
	public static void main() {
		TestJeuDeCartes test = new TestJeuDeCartes();
		test.affichageJeuDeCartes();
	}
}