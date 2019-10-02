import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class LCAtest1 {

	@Test
	public void testFindLCAInt() {
		// fail("Not yet implemented");
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		assertEquals("Checking for lowest common ancestor of nodes 4 and 5 ", 2, tree.findLCA(4, 5));
		assertEquals("Checking for lowest common ancestor of nodes 2 and 4 ",2, tree.findLCA(2,4));
	
		LCA tree2 = new LCA();
		tree2.root = null;
		assertEquals("Checking for return of -1 for root 0 value", -1, tree2.findLCA(1, 2));
		
		//Test for root of n1 null
		LCA tree4 = new LCA();
		tree4.root = new Node(1);
		tree4.root.left = null;
		tree4.root.right = new Node(2);
		tree4.root.right.right = new Node(4);
		assertEquals("Checking for return of -1 for null value", -1, tree4.findLCA(3, 4));
		
		//Test for root of n2 null
		LCA tree3 = new LCA();
		tree3.root = new Node(1);
		tree3.root.left = new Node(2);
		tree3.root.right = null;
		tree3.root.left.left = new Node(4);
		assertEquals("Checking for return of -1 for null value", -1, tree3.findLCA(4, 5));
		
	}

	@Test
	public void testFindPath() {
		ArrayList<Integer> path1 = new ArrayList();
		LCA tree = new LCA();
		tree.root = null;
		assertEquals("Checking for return of false for null root", false, tree.findPath(tree.root, 2, path1));
		
		ArrayList<Integer> path2 = new ArrayList();
		LCA tree2 = new LCA();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2);
		tree2.root.right = new Node(3);
		assertEquals("Checking for return of true for non null root", true, tree.findPath(tree2.root, 3, path2));
		
		
		

	}
}
