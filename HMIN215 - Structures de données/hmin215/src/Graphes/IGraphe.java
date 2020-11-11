package Graphes;

import java.util.ArrayList;

public interface IGraphe {
	//compatibilite affichage
	public void ajouterArc(int numeroSortant, int numeroEntrant);
	public ArrayList<Integer> arcsSortants(int numeroSommet);
	public int nombreDeSommets();
}
