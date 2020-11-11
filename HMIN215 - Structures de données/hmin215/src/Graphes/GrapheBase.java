package Graphes;

import java.util.ArrayList;
import java.util.Iterator;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class GrapheBase implements IGraphe{
	private int nombreDeSommets;
	private static int instance = 0;
	private Graph graph;
	private boolean[] marques;
	private double [] valeur;
	
	public GrapheBase(int nombreDeSommets)
	{
		this.nombreDeSommets = nombreDeSommets;
		marques = new boolean [nombreDeSommets];
		valeur = new double [nombreDeSommets];
		graph = new MultiGraph("G"+instance);
		instance++;
		for(int i = 0; i < nombreDeSommets; i++)
			graph.addNode(String.valueOf(i));
	}

	@Override
	public void ajouterArc(int numeroSortant, int numeroEntrant) {
		if(numeroSortant >= 0 && numeroSortant < nombreDeSommets && numeroEntrant >= 0 && numeroEntrant < nombreDeSommets)
			graph.addEdge(graph.getId()+" - "+String.valueOf(numeroSortant)+" - "+String.valueOf(numeroEntrant), String.valueOf(numeroSortant),String.valueOf(numeroEntrant),true);
	}

	@Override
	public ArrayList<Integer> arcsSortants(int numeroSommet) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		Iterator<Node> neigbors = graph.getNode(numeroSommet).getNeighborNodeIterator();
		while (neigbors.hasNext())
		{
			Node n =neigbors.next();
			if(n.hasEdgeFrom(numeroSommet))
				ret.add(Integer.parseInt(n.getId()));
		}
		return ret;
	}
	
	@Override
	public int nombreDeSommets() {
		return nombreDeSommets;
	}

	public boolean testSommetMarque(int numeroSommet) {
		if(numeroSommet >= 0 && numeroSommet < nombreDeSommets)
			return marques[numeroSommet];
		return false;
	}
	
	public void marquerSommet(int numeroSommet) {
		if(numeroSommet >= 0 && numeroSommet < nombreDeSommets)
			marques[numeroSommet] = true;
	}

	public void effacerMarques() {
		for(int i = 0; i< nombreDeSommets; i++)
			marques[i] = false;		
	}
	
	public double valeurSommet(int numeroSommet) {
		if(numeroSommet >= 0 && numeroSommet < nombreDeSommets)
			return valeur[numeroSommet];
		return -1.0;
	}
	
	public void changerValeurSommet(int numeroSommet, double valeur) {
		if(numeroSommet >= 0 && numeroSommet < nombreDeSommets)
			this.valeur[numeroSommet] = valeur;
	}

	public void reinitialiserValeursSommet() {
		for(int i = 0; i< nombreDeSommets; i++)
			valeur[i] = -1.0;		
	}
}
