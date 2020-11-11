package Graphes;

import java.util.ArrayList;

public interface IGrapheAlgo {

	//Algorithmes obligatoires
	
	//calculer la densite du graphe (nombre d'arcs sur nombre maximum d'arcs possibles)
	public double calculerDensite();
	//parcours en largeur à partir d'un sommet
	public ArrayList<Integer> parcourEnLargeur(int numeroSommet);
	
	//Algorithmes bonus
	
	//calculer le nombre moyen de voisins 
	public double calculerNombreMoyenVoisins();
	//retourner l'ensemble des predecesseurs  d'un noeud (les origines des arcs entrants dans le noeud)
	public ArrayList<Integer> predecesseursDuNoeud(int numeroSommet);
	//savoir si deux sommets sont reliés par un chemin orienté d'arcs
	public boolean existeChemin(int sommetDepart, int sommetArrive);
	//construire le plus petit graphe symetrique contenant ce graphe
	public IGraphe plusPetitGrapheSymetrique();
	//construire le graphe complementaire de ce graphe
	public IGraphe grapheComplementaire();
	
	//Algorithme difficile

	//trouver le plus court chemin entre deux sommets
	public ArrayList<Integer> plusCourtChemin(int sommetDepart, int sommetArrive);
}
