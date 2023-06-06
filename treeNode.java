import java.io.BufferedWriter;
import java.io.IOException;

public class treeNode {

			protected String chStr;
			protected int frequency;
			protected String code;
			protected treeNode left;
			protected treeNode right;
			protected treeNode next;

			public treeNode(String ch, int f, String c, treeNode l, treeNode r, treeNode n) {
					this.chStr = ch;
					this.frequency = f;
					this.code = c;
					this.left = l;
					this.right = r;
					this.next = n;
			}

			public void printNode(treeNode T, BufferedWriter outfile) throws IOException {

				outfile.write("[ch]: " + T.chStr + " ");
				outfile.write("[freq]: " + T.frequency + " ");
				outfile.write("[code]: " + T.code + " ");

				if(T.next == null){outfile.write("[next ch]: NULL "); }
				else outfile.write("[next ch]: " + (T.next).chStr + " ");

				if(T.left == null){outfile.write("[left ch]: NULL "); }
				else outfile.write("[next ch]: " + (T.left).chStr + " ");

				if(T.right == null){outfile.write("[right ch]: NULL\n"); }
				else outfile.write("[right ch]: " + (T.right).chStr + "\n");

			}
}