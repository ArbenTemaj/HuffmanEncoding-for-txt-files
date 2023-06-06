import java.io.BufferedWriter;
import java.io.IOException;

public class linkedlist {

		protected treeNode listHead;

		public linkedlist() { listHead = new treeNode("dummy", 0, "", null, null, null); }

		public treeNode findSpot(treeNode listHead, treeNode newNode) {

			treeNode Spot = listHead;

			while(Spot.next != null && ((Spot.next).frequency) < newNode.frequency)
			{
				Spot = Spot.next;
			}
			return Spot;
		}

		public void insertNewNode(treeNode listHead, treeNode newNode) {

			treeNode Spot = findSpot(listHead, newNode);

			newNode.next = Spot.next;
			Spot.next = newNode;
		}

		public void printList(treeNode listhead, BufferedWriter outFile) throws IOException {

			while(listhead != null)
			{
				listhead.printNode(listhead, outFile);
				listhead = listhead.next;
			}
		}
}