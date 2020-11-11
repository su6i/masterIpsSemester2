package Graphes;

import java.util.ArrayList;

public class GrapheImplementationAlgo implements IGraphe, IGrapheAlgo{

	// ETAPE 2 : implémentez votre propre structure de graphe (matrice adjacence, liste de sucesseurs ...)
	//	selon votre choix de structure, il est possible de rendre vos algorithmes plus performants. 
	public GrapheImplementationAlgo(int nombreDeSommets) {
		
	}
	
	public void ajouterArc(int numeroSortant, int numeroEntrant) {

	}

	public ArrayList<Integer> arcsSortants(int numeroSommet) {
		return null;
	}

	public int nombreDeSommets() {
		return 0;
	}
	
	//	selon votre choix de structure, il est possible de rendre vos algorithmes plus performants. Dans un premier temps vous pouvez copier-coller vos anciens algorithmes afin de tester votre structure.

	//Algorithmes obligatoires	
	//calculer la densite du graphe (nombre d'arcs sur nombre maximum d'arcs possibles)
	public double calculerDensite()
	{
		return 0.0;
	}
	
	//parcours en largeur à partir d'un sommet
	public ArrayList<Integer> parcourEnLargeur(int numeroSommet)
	{
		return null;
	}

	//Algorithmes bonus
	//calculer le nombre moyen de voisins 
	public double calculerNombreMoyenVoisins()
	{
		return 0.0;
	}
	
	//retourner l'ensemble des predecesseurs  d'un noeud (les origines des arcs entrants dans le noeud)
	public ArrayList<Integer> predecesseursDuNoeud(int numeroSommet)
	{
		return null;
	}
	
	//savoir si deux sommets sont reliés par un chemin orienté d'arcs
	public boolean existeChemin(int sommetDepart, int sommetArrive)
	{
		return false;
	}	
	
	//construire le plus petit graphe symetrique contenant ce graphe
	public IGraphe plusPetitGrapheSymetrique()
	{
		return null;
	}
	
	//construire le graphe complementaire de ce graphe
	public IGraphe grapheComplementaire()
	{
		return null;
	}

	//Algorithme difficile
	//trouver le plus court chemin entre deux sommets
	public ArrayList<Integer> plusCourtChemin(int sommetDepart, int sommetArrive)
	{
		return null;
	}	
}


