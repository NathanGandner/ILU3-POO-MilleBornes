package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;


public class Sabot extends Carte implements Iterable<Carte> {
	Carte[] sabot;
	int nbCartes;
	int nbCartesMax;
	int indiceIterateur = 0;
	int nombreOperations = 0;
	boolean nextEffectue = false;

	public Sabot(Carte[] sabot) {
		this.sabot = sabot;
		this.nbCartes = sabot.length;
		this.nbCartesMax = nbCartes;
	}
	
	public boolean estVide() {
		return nbCartes<=0;
	}
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes==nbCartesMax) {
			throw new ArrayIndexOutOfBoundsException();
		}
		sabot[nbCartes++] = carte;
		nombreOperations++;
	}
	
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;
	}
	
	private class Iterateur implements Iterator<Carte>{
	    private int indiceIterateur = 0;
	    private int nombreOperationsReference = nombreOperations;
	    private boolean nextEffectue = false;

	    public boolean hasNext(){
	    	verificationConcurrence();
	    	return indiceIterateur < nbCartes;
	    }
	    public Carte next() {
	    	verificationConcurrence();
	    	if(hasNext()) {
	    		Carte carte = sabot[indiceIterateur];
	    		indiceIterateur++;
	    		nextEffectue = true;
	    		return carte;
	    	} else {
	    		throw new NoSuchElementException();
	    	}
	    }
	    
	    @Override
	    public void remove(){
	        verificationConcurrence();
	        if(estVide() || !nextEffectue) {
	        	throw new IllegalStateException();
	        }
	        for (int i=indiceIterateur-1; i<nbCartes-1; i++) {
	        	sabot[i] = sabot[i+1];
	        }
	        nextEffectue = false;
	        indiceIterateur--;
	        nbCartes--;
	        nombreOperationsReference++; nombreOperations++;
	    }

	    private void verificationConcurrence(){
	        if(nombreOperations != nombreOperationsReference){
	            throw new ConcurrentModificationException();
	        }
	    }
	}
}
