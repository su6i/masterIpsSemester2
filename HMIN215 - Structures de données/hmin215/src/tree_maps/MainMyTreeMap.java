/*
 * Amir SHIRALI POUR
 * Deuxième version
*-----------
* MyTreeMap
*-----------
* Version simplifiée imitant la classe de l'API Java - notamment l'équilibrage n'est pas traité
*-----------
* Elle est incomplète et destinée à êêtre complétée par vos soins.
*-----------
* Vous ferez un Fork sur ce code puis vous m'invitez dessus pour que je puisse vous aider à avancer.
*-----------
* Le code ci-dessous s'exécute et appelle les fonctions à tester, dont certaines ne sont pas encore écrites et retournent des valeurs par défaut
*-----------
*/

package tree_maps;

public class MainMyTreeMap {

	public static void main(String[] args) {
		
		Departement H = new Departement(
				"Hérault","34",6224,"Montpellier",1444892,342);
		Departement HL = new Departement(
				"Haute Loire","43",4977,"Le Puy en Velay",227283,257);
		Departement CS = new Departement(
				"Corse-du-Sud","2A",4014,"Sartène",157249,124);
		Departement HC = new Departement(
				"Haute-Corse","2B",4666,"Sartène",177689,236);
		Departement G = new Departement(
				"Gers","32",6257,"Auch",191091,462);
		Departement Ga = new Departement(
				"Gard","30",5853,"Nîmes",744178,351);
		Departement Au = new Departement(
				"Aube","10",6004,"Troyes",310020,431);
		Departement Ma = new Departement(
				"Marne","51",8169,"Châlons-en-Champagne",568895,616);
		
				
		System.out.println("\n---------------");
		
		MyTreeMap<String,Departement> mhm = new MyTreeMap<>();
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");

		mhm.put("32", G);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");

		mhm.put("43", HL);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");

		mhm.put("2A", CS);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");


		mhm.put("2B", HC);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");
		
		mhm.put("10", Au);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");

		mhm.put("30", Ga);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");
		
		mhm.put("34", H);
		System.out.println(mhm+"\n---------------");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n*******************************************");



		mhm.put("51", Ma);
		System.out.println(mhm+"\n---------------");	
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		
		System.out.println("\n**************************get******************************************\n");
		System.out.println("get 32: " + mhm.get("32"));
		System.out.println("get 34: " + mhm.get("34"));
		System.out.println("get 35: " + mhm.get("35"));
		System.out.println("get 43: " + mhm.get("43"));
		System.out.println("get 2A: " + mhm.get("2A"));
		System.out.println("get 2B: " + mhm.get("2B"));
		System.out.println("get 31: " + mhm.get("31"));
		System.out.println("get 32: " + mhm.get("32"));
		System.out.println("get 33: " + mhm.get("33"));	
		System.out.println("get 30: " + mhm.get("30"));	
		System.out.println("get 10: " + mhm.get("10"));
		System.out.println("get 51: " + mhm.get("51"));
		
		System.out.println("\nJust to test that it works very well or not!");
		System.out.println("get 8851: " + mhm.get("8851"));
		System.out.println("\n*******************keySet************************");
		System.out.println("keySet: " + mhm.keySet());
		System.out.println("\n*******************keySetPrefixe************************");
		System.out.println(mhm.keySetPrefixe());
		System.out.println("\n*******************nbFeuilles************************");
		System.out.println("nbFeuilles: " + mhm.nbFeuilles());
		System.out.println("\n*******************containsKey************************");
		System.out.println("Is it contains key 51? " + mhm.containsKey("51"));
		
		System.out.println("\n*******************containsValue************************");
		System.out.println("Is it contains value Gard?: " + mhm.containsValue(Ga));
		System.out.println("Is it contains value Marne?: " + mhm.containsValue(Ma));
		System.out.println("Is it contains value Aube?: " + mhm.containsValue(Au));
		System.out.println("Is it contains value n'importe quoi?: " + mhm.containsValue(null));
		
		System.out.println("\n******************************* Mes commentaires *************************************\n");
		
		System.out.println("1- Il manque keySetPrefixe; -------> C'est fait.");
		System.out.println("2- Il faut simplifier l’écriture de containsKey; -------> C'est fait.");
		System.out.println("	- J'ai eu répété la partie de la methode get dans la methode containsKey() :) je l'ai effacé");
		System.out.println("	- et j'ai ajouté this.get() à la place de tous les codes!");

		System.out.println("3- nbFeuilles est écrit dans un style à revoir (ne pas utiliser un attribut pour faire son calcul) -------> C'est fait dans deux versions différantes.");
		System.out.println("	- Je pense que vous vouliez dire que je dois mettre  \"int count = 0\" à l'intérieur de la méthode!");
		System.out.println("	- Comme ça aussi la méthode marche! Mais quand même pour ne pas perdre les point j'ai écris une autre méthode");
		System.out.println("	- et je l'ai mis en commentaire! Dans deuxième méthode j'ai carrément enlevé la variable count!");
		


	}
}
