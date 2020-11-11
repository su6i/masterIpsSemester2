package streamsIterateurs;

//LAMRIOU Imane , SHIRALI POUR Amir

public class mainDirectionLycee {
	public static void main(String[] args) {
		
	//EmployeLycee(nom,prenom,anneeRecrutement,categorie,corps,grade,echelon)
		
		EmployeLycee jeanne = 
				new EmployeLycee("Laforet","jeanne",40,2010,Categorie.A,
								"personnel de direction","classe normale",4);
		EmployeLycee amine = 
				new EmployeLycee("Sahraoui","Amine",50,1999,Categorie.A,
								"personnel de direction","hors classe",6);
		EmployeLycee max = 
				new EmployeLycee("Johnson","Max",37,2015,Categorie.B,
								"professeur","classe ordinaire",3);
		EmployeLycee luigi = 
				new EmployeLycee("Santiago","luigi",29,2018,Categorie.B,
								"agent administratif","classe ordinaire",2);
		EmployeLycee josette = 
				new EmployeLycee("Duchateau","Josette",55,2000,Categorie.A,
								"cadre administratif","classe exceptionelle",7);
		
		DirectionLycee directionLyceeSimoneVeil= new DirectionLycee();
		directionLyceeSimoneVeil.setProviseur(jeanne);
		directionLyceeSimoneVeil.setProviseurAdjoint(amine);
		directionLyceeSimoneVeil.setConseillerPrincipaldEducation(luigi);
		directionLyceeSimoneVeil.setGestionnaire(josette);
		directionLyceeSimoneVeil.setChefDeTravaux(max);
		
		System.out.println(directionLyceeSimoneVeil);
		
		System.out.println("age moyen ="+directionLyceeSimoneVeil.ageMoyen());
		
		System.out.println("recrutes apres 2010"+directionLyceeSimoneVeil.recruteApres(2010));		

		System.out.println("noms des membres de la direction : ");
		directionLyceeSimoneVeil.afficheNoms();		

		System.out.println("noms des membres de la direction recrutes apres 2010 : ");
		directionLyceeSimoneVeil.afficheNomsRecrutesApres(2010);
		
		// appeler les methodes ecrites avec l'iterateur
		    //AgeMoyen
		System.out.println("l'age moyen2 avec l'iterateur est : "+ directionLyceeSimoneVeil.ageMoyen2());
		
		System.out.println("l'age moyen3 avec l'iterateur de maniere explicite est : "+ directionLyceeSimoneVeil.ageMoyen3());
		
		    //RecruteApresIterateur
		System.out.println("recrutes apres 2010 Iterateur :"+directionLyceeSimoneVeil.recruteApresIterateur(2010));	
		    
		   //AfficheNomIterateur
		System.out.println("Affichage des noms Iterateur :");directionLyceeSimoneVeil.afficheNomsIterateur();
		
		//AfficheNomRecruteApresIterateur
		System.out.println("Affichage des noms recrute apres Iterateur 2010 :");directionLyceeSimoneVeil.afficheNomRecrutesApresIterateur(2010);
		
		
		// appeler les methodes ecrites avec des streams
		System.out.println("les membres sont : "+ directionLyceeSimoneVeil.membres());
		
		System.out.println("l'age moyen avec le Stream est : "+ directionLyceeSimoneVeil.ageMoyenStream());
		
		System.out.println("recrutes apres 2010 Stream:"+directionLyceeSimoneVeil.recruteApresStream(2010));	
	    
		System.out.println("Affichage des noms Stream :");directionLyceeSimoneVeil.afficheNomsStream(2010);
		
		System.out.println("Affichage des noms recrute apres Stream 2010 :");directionLyceeSimoneVeil.afficheNomsRecruteApresStream(2010);
		
		
       // appeler les méthodes de synthèse
		//appeller la m�thode retournant l'age moyen des membres d'une certaine categorie recrutes avant une certaine annee 		
		System.out.println("la synthese de l'age moyen de la categorie A dont l'anne est 2010 : "+ directionLyceeSimoneVeil.syntheseAgeMoyen(Categorie.A, 2010));
		
		System.out.println("la synthese de l'age moyen Iterateur de la categorie A dont l'anne est 2010 : "+ directionLyceeSimoneVeil.syntheseAgeMoyenIterateur(Categorie.A, 2010));
		
		System.out.println("la synthese de l'age moyen Stream de la categorie A dont l'anne est 2010 : "+ directionLyceeSimoneVeil.ageMoyenSyntheseStream(Categorie.A, 2010));

		
		// appeller la methode retournant l'annee de recrutement la plus ancienne pour les employes d'un certain corps
		System.out.println("l'annee de recrutement ancienne de categorie A  : "+ directionLyceeSimoneVeil.anneeRecrutementAncienne(Categorie.A));
		
		System.out.println("l'annee de recrutement ancienne avec Iterateur de categorie A  : "+ directionLyceeSimoneVeil.anneeRecrutementAncienneIterateur(Categorie.A));
		
		System.out.println("l'annee de recrutement ancienne avec Stream de categorie A  : "+ directionLyceeSimoneVeil.anneeRecrutementAncienneStream(Categorie.A));



		}
}
