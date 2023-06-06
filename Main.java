import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
public static void main(String[] args) throws IOException {

		String nameInFile = args[0];
		FileInputStream inFile = new FileInputStream(nameInFile);
		File outFile = new File(args[1]);
		File DebugFile = new File("DebugFile.txt");
		
		BufferedWriter debugfile = new BufferedWriter(new FileWriter(DebugFile, true));
		BufferedWriter outfile = new BufferedWriter(new FileWriter(outFile, true));

		HuffmanCoding test = new HuffmanCoding();
		linkedlist LL = new linkedlist();
		BinaryTree BT = new BinaryTree();

		//computeCharCounts (inFile, charCountAry)
		test.computeCharCounts(test.charCountAry, inFile);

		//printCountAry (charCountAry, outFile)	
		test.printCountAry(test.charCountAry, outfile);

		//constructHuffmanLList (charCountAry, outFile)
		LL.listHead = test.constructHuffmanList(test.charCountAry, debugfile);

		//printList (listHead, outFile)
		LL.printList(LL.listHead, outfile);

		//constructHuffmanBinTree (listHead, outFile)
		BT.root = test.constructHuffmanBinTree(LL.listHead, debugfile);

		//preOrderTraversal (Root, outFile)
		BT.preOrderTraversal(BT.root, outfile);

		//inOrderTraversal (Root, outFile)
		BT.inOrderTraversal(BT.root, outfile);

		//postOrderTraversal (Root, outFile)
		BT.postOrderTraversal(BT.root, outfile);

		//constructCharCode
		test.constructCharCode(BT.root, "");

		//userInterFace
		test.userInterface(BT.root, outfile);

		//close all files.
		inFile.close();
		outfile.close();
		debugfile.close();
}
}
