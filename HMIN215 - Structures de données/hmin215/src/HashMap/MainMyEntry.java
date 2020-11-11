package HashMap;

//Amir SHIRALI POUR


public class MainMyEntry {

	public static void main(String[] args) {

		// Suivant les associations que l'on crée
		// la clef et la valeur sont de différents types
		
		// Exemple : une MyEntry avec
		// clef : nom d'une personne célèbre
		// valeur : année de naissance
		
		MyEntry<String,Integer> e0 =
				new MyEntry<>("Manu Dibango",1933);
		
		// Exercices -----------------------------------------
		
		// Déclarer et créer une MyEntry avec
		// clef : numéro du département
		// valeur : département de l'hérault
		
		Departement H = new Departement(
				"Hérault","34",6224,"Montpellier",1444892,342);
				
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

		
		
	}

}
