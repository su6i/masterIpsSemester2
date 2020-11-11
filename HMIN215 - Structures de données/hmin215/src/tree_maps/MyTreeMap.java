package tree_maps;

import java.util.*;
/*
 * Amir SHIRALI POUR
 * K extends Comparable<K> permettra de disposer d'une
 * fonction naturelle de comparaison sur les clefs
 * de la forme : int compareTo(K autreClef)
*/
public class MyTreeMap<K extends Comparable<K>, V> 
		implements Map<K, V> {
	
	private MyNodeEntry<K,V> root;
	private int nbNodes;
	
	public MyTreeMap() {}
	
	@Override
	public int size() {
		return this.nbNodes;
	}

	@Override
	public boolean isEmpty() {
		return this.size()==0;
	}

	// version d'ajout simplifiée ne rééquilibrant pas l'arbre
	// On respecte la propriété d'organisation des clefs qui dit
	// qu'à partir de la racine :
	// - toute clef de la branche GAUCHE d’un noeud est toujours INFERIEURE 
	//    à la clef du noeud lui-même.  
	// - toute clef de la branche DROITE d’un noeud est toujours SUPERIEURE 
	//    à la clef du noeud lui-même.  
	// 
	
	@Override
	public V put(K key, V value) {
		// si l'arbre est vide, on crée une racine
		if (this.isEmpty())
		{
			root = new MyNodeEntry<>(key, value, null);
			this.nbNodes++;
			return value;
		}
		// sinon on cherche l'emplacement 
		// adapté à la nouvelle valeur
		// en respectant la propriété d'organisation des clefs
		int cmp;
		MyNodeEntry<K,V> courant, parent;
		courant = root;
		do {			  
			  parent = courant;
			  cmp = key.compareTo(courant.key);
			  if (cmp < 0)
			  	courant = courant.left;
			  else if (cmp > 0)
				 courant = courant.right;
			  else // la clef est déjà dedans 
				   // on change simplement la valeur associée
				  {
				  	courant.setValue(value);
				  	return value;
				  }
		}
		while (courant != null);
		// si on arrive ici il faut insérer à gauche ou à droite
		MyNodeEntry<K,V> e = new MyNodeEntry<>(key, value, parent);
		if (cmp < 0)
		 	parent.left = e;
		else
			parent.right = e;
		this.nbNodes++;
		return null;
	}
	
	// affichage indenté de l'arbre

	@Override
	public String toString() {
		if (! this.isEmpty())
			return root.toStringRec("  ");
		else 
			return ".";
	}
	
	// Méthodes à implémenter
	
	// On appelle une méthode récursive écrite dans
	// MyNodeEntry
	// qu'il faudra écrire
	
	@Override
	public V get(Object key) {
		if (this.isEmpty())	{
			return null;
		}
		return this.root.get((K)key);
	}

	// Méthode à écrire
	@Override
	public boolean containsKey(Object key) {
		if (this.isEmpty())	{
			return false;
		}
		return this.root.containsKey((K)key);
	}
	
	// Méthode à écrire
	@Override
	public boolean containsValue(Object value) {
		if (this.isEmpty())	{
			return false;
		}
		return this.root.containsValue(value);
	}
	
	// Méthode qui appelle une méthode récursive écrite dans
	// MyNodeEntry
	// qu'il faudra écrire
	@Override
	public Set<K> keySet() {
		Set<K> res = new TreeSet<>();
		this.root.keySet(res);
		return res;
	}
	
	// Méthode qui appelle une méthode récursive écrite dans
	// MyNodeEntry
	// qu'il faudra écrire	
	public ArrayList<K> keySetPrefixe() {
		ArrayList<K> res = new ArrayList<>();
		this.root.keySetPrefixe(res);
		return res;
	}	
	
	// une feuille est un noeud qui n'a 
	// ni fils gauche
	// ni fils droit
	// Méthode qui appelle une méthode récursive écrite dans
	// MyNodeEntry
	public int nbFeuilles() {
		if (this.isEmpty())	{
			return 0;
		}
		return this.root.nbFeuilles();
	}
	
	// méthodes qui seront laissées ici non implémentées

	@Override
	public V remove(Object key) {
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
	}

	@Override
	public void clear() {
	}

	@Override
	public Collection<V> values() {
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}

}
