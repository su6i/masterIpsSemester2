package ExceptionAssertion;

import java.util.ArrayList;

public class Pile<T> implements IPile<T>{
	// structure de stockage interne des éléments
	private ArrayList<T> elements;
	// Mise en oeuvre des opérations
	public Pile(){
		initialiser();
		assert this.estVide();
		}
	public T depiler() throws PileVideException{
		int tailleAvant = elements.size();
		if (this.estVide())
			throw new PileVideException("en dépilant");
			T sommet = elements.get(elements.size()-1);
			elements.remove(sommet);
			assert elements.size() == tailleAvant -1;
			return sommet;
	}
	
	public void empiler(T t) throws PileVideException, TailleMaxDepasseException {
		int tailleAvant = elements.size();
		elements.add(t);
		assert this.sommet()==t : "dernier empile ="+this.sommet();
		assert elements.size() == tailleAvant +1;
	}
	
	public boolean estVide() {return elements.isEmpty();}
	public void initialiser() {elements = new ArrayList<T>();}
	public T sommet() throws PileVideException{
	if (this.estVide())
	throw new PileVideException("en dépilant");
	return elements.get(elements.size()-1);
	}
	
	public int nbElements(){return elements.size();}
	public String toString(){return "Pile = "+ elements;}
	}