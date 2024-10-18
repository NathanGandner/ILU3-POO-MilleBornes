package jeu;

import cartes.Carte;

public class Joueur extends Carte {
	private ZoneDeJeu zoneDeJeu;
	private String nom;
	
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

}
