public class LCA {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.data) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.data) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}

	public static Node LCA_of_nodes(Node root, Node a, Node b) {
		if (root == null)
			return null;
		if (root.data == a.data || root.data == b.data)
			return root;

		Node left = LCA_of_nodes(root.left, a, b);
		Node right = LCA_of_nodes(root.right, a, b);

		if (left != null && right != null)
			return root;
		if (left == null)
			return right;
		else
			return left;

	}

	public static void main(String[] args) {


	}

	public static Node createBinaryTree() {

		Node root = new Node(40);
		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node25 = new Node(25);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		Node node5 = new Node(5);
		Node node45 = new Node(45);
		Node node55 = new Node(55);

		root.left = node20;
		root.right = node60;

		node20.left = node10;
		node20.right = node25;

		node60.left = node50;
		node60.right = node70;

		node10.left = node5;
		node50.right = node55;
		return root;
	}
}

// This code is contributed by Sreenivasulu Rayanki. 
