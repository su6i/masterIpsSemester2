package HashMap;

//Amir SHIRALI POUR



/*


//MH il faut aussi pouvoir s'arrêter si la clef n'apparaît pas,
// donc la condition d'arrêt
// doit être complétée par la vérification que l'on ne rencontre pas
// null.
// De plus quand on arrive à l'indice de fin sans avoir ni 
rencontré null
// ni rencontré la clef, il faut revenir au début du tableau (à 
l'indice 0)
// et attention au cas où le tableau est plein, il faut s'arrêter 
quand on a tout
// examiné !

@Override
public V get(Object key) {

    int hashCourant = key.hashCode()%table.length;
    //if (table[hashCourant].value != null) {
        // return table[hashCourant].value;
    //}

    while (table[hashCourant].key != key) {
        hashCourant++;
    }

    return table[hashCourant].value;

}



*/



import java.util.*;

public class MyHashMap<K,V>
		implements Map<K,V>
{
	// pour stocker les associations
	
	private MyEntry<K,V>[] table;
	private int size; 
	
	public MyHashMap() {
		// on cree la HashMap avec une premiere taille
		// estimative de 10
		// et on ne sait pas combien d'associations
		// on devra stocker au fil du temps
		
		this.table = new MyEntry[10];
	}

	// methode agrandissant la table quand c'est nécessaire
	private void agrandir() {
		// on crée une nouvelle table augmentee de 10 cases
		// on remet les associations existantes
		// en repassant par la fonction de hachage
		MyEntry<K,V>[] ancienneTable = table;
		table = new MyEntry[table.length+10];
		for (MyEntry<K,V> e: ancienneTable)
			this.put(e.key, e.value);
	}
	
	@Override
	public V put(K key, V value) {
		// si la table est pleine, on appelle la fonction agrandir
		if (table.length == this.size)
			this.agrandir();
		// on applique la fonction de hachage a la clef key
		// et on ramène la valeur dans [0,table.length[
		// cela donne un indice
		 int hashCourant = key.hashCode()%table.length;
		// si la table contient null a cet indice, c'est libre
		// et on y range l'association
		// sinon on cherche la premiere case du tableau qui contient null
		// comme la table n'est pas pleine, on est sûr qu'il en existe une
		while (table[hashCourant]!=null) {
			hashCourant++;
			if (hashCourant == table.length)
				hashCourant = hashCourant%table.length; // hashCourant == 0
		}
		table[hashCourant]= new MyEntry<K, V>(key, value);
		size++;
		return value;
	}
	
	
    // MH 
	// 1) il faut aussi pouvoir s'arrêter si la clef n'apparaît pas, donc la condition d'arrêt
    // doit être complétée par la vérification que l'on ne rencontre pas null.
	
    // 2) De plus quand on arrive à l'indice de fin sans avoir ni rencontré null
    // ni rencontré la clef, il faut revenir au début du tableau (à l'indice 0)
	
    // 3) et attention au cas où le tableau est plein, il faut s'arrêter quand on a tout examiné !

	
	
	@Override
	public V get(Object key) {
		
		int hashCourant = key.hashCode()%table.length;
		  
		// J'ai ajouté une deuxième while et comme la condition j'ai ajouté " hashCourant  < key.hashCode()%table.length "
		// Pour qu'elle s'arrête tout suite après qu'elle a examiné tout les cases!.
		while (table[hashCourant] != null && table[hashCourant].key != key) {
				hashCourant++;
				if (hashCourant == table.length) {
					hashCourant=0;																			// 2: on revient à l'indice 0								   
					while (table[hashCourant] != null && table[hashCourant].key != key && hashCourant  < key.hashCode()%table.length)     // 3: il s'arrêter quand on a tout examiné !   
						hashCourant++;
				}
		}
		
		
		
		// Plus simple mais un peu moins efficace
		/*
		while (table[hashCourant]!=null && table[hashCourant].key != key) {
			hashCourant++;
			if (hashCourant == table.length)
				hashCourant = hashCourant%table.length; // hashCourant == 0			// 2: on revient à l'indice 0
		}
		*/
		
		
		
		System.out.println("**********************************\n");
		if (table[hashCourant] != null && table[hashCourant].key == key) 			// 1: la vérification que l'on ne rencontre pas null.
			return table[hashCourant].value;

		return null;
		
	}
	
	// methodes A ECRIRE
	// méthode affichant tout le tableau, mêmes les entrées vide (égales à null)


	public String toString() {
		//return "Table: " + this.table[key.hashCode()];
    // MH : ici il faut parcourir la table avec un for
    String s="Table of HashMaps:\n";
    int i = 0;
    for (MyEntry<K, V> e : table){
      s += "    " + "No." + i + "   " + e + "\n";
      i++;
    }
      
    return s;
	}
	
	// methode retournant l'ensemble de clefs
	@Override
	public Set<K> keySet() {
		Set<K> res = new HashSet<K>();
		for (MyEntry<K, V> e : table){
			if (e != null)
				res.add(e.key);
			}
		
		return res;
	}
	
	@Override
	public boolean containsKey(Object key) {
		// retourne vrai si keySet() contient key
		
		return this.keySet().contains(key);		
	}
	
	@Override
	public int size() {
		// return this.table.length;
		return this.keySet().size();
	}
	
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}	
	
	
	// Methodes a ne pas ecrire
	// presentes seulement pour respecter l'interface
	// seraient écrites dans une version complete

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
