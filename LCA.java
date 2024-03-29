
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.io.*;
import java.util.*;

//Java program to find single source shortest paths in Directed Acyclic Graphs 
import java.io.*;
import java.util.*;

/*
 * //similar graph implementation to https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
 *similar BST implementation to https://www.geeksforgeeks.org
 
 */

class DAG {
	private int V; // no. vertices
	private int E; // no. edges
	private ArrayList<Integer>[] adj; // adj[V] = adjacency list for vertex V
	private int[] indegree; // indegree[V] = indegree of vertex V
	private int[] outdegree; // outdegree[V] = outdegree of vertex V
	private boolean marked[]; // list of visited vertices
	private boolean hasCycle; // True if graph has cycle
	private boolean stack[]; //

	public DAG(int V) {
		if (V < 0) {
			throw new IllegalArgumentException("Number of vertices must be greater than 0");
		}

		this.V = V;
		this.E = 0;
		indegree = new int[V];
		marked = new boolean[V];
		stack = new boolean[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}

	// Returns current vertex
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	// Adds directed edge from v to w
	public void addEdge(int v, int w) {
		if ((validateVertex(v) > 0) && (validateVertex(w) > 0)) {
			adj[v].add(w);
			indegree[w]++;
			E++;
		} else {
			System.out.println("Please enter numbers between 0 and " + (V - 1));
		}
	}

	private int validateVertex(int v) {
		if (v < 0 || v >= V) {
			return -1;
		} else {
			return 1;
		}
	}

	// Returns number of directed edges to vertex v
	public int indegree(int v) {
		if (validateVertex(v) > 0) {
			return indegree[v];
		} else {
			return 0;
		}

	}

	// Returns number of directed edges from vertex v
	public int outdegree(int v) {
		if (validateVertex(v) > 0) {
			return adj[v].size();
		} else {
			return 0;
		}
	}

	// Returns the adjacent vertices to v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public void findCycle(int v) {
		marked[v] = true;
		stack[v] = true;

		for (int w : adj(v)) {
			if (!marked[w]) {
				findCycle(w);
			} else if (stack[w]) {
				hasCycle = true;
				return;
			}
		}
		stack[v] = false;
	}

	// Method to implement lowest common ancestor
	public int findLCA(int v, int w) {
		findCycle(0);

		if (hasCycle) // Graph is not DAG
		{
			return -1;
		} else if (validateVertex(v) < 0 || validateVertex(w) < 0) {
			// Not valid vertices, ie. non-negative
			return -1;
		} else if (E == 0) {
			// Graph has no edges, ie. empty
			return -1;
		}

		DAG reverse = reverse();

		ArrayList<Integer> array1 = reverse.BFS(v);
		ArrayList<Integer> array2 = reverse.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		boolean found = false;

		for (int i = 0; i < array1.size(); i++) {
			for (int j = 0; j < array2.size(); j++) {
				if (array1.get(i) == array2.get(j)) {
					commonAncestors.add(array1.get(i));
					found = true;
				}
			}
		}

		if (found) {
			// Return first element in list - Lowest Common Ancestor
			return commonAncestors.get(0);
		} else {
			return -1; // None found
		}
	}

	// Prints BFS(Breadth-First search) from source s
	public ArrayList<Integer> BFS(int s) {
		ArrayList<Integer> order = new ArrayList<Integer>();
		boolean visited[] = new boolean[V]; // Marks vertices as not visit
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll(); // Sets s to the head of the list
			order.add(s);

			// Find adjacent vertices to s. If not visited,
			// mark as visited (true) and enqueue
			Iterator<Integer> i = adj[s].listIterator();

			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return order;
	}

	// Reverse DAG
	public DAG reverse() {
		DAG reverse = new DAG(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}
}

// A Binary Tree node 
class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class LCA {

	Node root;
	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	// Finds the path from root node to given root of the tree.
	int findLCA(int n1, int n2) {
		path1.clear();
		path2.clear();
		return findLCAInternal(root, n1, n2);
	}

	private int findLCAInternal(Node root, int n1, int n2) {

		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
			return -1;
		}

		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {

			if (!path1.get(i).equals(path2.get(i)))
				break;
		}

		return path1.get(i - 1);
	}

	// Finds the path from root node to given root of the tree, Stores the
	// path in a vector path[], returns true if path exists otherwise false
	public boolean findPath(Node root, int n, List<Integer> path) {
		// base case
		if (root == null) {
			return false;
		}

		// Store this node . The node will be removed if
		// not in path from root to n.
		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		// If not present in subtree rooted with root, remove root from
		// path[] and return false
		path.remove(path.size() - 1);

		return false;
	}

}
