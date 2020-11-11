package tree_maps;

import java.util.*;


/*
 * Amir SHIRALI POUR
 * Deuxième version
 */


public class MyNodeEntry<K extends Comparable<K>,V> extends MyEntry<K,V> {
	MyNodeEntry<K,V> left = null;
	MyNodeEntry<K,V> right = null;
	MyNodeEntry<K,V> parent;
	
	public MyNodeEntry(K key, V value, MyNodeEntry<K,V> parent) {
		super(key,value);
		this.parent=parent;
	}
	
	
	/*
	 * 
	 * 
	 * 1- Il manque keySetPrefixe; It's done.
	 * 2- Il faut simplifier l’écriture de containsKey; It's done.
	 * 3- nbFeuilles est écrit dans un style à revoir (ne pas utiliser un attribut pour faire son calcul) It's done 
	 * dans deux façons différantes.
	 * 
	 * 
	 */
	
	
	
	
	
	
	// écriture récursive de la méthode auxiliaire
	// appelée dans toString() de MyTreeMap
	
	public String toStringRec(String decalage) {
		String res = decalage+this.key.toString()+"\n";
		if (this.left != null)
				res += this.left.toStringRec(decalage+"  ");
		else res+= decalage+"  "+"."+"\n";
		if (this.right != null)
				res += this.right.toStringRec(decalage+"  ");
		else res+= decalage+"  "+"."+"\n";
		return res;
	}
	
	// méthodes demandées
	
	// écriture récursive de la méthode auxiliaire appelée 
	// par V get(K key) de MyTreeMap
	// de recherche d'une clef afin de retourner la valeur associée
	
	public V get(K key) {
		// si la clef est égale à key
		// retourner la valeur associée
		// ....
		
		// si la clef de la racine est supérieure à la clef cherchée
		// on appelle get sur le sous-arbre gauche
		// ....
		
		// si la clef de la racine est supérieure à la clef cherchée
		// on appelle get sur le sous-arbre droite
		// ....
		
		
		// AMIR
		int cmp = key.compareTo(this.key);
		if (cmp == 0) 
			return  this.value;
		
		
		if (cmp < 0 && this.left != null) 
			return this.left.get(key);
		
		else if (cmp > 0 && this.right != null)
			return this.right.get(key);
		
		return null;
		
	}
	
	public void keySet(Set<K> res) {
		// à écrire
		boolean direction = true;
		while (this != null && direction == true) {
			res.add(this.key);
			if (this.left != null)
				this.left.keySet(res);
			if (this.right != null)
				this.right.keySet(res);
			direction = false;
		}
		
	}
	
	public void keySetPrefixe(ArrayList<K> res) {
		// à écrire
		if (this != null)
			res.add(this.key);
		if (this.left != null)
			this.left.keySetPrefixe(res);
		if (this.right != null)
			this.right.keySetPrefixe(res);
	}
	
	

	//Amir SHIRALI POUR
	// Je pense que vous vouliez dire que je dois mettre  "int count = 0" à l'intérieur de la méthode!
	// Comme ça aussi la méthode marche! Mais quand même pour ne pas perdre les point j'ai écris une autre méthode
	// et je l'ai mis en commentaire! Dans deuxième méthode j'ai carrément enlevé la variable count!
	
	
	// Première version
	public int nbFeuilles() {
		// à écrire
		int count = 0;
		if (this != null) {
		if(this.left == null && this.right == null) {
			count++;
			System.out.println("Leaf: " + this.key);
			}
		else {
			if (this.left != null) {
				count +=this.left.nbFeuilles();
				}
			if (this.right != null) {
				count +=this.right.nbFeuilles();
				}
			
			}	
		}
		return count;
	}
	
	
	
	
	// Deuxième version
/*	
	public int nbFeuilles() {
	if(this.left == null && this.right == null) {
			System.out.println("Leaf: " + this.key);
			return 1;
			}
		if (this.right == null && this.left != null) {
				return this.left.nbFeuilles();
				}
		if (this.left == null && this.right != null) {
				return this.right.nbFeuilles();
				}
		if (this.left != null && this.right != null)
			return this.right.nbFeuilles() + this.left.nbFeuilles();

		return 0;
		
		}
		
*/
	
	//Amir SHIRALI POUR
	// J'ai eu répété la partie de la methode get dans la methode containsKey() :) je l'ai effacé et j'ai ajouté
	// this.get() à la place de tous les codes!
	/*
	public boolean containsKey(K key) {

		int cmp = key.compareTo(this.key);
		if (this != null && cmp == 0)
			return true;
		if (this.left != null && cmp < 0) {
			return this.left.containsKey(key);
			}
		if (this.right != null && cmp > 0){
			return this.right.containsKey(key);
			}
		return false;			
	
	}
	
	*/
	
	public boolean containsKey(K key) {
		if(this.get(key)==null) 
			return false;
		else return true;
	}
	
	
	

	public boolean containsValue(Object value) {
		boolean result = false;
		if (this != null && this.value.equals(value))
			result = true;
		if (this.left != null) {
			result = result || this.left.containsValue(value);
		}
		if (this.right != null){
			result = result || this.right.containsValue(value);
		}
		return result;
	}
	
}