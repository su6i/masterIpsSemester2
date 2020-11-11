package Graphes;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;

public class AfficheurGraphe {
	private static int instance = 0;
	private static double longArcs = 3.0;
	
	private static final String style = 
			" node {"
			+ " shape: circle;"
			+ "	fill-color: rgb(0,0,0);" 
			+ " text-visibility-mode: normal;"
			+ " text-color: white;"
			+ " text-style: bold;"
			+ " text-background-mode: rounded-box;"
			+ " text-background-color: rgb(0,0,0);"
			+ " text-size: 20px;"
			+ "	size: 40px;" 
			+ "	z-index: 1;"
			+ "}"
			+ "edge {\n"
			+ "	shape: cubic-curve;"
			+ "	fill-color: rgb(20,20,20);"
			+ "	arrow-size: 15px, 8px;"
			+ "	size: 3px;" 
			+ "	z-index: 0;"
			+ "}";
	
	public static void afficherGraphe(IGraphe graphe)
	{
		if(graphe != null)
		{
			System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
			Graph graph = new MultiGraph("disp"+instance);
			instance++;
			for(int i = 0; i < graphe.nombreDeSommets(); i++)
			{
				graph.addNode(String.valueOf(i));
				graph.getNode(i).setAttribute("label", String.valueOf(i));
				graph.getNode(i).setAttribute("scale", 100);
				graph.getNode(i).setAttribute("layout.weight", 5);
			}
			for(int i = 0; i < graphe.nombreDeSommets(); i++)
			{
				for(int j :graphe.arcsSortants(i))
				{
					graph.addEdge(graph.getId()+" - "+String.valueOf(i)+" - "+String.valueOf(j), String.valueOf(i),String.valueOf(j), true);	
		
				}			
			}		
			for(Edge e :graph.getEdgeSet())
				e.addAttribute("layout.weight", longArcs);
			graph.addAttribute("ui.stylesheet", style);
			graph.addAttribute("ui.quality");
		    graph.addAttribute("layout.stabilization-limit", 0.5);
		    graph.addAttribute("layout.quality", 1);
		    graph.addAttribute("layout.gravity", 0.01);
			graph.display();
		}
	}
	
	public static void changerLongueurArcs(double lArcs)
	{
		longArcs = lArcs;
	}
}
