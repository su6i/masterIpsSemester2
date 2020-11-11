package linkedList;

//Amir SHIRALI POUR


public class MainMyNode {
	public static void main(String[] arg) {
		
		// On cree 3 MyNode isoles contenant les lettres "e", "n", "z"
		
		MyNode<String> e = new MyNode<String>(null, "e", null);
		MyNode<String> n = new MyNode<String>(null, "n", null);
		MyNode<String> z = new MyNode<String>(null, "z", null);
		MyNode<String> o = new MyNode<String>(null, "o", null);
		
		
		// On attache les noeuds entre eux pour qu'ils soient dans l'ordre
		// "n" "e" "z"	
		// celui qui porte "n" est le premier et a pour suivant celui qui porte "e"
		
		//nez
		// n.prev = null
		// n.item = n
		n.next=e;
		
		// celui qui porte "e" a pour suivant celui qui porte "z"
		// et pour précédent celui qui porte "n"
		
		//nez
		e.prev=n;
		//e.item  = e
		e.next=z;
		
		
		// celui qui porte "z" pour précédent celui qui porte "e"

		//nez
		z.prev=e;
		// z.item = z
		// z.next = null
		
		// Pour vérifier que la chaine est bien construite du début vers la fin, 
		// on parcourt en partant du noeud contenant "n"
		
		MyNode<String> courant1 = n;
		while (courant1 !=null) {
			System.out.println(courant1.item);
			courant1 = courant1.next; // on avance
		}
		
		System.out.println("*************************** inverse *******************************");
		// et on le fait en sens inverse
		
		MyNode<String> courant2 = z;
		while (courant2 !=null) {
			System.out.println(courant2.item);
			courant2 = courant2.prev; // on revient en arrière
		}
		
		System.out.println("*************************** Exercice 0 *******************************");
		// Exercice 0 : ajouter "o" entre "e" et "z" et vérifier que les liens
		// sont bien reconstitués en parcourant dans un sens puis dans l'autre
		
		
		// nez
		// neoz
		
		//e
		e.next = o;
		
		//o
		o.prev = e;
		o.next = z;
		
		//z
		z.prev = o;
		
		
		courant1 = n;
		while (courant1 !=null) {
			System.out.println(courant1.item);
			courant1 = courant1.next; // on avance
		}
		
		System.out.println("*************************** Exercice 0 inverse *******************************");
		// et on le fait en sens inverse
		
		courant2 = z;
		while (courant2 !=null) {
			System.out.println(courant2.item);
			courant2 = courant2.prev; // on revient en arrière
		}
		
		
		System.out.println("*************************** Exercice 1 *******************************");
		System.out.println("Exercice 1 : Creer 4 MyNode isoles contenant les lettres 'a', 'o', 'd', 's'\n");
		
		MyNode<String> a = new MyNode<String>(null, "a", null);
		// before we are created "o" letter.
		MyNode<String> d = new MyNode<String>(null, "d", null);
		MyNode<String> s = new MyNode<String>(null, "s", null);
		

	
		System.out.println("*************************** Exercice 2 *******************************");
		System.out.println("Exercice 2 : attacher les MyNode entre eux pour qu'ils soient dans l'ordre 'a' puis 'd' puis 'o' puis 's'\n");
		
		//ados
		
		a.next = d;
		
		d.prev = a;
		d.next = o;
		
		o.prev = d;
		o.next = s;
		
		s.prev = o;
		
		System.out.println("*************************** Exercice 3 *******************************");
		System.out.println("Exercice 3 : vérifier que la chaine est bien construite du début vers la fin, cela doit afficher 'ados'\n");

		MyNode<String> courant3 = a;
		while (courant3 !=null) {
			System.out.print(courant3.item);
			courant3 = courant3.next; 
		}
		
		System.out.println("\n*************************** Exercice 4 *******************************");
		System.out.println("Exercice 4 : vérifier que la chaine est bien construite de la fin vers le début, cela doit afficher 'soda'\n");

		
		MyNode<String> courant4 = s;
		while (courant4 !=null) {
			System.out.print(courant4.item);
			courant4 = courant4.prev; // on revient en arrière
		}
		

		
	}
}
