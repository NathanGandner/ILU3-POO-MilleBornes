package jeu;

import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur extends Carte implements Iterable<Carte> {
	List<Carte> main;
	
	public MainJoueur() {
		super();
	}
	
	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		for(Carte carte: main) {
			out.append("-");
			out.append(carte);
			out.append("\n");
		}
		return out.toString();
	}

	public Iterator<Carte> iterator() {
		return main.listIterator();
	}

}
