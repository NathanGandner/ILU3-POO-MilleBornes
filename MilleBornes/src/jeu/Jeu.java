package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.GestionCartes;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu extends Carte {
	private Sabot sabot;

	public Jeu() {
		JeuDeCartes Jeu = new JeuDeCartes();
		Carte[] cartes = Jeu.donnerCartes();
		List<Carte> listeCartes = new ArrayList<Carte>();
		Collections.addAll(listeCartes, cartes);
		GestionCartes.melanger(listeCartes);
		Sabot sabot = new Sabot((listeCartes.toArray());
	}

}
