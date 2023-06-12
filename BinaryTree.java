import java.io.BufferedWriter;
import java.io.IOException;

public class BinaryTree {

		protected treeNode root;

		public BinaryTree() { root = null; }

		public boolean isLeaf(treeNode node) { return node.left == null && node.right == null; }

		public void preOrderTraversal(treeNode t, BufferedWriter outFile) throws IOException{

			if(isLeaf(t)){ t.printNode(t, outFile); }
			else {
					t.printNode(t, outFile);
					preOrderTraversal(t.left, outFile);
					preOrderTraversal(t.right, outFile);
				}
		}

		public void inOrderTraversal(treeNode t, BufferedWriter outFile) throws IOException {

			if(isLeaf(t)){ t.printNode(t, outFile); }
			else {
					inOrderTraversal(t.left, outFile);
					t.printNode(t, outFile);
					inOrderTraversal(t.right, outFile);
				}
		}

		public void postOrderTraversal(treeNode t, BufferedWriter outFile) throws IOException {

			if(isLeaf(t)){ t.printNode(t, outFile); }
			else {
					t.printNode(t, outFile);
					postOrderTraversal(t.left, outFile);
					postOrderTraversal(t.right, outFile);
				}
		}
}
