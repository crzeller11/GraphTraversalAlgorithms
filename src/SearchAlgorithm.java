import java.util.Iterator;


public class SearchAlgorithm {
	public NodeList DepthFirstSearch(Node start, Node end) {
		NodePriorityQueue priorityqueue = new NodePriorityQueue(); // using PriorityQueue to implement stack
		NodeList nodes_visited = new NodeList(); // list to track visited nodes in order
		int priority = 0; //initialize priority rank

		priorityqueue.add(start, priority); // push start node to "stack"

		while (!priorityqueue.isEmpty())  {
			Node cur = priorityqueue.poll(); // pop from the stack

			if (cur.equals(end)) { // if the current node is the end, add end to visited and break
				nodes_visited.add(cur);
                break;
			}

            nodes_visited.add(cur); // add the current node to visited
            priority--; // update priority to maintain stack

			for (Iterator<Edge> it = cur.getChildren(); it.hasNext();) { // for the children of the current node
				Edge edge = it.next();
				Node child = edge.getChild();

				if (!nodes_visited.contains(child)) { // if the child has not already been visited, add to stack
					priorityqueue.add(child, priority);
				}
			}
		}

		return nodes_visited; // return list of visited nodes

	}

	public NodeList BreadthFirstSearch(Node start, Node end) {

		NodePriorityQueue priorityqueue = new NodePriorityQueue(); // using PriorityQueue to implement queue
		NodeList nodes_visited = new NodeList(); // list to track visited nodes in order
		int priority = 0; // initialize priority rank

		priorityqueue.add(start, priority); // add start to queue

		while (!priorityqueue.isEmpty()) {
			Node cur = priorityqueue.poll(); // poll from qyeye

			if (cur.equals(end)) { // if the current node is the end, add end to visited and break
                nodes_visited.add(cur);
                break;
			}

            if (nodes_visited.contains(cur)) { // if the current node has already been visited, then continue
                continue;
            }

            nodes_visited.add(cur); // visit cur node
            priority++; // update priority to maintain queue
			for (Iterator<Edge> it = cur.getChildren(); it.hasNext();) { // iterate through children of current node
				Edge edge = it.next();
				Node child = edge.getChild();

				if (!nodes_visited.contains(child)) { // if child is unvisited, add to queue
					priorityqueue.add(child, priority);
				}
			}
        }

		return nodes_visited; // return list of visited nodes

	}



	public NodeList UniformCostSearch(Node start, Node end) {
		NodePriorityQueue priorityqueue = new NodePriorityQueue(); // initialize priority queue
		NodeList nodes_visited = new NodeList(); // list to track visited nodes in order

		priorityqueue.add(start, 0); // add start to priority queue

		while (!priorityqueue.isEmpty()) {

            int prev_cost = priorityqueue.peekPriority(); // save the value of cost so far
			Node cur = priorityqueue.poll(); // poll from the priority queue

			if (nodes_visited.contains(cur)) { // if the current node has been visited, continue
				continue;
			}

            if (cur.equals(end)) { // if the current node is the end, visit the end and break
                nodes_visited.add(cur);
                break;
            }

			nodes_visited.add(cur); // visit the current node

			for (Iterator<Edge> it = cur.getChildren(); it.hasNext();) { // iterate through children of current node
				Edge edge = it.next();
                Node child = edge.getChild();

				int edge_cost = edge.getWeight(); // get weight of edge leading to child
				int cost = edge_cost + prev_cost; // calculate weight of going to child node

				priorityqueue.add(child, cost); // add the child and its cost to priority queue
			}
		}

		return nodes_visited; // return list of visited nodes

	}

	public NodeList UniformCostSearchWithPath(Node start, Node end) {
		// 0 point challenge question
		return new NodeList();
	}

}


void recur_print(Node n) {
	if (n == null) {
	} else {
		recur_print(n.left);
		System.out.println(n.value);
		recur_print(n.right);
	}
}