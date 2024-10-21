package jeu;

import java.util.Iterator;

import cartes.Carte;

public class Joueur extends Carte {
	private ZoneDeJeu zoneDeJeu;
	private String nom;
	private MainJoueur main;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public boolean equals(Joueur joueur1, Joueur joueur2) {
		System.out.println("joueur1 = "+joueur1+" joueur2= "+joueur2);
		return(joueur1==joueur2);
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public Iterator<Carte> itMain() {
		return main.iterator();
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide())
			return null;
		Carte carte = sabot.piocher();
		donner(carte);
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}

}
