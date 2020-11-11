
package Graphes;

import java.util.ArrayList;

public class GrapheBaseAlgo extends GrapheBase implements IGrapheAlgo{

	// ETAPE 1 : implémentez les algorithmes suivants en utilisant les fonctions de GrapheBase
	//
	//public void ajouterArc(int numeroSortant, int numeroEntrant)
	//	ajoute un arc depuis numeroSortant vers numeroEntrant
	//
	//public ArrayList<Integer> arcsSortants(int numeroSommet)
	//	retourne le numero des sommets de tous les acrs sortants du sommet donne en parametre
	//
	//public int nombreDeSommets()
	//	retourne le nombre total de sommets du graphe
	//
	//public void marquerSommet(int numeroSommet)
	//	place une marque sur le sommet
	//
	//public boolean testSommetMarque(int numeroSommet)
	//	test si vous avez place une marque sur le sommet
	//
	//public void effacerMarques()
	//	efface toutes les marques 
	
	public GrapheBaseAlgo(int nombreDeSommets) {
		super(nombreDeSommets);
	}

	//Algorithmes obligatoires
	//
	// implantez les deux algorithmes suivants :
	//	calculerDensite
	//	parcourEnLargeur
	
	//calculer la densité du graphe, c'est a dire le nombre d'arcs sur nombre maximum d'arcs possibles (pour connaître le nombre maximum d'arcs possible il faut se rappeler que tous les sommets peuvent être connectés a tous les sommets y compris soi-même, et que dans un graphe orienté l'arc a->b est diérent de l'arc b->a)
	// Max E directed graph = |V|(|V|-1)
	// densité directed graph = |E| / |V|(|V|-1)
	public double calculerDensite()

	{
    int nbArcs = 0;
    for(int i=0;i<nombreDeSommets();i++)
    {
      nbArcs +=arcsSortants(i).size();
    }
    
    int nbMaxArcs = nombreDeSommets()*nombreDeSommets();
    
    //System.out.println("nb arcs : " + nbArcs);
    //System.out.println("nb arcs Max: " + nbMaxArcs);
    
    //il faut caster en double pour pas que ça arondisse tout seul
    //à 0
		return (double)nbArcs/(double)nbMaxArcs;
	}
	
	
	
	
	
	/*
	
	//parcours en largeur à partir d'un sommet (voir sujet de tp !)
	public ArrayList<Integer> parcourEnLargeur(int numeroSommet)
	{
		boolean isLastNode = false;
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> edge = new ArrayList<Integer>();
		
		
		if(!arcsSortants(numeroSommet).isEmpty())
			edge.addAll(arcsSortants(numeroSommet));
		res.add(numeroSommet);
		while(!isLastNode) {
			if(edge.isEmpty()) 
				isLastNode = true;
			else {
				ArrayList<Integer> nextEdge = new ArrayList<Integer>();
				for(int e:edge) {
					if(!res.contains(e)) {
						res.add(e);
						nextEdge.addAll(arcsSortants(e));
					} // end if
				} // end for
				edge = nextEdge;
			} // end else
		} // end while
		
		return res;
	} // end parcourEnLargeur()
	
	
	
	*/
	
	public ArrayList<Integer> parcourEnLargeur(int numeroSommet)
	{
    ArrayList<Integer> resultat=new ArrayList<Integer>();
    ArrayList<Integer> voisins=new ArrayList<Integer>();
    voisins.add(numeroSommet);
    int voisinCourant = 0;
    while(voisinCourant<voisins.size()){
      resultat.add(voisins.get(voisinCourant));
      for(int i = 0 ; i<arcsSortants(voisins.get(voisinCourant)).size(); i++)
      {
        if(!voisins.contains(arcsSortants(voisins.get(voisinCourant)).get(i)))
        {
          voisins.add(arcsSortants(voisins.get(voisinCourant)).get(i));
        }
      }
      voisinCourant++;
    }
		return resultat;
	}
	
	
	/*
	
	
	//parcours en largeur à partir d'un sommet
		public ArrayList<Integer> parcourEnLargeur(int numeroSommet)
		{
			ArrayList<Integer> ret = new ArrayList<>();
			effacerMarques();
			ret.add(numeroSommet);
			marquerSommet(numeroSommet);				
			for(int i = 0; i < ret.size();i++)
			{
				for(Integer sortant : arcsSortants(ret.get(i)))
				{
					if(!testSommetMarque(sortant))
					{
						ret.add(sortant);	
						marquerSommet(sortant);				
					}
				}		
			}		
			return ret;
		}
		
		
		
		*/
	

	//Algorithmes bonus
	//
	// implantez au moins deux des algorithmes suivants :
	
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
	//// FACULTATIF

	//trouver le plus court chemin entre deux sommets
	public ArrayList<Integer> plusCourtChemin(int sommetDepart, int sommetArrive)
	{
		return null;
	}	
}


