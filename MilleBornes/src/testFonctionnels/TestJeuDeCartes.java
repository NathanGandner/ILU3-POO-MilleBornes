package testFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes extends Carte {
	
	public void affichageJeuDeCartes() {
		JeuDeCartes jeu = new JeuDeCartes();
		jeu.affichageJeuDeCartes();
	}
	
	public static void main(String[] args) {
		//TestJeuDeCartes test = new TestJeuDeCartes();
		//test.affichageJeuDeCartes();
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.checkCount());
	}
}