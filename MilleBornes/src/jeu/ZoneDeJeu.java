package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;
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
		if(carte.getClass() == Borne.class)
			bor.add((Borne)carte);
		if(carte.getClass() == FinLimite.class)
			lim.add((FinLimite)carte);
		if(carte.getClass() == DebutLimite.class)
			lim.add((DebutLimite)carte);
		if(carte.getClass() == Bataille.class)
			bat.add((Bataille)carte);
	}
}
