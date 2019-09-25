import static org.junit.Assert.*;

import org.junit.Test;

public class LCAtest1 {

	@Test
	public void testFindLCAIntInt() {
		// fail("Not yet implemented");
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5): " + tree.findLCA(4, 5));
		System.out.println("LCA(4, 6): " + tree.findLCA(4, 6));
		System.out.println("LCA(3, 4): " + tree.findLCA(3, 4));
		System.out.println("LCA(2, 4): " + tree.findLCA(2, 4));
		
		assertEquals("Checking for lowest common ancestor of nodes 4 and 5 ",2, tree.findLCA(4,5));
		assertEquals("Checking for lowest common ancestor of nodes 4 and 6 ",1, tree.findLCA(4,6));
		assertEquals("Checking for lowest common ancestor of nodes 3 and 4 ",1, tree.findLCA(3,4));
		assertEquals("Checking for lowest common ancestor of nodes 2 and 4 ",2, tree.findLCA(2,4));
		

		/*
		 * LCA(4, 5) = 2 LCA(4, 6) = 1 LCA(3, 4) = 1 LCA(2, 4) = 2
		 */

	}

	@Test
	public void testFindLCANodeIntInt() {
		// fail("Not yet implemented");
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

	}
}
