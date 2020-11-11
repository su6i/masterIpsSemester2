package Graphes;

public class Main
{
	public static void main(String[] args) 
	{
		IGraphe g = new GrapheBaseAlgo(13);
		remplirGrapheTest1(g);
		AfficheurGraphe.changerLongueurArcs(6.0); // valeur par defaut : 3
		AfficheurGraphe.afficherGraphe(g);
		testerTousLesAlgos((IGrapheAlgo)g);		
	}
	
	public static void testerTousLesAlgos(IGrapheAlgo g)
	{
		int sommet1,sommet2;
		sommet1 = 5;
		sommet2 = 10;

		System.out.println("========================================");
		System.out.println("=========    DEBUT TEST     ============");
		System.out.println("========================================");


		//Algorithmes obligatoires
		System.out.println("densite : " + g.calculerDensite());
		System.out.println("parcours largeur depuis " +sommet1+" : " + g.parcourEnLargeur(sommet1));
		
		//Algorithmes bonus
		System.out.println("nb voisin moyen : " + g.calculerNombreMoyenVoisins());
		System.out.println("predecesseurs de " +sommet1+" : " + g.predecesseursDuNoeud(sommet1));
		System.out.println("existe chemin depuis "+sommet2+" vers "+sommet1+ " : "+g.existeChemin(sommet2, sommet1));

		//IGraphe symetrique = g.plusPetitGrapheSymetrique();
		//AfficheurGraphe.afficherGraphe(symetrique);
		//IGraphe complementaire = g.grapheComplementaire();
		//AfficheurGraphe.afficherGraphe(complementaire);
		
		//Algorithmes difficile
		System.out.println("existe chemin depuis "+sommet2+" vers "+sommet1+ " : "+g.plusCourtChemin(sommet2, sommet1));
    
		System.out.println("========================================");
		System.out.println("=========      FIN TEST     ============");
		System.out.println("========================================");
	}
	
	public static void remplirGrapheTest1(IGraphe g)
	{
		g.ajouterArc(1, 12);
		g.ajouterArc(12, 1);

		g.ajouterArc(4, 0);
		g.ajouterArc(4, 5);
		g.ajouterArc(5, 6);
		g.ajouterArc(5, 8);
		g.ajouterArc(6, 9);
		g.ajouterArc(8, 9);
		g.ajouterArc(9, 4);
		g.ajouterArc(9, 10);
		g.ajouterArc(10, 11);
		g.ajouterArc(10, 2);
		g.ajouterArc(2, 5);
		g.ajouterArc(2, 3);
		g.ajouterArc(2, 7);
		g.ajouterArc(7, 10);
	}
	
	public static void remplirGrapheTest2(IGraphe g)
	{
		g.ajouterArc(0, 0);
		g.ajouterArc(0, 1);
		g.ajouterArc(1, 0);
		g.ajouterArc(1, 1);
	}
}

