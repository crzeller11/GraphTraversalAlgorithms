import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// create the graph
		Graph g = new Graph();
        Graph h = new Graph();

		// create the nodes first
		g.addNode("Z");
		g.addNode("Y");
		g.addNode("X");
		g.addNode("W");
		g.addNode("V");
		g.addNode("U");
		g.addNode("T");
		g.addNode("S");

        // new test case
		h.addNode("A");
		h.addNode("B");
		h.addNode("C");
		h.addNode("D");
		h.addNode("E");


		// create the edges
		g.addEdge(g.getNode("Z"), g.getNode("Y"), 1);
		g.addEdge(g.getNode("Y"), g.getNode("Z"), 1);
		g.addEdge(g.getNode("Z"), g.getNode("X"), 2);
		g.addEdge(g.getNode("X"), g.getNode("W"), 1);
		g.addEdge(g.getNode("X"), g.getNode("U"), 4);
		g.addEdge(g.getNode("W"), g.getNode("V"), 1);
		g.addEdge(g.getNode("V"), g.getNode("U"), 1);
		g.addEdge(g.getNode("U"), g.getNode("T"), 5);
		g.addEdge(g.getNode("V"), g.getNode("S"), 5);
		g.addEdge(g.getNode("U"), g.getNode("S"), 3);

        h.addEdge(h.getNode("A"), h.getNode("B"), 2);
        h.addEdge(h.getNode("A"), h.getNode("C"), 1);
        h.addEdge(h.getNode("B"), h.getNode("D"), 2);
        h.addEdge(h.getNode("C"), h.getNode("D"), 1);
        h.addEdge(h.getNode("D"), h.getNode("E"), 2);

		// print out the graph for verification
		g.print();
        h.print();
		System.out.println();

		SearchAlgorithm algo = new SearchAlgorithm();
		NodeList result_g;
        NodeList result_h;

		// depth first search
		System.out.println("Depth First Search Results (graph g):");
		result_g = algo.DepthFirstSearch(g.getNode("Z"), g.getNode("S"));
        result_h = algo.DepthFirstSearch(h.getNode("A"), h.getNode("E"));
		for (Iterator<Node> it = result_g.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
        System.out.println("Depth First Search Results (graph h):");
        for (Iterator<Node> it = result_h.iterator(); it.hasNext(); ) {
            System.out.println(it.next().getValue());
        }
		System.out.println();

		// breadth first search
		System.out.println("Breadth First Search Results (graph g):");
		result_g = algo.BreadthFirstSearch(g.getNode("Z"), g.getNode("S"));
        result_h = algo.BreadthFirstSearch(h.getNode("A"), h.getNode("E"));
		for (Iterator<Node> it = result_g.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
        System.out.println("Breadth First Search Results (graph h):");
        for (Iterator<Node> it = result_h.iterator(); it.hasNext(); ) {
            System.out.println(it.next().getValue());
        }
		System.out.println();

		// uniform cost search
		System.out.println("Uniform Cost Search Results (graph g):");
		result_g = algo.UniformCostSearch(g.getNode("Z"), g.getNode("S"));
        result_h = algo.UniformCostSearch(h.getNode("A"), h.getNode("S"));
		for (Iterator<Node> it = result_g.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
        System.out.println("Uniform Cost Search Results (graph h):");
        for (Iterator<Node> it = result_h.iterator(); it.hasNext(); ) {
            System.out.println(it.next().getValue());
        }
		System.out.println();

	}

}
