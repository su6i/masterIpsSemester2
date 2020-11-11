package HashMap;

// Amir SHIRALI POUR


class MainMyHashMap {
  public static void main(String[] args) {
    // Suivant les associations que l'on crée
		// la clef et la valeur sont de différents types
		
		// Exemple : une MyEntry avec
		// clef : nom d'une personne célèbre
		// valeur : année de naissance
		
	  System.out.println("\n******************* Print e0 **********************");
		MyEntry<String,Integer> e0 =
				new MyEntry<>("Manu Dibango",1933);
		System.out.println(e0);
		
		// Exercices -----------------------------------------
		
		// Déclarer et créer une MyEntry avec
		// clef : numéro du département
		// valeur : département de l'hérault
		
		Departement He = new Departement(
				"Hérault","34",6224,"Montpellier",1444892,342);
    
		System.out.println("\n******************* Print entryHerault **********************");
		MyEntry<String,Departement> entryHerault =
				new MyEntry<>("34",He);
		System.out.println(entryHerault);
				
		// Déclarer et créer une MyEntry avec
		// clef : nom d'un aliment (ex. fraise)
		// valeur : nombre de calories pour 100g (ex. 33)
		
		System.out.println("\n******************* Print fraise **********************");
		MyEntry<String,Integer> fraise =
				new MyEntry<>("fraise",33);
		System.out.println(fraise);
 
		
		// Déclarer et créer une MyEntry avec
		// clef : pointure de chaussure (Ex. 42)
		// valeur : longueur de pied (Ex. 27 cm)

		System.out.println("\n******************* Print chaussure **********************");
		MyEntry<Integer,Integer> chaussure =
				new MyEntry<>(42,27);
    
		System.out.println(chaussure);

		//------------  MyHashMap

    	Departement H = new Departement(
				"Hérault","34",6224,"Montpellier",1444892,342);
		Departement I = new Departement(
				"Ille et Vilaine","35",6775,"Rennes",1060199,333);
		Departement HL = new Departement(
				"Haute Loire","43",4977,"Le Puy en Velay",227283,257);
		Departement CS = new Departement(
				"Corse-du-Sud","2A",4014,"Sartène",157249,124);
		Departement HC = new Departement(
				"Haute-Corse","2B",4666,"Sartène",177689,236);
		Departement HG = new Departement(
				"Haut-Garonne","31",6309,"Toulouse",1362672,587);
		Departement G = new Departement(
				"Gers","32",6257,"Auch",191091,462);
		Departement Gi = new Departement(
				"Gironde","33",9975,"Bordeaux",1583384,535);
		Departement Ga = new Departement(
				"Gard","30",5853,"Nîmes",744178,351);
		Departement Au = new Departement(
				"Aube","10",6004,"Troyes",310020,431);
		Departement Ma = new Departement(
				"Marne","51",8169,"Châlons-en-Champagne",568895,616);
		
		
		MyHashMap<String,Departement> mhm = new MyHashMap<>();
    System.out.println("\n******************* Print an empty mhm **********************");
		System.out.println(mhm);
		System.out.println("mhm isEmpty?: " + mhm.isEmpty());
		
    System.out.println("\n******************* Print Hashcode de 34 **********************");
		System.out.println("Hashcode de 34 ="+ new String("34").hashCode()%10);
		mhm.put("34", H);
		System.out.println(mhm);
		System.out.println("Get of '34' is: " + mhm.get("34"));
		
    System.out.println("\n******************* Add and Print Hashcode de 35 **********************");
		System.out.println("Hashcode de 35 ="+ new String("35").hashCode()%10);
		mhm.put("35", I);
		System.out.println(mhm);
		System.out.println("Get of '35' is: " + mhm.get("35"));
		
    System.out.println("\n******************* Add and Print Hashcode de 43 **********************");
		System.out.println("Hashcode de 43 ="+ new String("43").hashCode()%10);
		mhm.put("43", HL);
		System.out.println(mhm);
		System.out.println("Get of '43' is: " + mhm.get("43"));
		
    System.out.println("\n******************* Add and Print Hashcode de 2A **********************");
		System.out.println("Hashcode de 2A ="+ new String("2A").hashCode()%10);
		mhm.put("2A", CS);
		System.out.println(mhm);
		System.out.println("Get of '2A' is: " + mhm.get("2A"));
		
    System.out.println("\n******************* Add and Print Hashcode de 2B **********************");
		System.out.println("Hashcode de 2B ="+ new String("2B").hashCode()%10);
		mhm.put("2B", HC);
		System.out.println(mhm);
		System.out.println("Get of '2B' is: " + mhm.get("2B"));
		
    System.out.println("\n******************* Add and Print Hashcode de 31 **********************");
		System.out.println("Hashcode de 31 ="+ new String("31").hashCode()%10);
		mhm.put("31", HG);
		System.out.println(mhm);
		System.out.println("Get of '31' is: " + mhm.get("31"));
		
    System.out.println("\n******************* Add and Print Hashcode de 32 **********************");
		System.out.println("Hashcode de 32 ="+ new String("32").hashCode()%10);
		mhm.put("32", G);
		System.out.println(mhm);
		System.out.println("Get of '32' is: " + mhm.get("32"));
		
    System.out.println("\n******************* Add and Print Hashcode de 33 **********************");
		System.out.println("Hashcode de 33 ="+ new String("33").hashCode()%10);
		mhm.put("33", Gi);
		System.out.println(mhm);
		System.out.println("Get of '33' is: " + mhm.get("33"));
		
    System.out.println("\n******************* Add and Print Hashcode de 30 **********************");
		System.out.println("Hashcode de 30 ="+ new String("30").hashCode()%10);
		mhm.put("30", Ga);
		System.out.println(mhm);
		System.out.println("Get of '30' is: " + mhm.get("30"));
		
    System.out.println("\n******************* Add and Print Hashcode de 10 **********************");
		System.out.println("Hashcode de 10 ="+ new String("10").hashCode()%10);
		mhm.put("10", Au);
		System.out.println(mhm);
		System.out.println("Get of '10' is: " + mhm.get("10"));
		
    System.out.println("\n******************* Add and Print Hashcode de 51 **********************");
		System.out.println("Hashcode de 51 table size (10) ="+ new String("51").hashCode()%10);
		System.out.println("Hashcode de 51 table size (20) ="+ new String("51").hashCode()%20);

		mhm.put("51", Ma);			
		System.out.println(mhm);
		System.out.println("Get of '51' is: " + mhm.get("51"));
		
		
		System.out.println("\n******************* Display all hashcodes in new table of size 20 **********************");
		System.out.println("***The result is not correct for those that hashcode was occupied before, e.g. 51, 43, 10 etc. ***\n");
		System.out.println("Hashcode de 34 ="+ new String("34").hashCode()%20);
		System.out.println("Hashcode de 35 ="+ new String("35").hashCode()%20);
		System.out.println("Hashcode de 43 ="+ new String("43").hashCode()%20);
		System.out.println("Hashcode de 2A ="+ new String("2A").hashCode()%20);
		System.out.println("Hashcode de 2B ="+ new String("2B").hashCode()%20);
		System.out.println("Hashcode de 31 ="+ new String("31").hashCode()%20);
		System.out.println("Hashcode de 32 ="+ new String("32").hashCode()%20);
		System.out.println("Hashcode de 33 ="+ new String("33").hashCode()%20);
		System.out.println("Hashcode de 30 ="+ new String("30").hashCode()%20);
		System.out.println("Hashcode de 10 ="+ new String("10").hashCode()%20);
		System.out.println("Hashcode de 51 ="+ new String("51").hashCode()%20);

    	System.out.println("\n******************* Call method GET **********************");
		System.out.println("34: " + mhm.get("34"));
		System.out.println("35: " + mhm.get("35"));
		System.out.println("43: " + mhm.get("43"));
		System.out.println("2A: " + mhm.get("2A"));
		System.out.println("2B: " + mhm.get("2B"));
		System.out.println("31: " + mhm.get("31"));
		System.out.println("32: " + mhm.get("32"));
		System.out.println("33: " + mhm.get("33"));	
		System.out.println("30: " + mhm.get("30"));	
		System.out.println("10: " + mhm.get("10"));
		System.out.println("51: " + mhm.get("51"));	
		System.out.println("37: " + mhm.get("37"));	
		System.out.println("551: " + mhm.get("551"));
		
		// TESTER ICI 
		
		// la méthode size() et la méthode isEmpty()
		System.out.println("\n******************* Call method SIZE **********************");
		System.out.println("Size of mhm is: " + mhm.size());
		
		System.out.println("\n******************* Call method isEmpty **********************");
		System.out.println("mhm isEmpty?: " + mhm.isEmpty());
		
		
		
		// la méthode keySet
		System.out.println("\n******************* Call method keySet() **********************");
    	System.out.println(mhm.keySet());

		
		// la méthode toString
		System.out.println("\n******************* Call method toString() **********************");
		System.out.println(mhm);
		
		System.out.println("\n******************* Call method containsKey() **********************");
		System.out.println("Is contain key '34'? " + mhm.containsKey("34"));
		System.out.println("Is contain key '22'? " + mhm.containsKey("22"));
		System.out.println("Is contain key '52'? " + mhm.containsKey("52"));
		System.out.println("Is contain key '51'? " + mhm.containsKey("51"));
		
  }
}