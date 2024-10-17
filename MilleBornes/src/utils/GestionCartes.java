package utils;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class GestionCartes<T> extends Carte {

	public GestionCartes() {
		super();
	}
	
	public static <T> T extraire(List<T> liste) {
		Random random = new Random();
		return (liste.remove(random.nextInt(liste.size())));
	}
	
	public static <T> T extraire_it(List<T> liste) {
		Random random = new Random();
		int c = random.nextInt(liste.size());
		ListIterator<T> iterateur = liste.listIterator();
		for(int i = 0; i <c-1; i++) {
			iterateur.next();
		}
		T Elem = iterateur.next();
		iterateur.remove();
		return Elem;
	}
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> melange = new ArrayList<T>();
		int taille = liste.size();
		for(int i=0; i< taille; i++) {
			melange.add(extraire(liste));
		}
		return melange;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if(liste1.size()!=liste2.size()) {
			return false;
		}
		ListIterator<T> iterateur = liste1.listIterator();
		for(int i=0; i<liste1.size(); i++) {
			T Elem = iterateur.next();
			if(Collections.frequency(liste1, Elem) != Collections.frequency(liste2, Elem)) {
				System.out.println("elem = "+Elem + "nb liste1 = " + Collections.frequency(liste1, Elem) + "nbliste2= "+ Collections.frequency(liste1, Elem));
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste) {
		ListIterator<T> iterateur = liste.listIterator();
		List<T> rassembler = new ArrayList<T>();
		for(int i=0; i<liste.size(); i++) {
			T Elem = iterateur.next();
			if(!rassembler.contains(Elem)) {
				for(int j=0; j< Collections.frequency(liste, Elem); j++) {
					rassembler.add(Elem);
				}
			}
		}
		return rassembler;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> it_elem = liste.listIterator();
		while(it_elem.hasNext()) {
			T elem = it_elem.next();
			ListIterator<T> it_verif = liste.listIterator(it_elem.nextIndex());
			T verif = it_verif.next();
			while(elem.equals(verif)) {
				verif = it_verif.next();
			}
			while(it_verif.hasNext()) {
				if(verif.equals(elem))
					return false;
				verif=it_verif.next();
			}
			T elemPrec = elem;
			while((elem=it_elem.next()) == elemPrec)
				;
		}
		return true;
	}
}
