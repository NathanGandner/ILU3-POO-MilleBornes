package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.FinLimite;
import cartes.DebutLimite;

public class ZoneDeJeu extends Carte {
	private List<Limite> lim;
	private List<Bataille> bat;
	private List<Borne> bor;

	public ZoneDeJeu() {
		lim = new ArrayList<>();
		bat = new ArrayList<>();
		bor = new ArrayList<>();
	}
	
	private <T> T head(List<T> liste) {
		return liste.get(liste.size()-1);
	}
	
	public int donnerLimitationVitesse() {
		if(lim.isEmpty())
		{
			return 200;
		}
		if (head(lim).getClass() == DebutLimite.class)
		{
			return 50;
		}
		return 200;
	}
	
	public int donnerKmParcourus() {
		int km=0;
		for(Borne borne: bor) 
			km += borne.getKm();
		return km;
	}
	
	public void deposer(Carte carte) {
		if(carte == null)
			return;
		if(carte.getClass() == (Borne.class)) {
			System.out.println("ENFIIIINNN");
			bor.add((Borne)carte);
		}
		if(carte.getClass() == FinLimite.class)
			lim.add((FinLimite)carte);
		if(carte.getClass() == DebutLimite.class)
			lim.add((DebutLimite)carte);
		if(carte.getClass() == Bataille.class)
			bat.add((Bataille)carte);
		System.out.println("----");
		System.out.println("dépôt impossible dans la classe ZoneDeJeu");
		System.out.println("class de la carte: "+ carte.getClass());
		System.out.println("----");
	}
	
	public boolean peutAvancer() {
		return !(bat.isEmpty() || !equals(bat.get(bat.size()), new Parade(Type.FEU)));
	}
	
	private boolean estDepotFeuVertAutorise() {
		return (bat.isEmpty() || equals(bat.get(bat.size()), new Attaque(Type.FEU)) || (bat.get(bat.size()).getClass() == Parade.class && !equals(bat.get(bat.size()),new Parade(Type.FEU))));
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return (peutAvancer() || borne.getKm()<=donnerLimitationVitesse() || donnerKmParcourus()+borne.getKm()<=1000);
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if (equals(limite, new DebutLimite())){
			return (lim.isEmpty() || equals(lim.get(lim.size()), new FinLimite()));
		} else {
			return (!lim.isEmpty() && equals(lim.get(lim.size()), new DebutLimite()));
			
		}
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if(bataille.getClass() == Attaque.class) {
			return peutAvancer();
		} else {
			if(equals(bataille, new Parade(Type.FEU))) {
				return estDepotFeuVertAutorise();
			} else {
				return (!bat.isEmpty() && bataille.getType() == bat.get(bat.size()).getType());
			}
		}
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte == null)
			return false;
		if(carte.getClass() == Borne.class)
			return estDepotBorneAutorise((Borne) carte);
		if(carte.getClass() == Limite.class)
			return estDepotLimiteAutorise((Limite) carte);
		if(carte.getClass() == Bataille.class)
		{
			System.out.println("IIICCCCIIIII");
			return estDepotBatailleAutorise((Bataille) carte);
		}
		System.out.println("LA :" + carte.getClass());
		return false;
	}
}
