import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class HuffmanCoding extends BinaryTree{

		protected int[] charCountAry;
		protected String[] charCode;

		public HuffmanCoding() {
			charCountAry = new int[256];
			charCode = new String[256];	
		}

		public void computeCharCounts(int[] charCountAry, FileInputStream inFile) throws IOException {

				InputStreamReader fr = new InputStreamReader(inFile);
				BufferedReader br = new BufferedReader(fr);
				int index = 0;

				while((index = br.read()) != -1)
				{
					charCountAry[index]++;
				}

				fr.close();
				br.close();
		}

		public void printCountAry(int[] charCountAry, BufferedWriter outfile) throws IOException{

				outfile.write("====Print Count Array function====\n");

				for(int i = 0; i < charCountAry.length; i++)
				{
					if(charCountAry[i] > 0)
					{
						outfile.write("Char: " + i + "  Count: " + charCountAry[i] + "\n");
					}
				}
				outfile.write("====End of Print Count Array Function====\n");
		}

		public treeNode constructHuffmanList(int[] charCountAry, BufferedWriter outfile) throws IOException {

			
				outfile.write("====Beginning of ConstructHuffmanList====\n");

				linkedlist LL = new linkedlist();
				int index = 0;

				while(index < 256)
				{

					if(index == 10)// if its \n
					{
						int frequency = charCountAry[index];
						treeNode newNode = new treeNode("\\n", frequency, "", null, null, null);
						treeNode Spot = LL.findSpot(LL.listHead, newNode);
						LL.insertNewNode(LL.listHead, newNode);
						LL.printList(LL.listHead, outfile);
					}

					else if(index == 13)// if its \r
					{
						int frequency = charCountAry[index];
						treeNode newNode = new treeNode("\\r", frequency, "", null, null, null);
						treeNode Spot = LL.findSpot(LL.listHead, newNode);
						LL.insertNewNode(LL.listHead, newNode);
						LL.printList(LL.listHead, outfile);
					}

					else if(index == 32)// if its space
					{
						int frequency = charCountAry[index];
						treeNode newNode = new treeNode(" ", frequency, "", null, null, null);
						treeNode Spot = LL.findSpot(LL.listHead, newNode);
						LL.insertNewNode(LL.listHead, newNode);
						LL.printList(LL.listHead, outfile);
					}


					else if(charCountAry[index] > 0)//if its anything else
					{
						char c = (char)index;
						int frequency = charCountAry[index];
						treeNode newNode = new treeNode(Character.toString(c), frequency, "", null, null, null);
						treeNode Spot = LL.findSpot(LL.listHead, newNode);
						LL.insertNewNode(LL.listHead, newNode);
						LL.printList(LL.listHead, outfile);
					}

					index++;
				}

				outfile.write("====End of ConstructHuffmanList====\n");
				return LL.listHead;
		}	

		public treeNode constructHuffmanBinTree(treeNode listhead, BufferedWriter outfile) throws IOException {

				outfile.write("====Beginning of ConstructHuffmanBinTree====\n");

				linkedlist LL = new linkedlist();
				LL.listHead = listhead;

				String chStr;

				while(LL.listHead.next.next != null)
				{
					int freq = (LL.listHead.next).frequency + (LL.listHead.next.next).frequency;
					chStr = (LL.listHead.next).chStr + (LL.listHead.next.next).chStr;

					treeNode newNode = new treeNode(chStr, freq, "", LL.listHead.next, LL.listHead.next.next, null);

					LL.insertNewNode(listhead, newNode);

					LL.listHead.next = LL.listHead.next.next.next;

					LL.printList(LL.listHead, outfile);
				}
				
				treeNode root = LL.listHead.next;
				outfile.write("====End of ConstructHuffmanBinTree====\n");
				return root;
		}

		public void constructCharCode(treeNode T, String code) {

				int index;

				if(isLeaf(T))
				{
					T.code = code;

					if(T.chStr.equals("\\n"))
					{
						index = 10;
						charCode[index] = code;
					}
					else if(T.chStr.equals("\\r"))
					{
						index = 13;
						charCode[index] = code;
					} else {

						index = (int)T.chStr.charAt(0);
						charCode[index] = code;
					}

				} else {
					constructCharCode(T.left, code + "0");
					constructCharCode(T.right, code + "1");
				}
		}

		public void Encode(File orgFile, File compFile, BufferedWriter outfile) throws IOException{

				FileReader fr = new FileReader(orgFile);
				BufferedReader br = new BufferedReader(fr);

				
				BufferedWriter outComp = new BufferedWriter(new FileWriter(compFile, true));

				int index = 0;
				String code = "";

				while((index = br.read()) != -1)
				{
					code = charCode[index];

					outfile.write("Index: " + index + " code:" + code + "\n");
					outComp.write(code);
				}
				outComp.write(code);
				br.close();
				outComp.close();
		}

		public void Decode(File compFile, FileOutputStream deCompFile, treeNode root) throws IOException {

				PrintWriter deComp = new PrintWriter(deCompFile);

				FileReader fr = new FileReader(compFile);
				BufferedReader br =  new BufferedReader(fr);

				int oneBit;

				treeNode Spot = root;

				while((oneBit = br.read()) != -1)
				{
					if(isLeaf(Spot))
					{
						if(Spot.chStr.equals("\\r")){ deComp.print("\r"); }
						else if(Spot.chStr.equals("\\n")){ deComp.print("\n"); }
						else{ deComp.print(Spot.chStr); }
						Spot = root;
					}

					if(oneBit == 48)
					{
						Spot = Spot.left;
					}

					else if(oneBit == 49)
					{
						Spot = Spot.right;
					} else {
						System.out.println("Error! the compress file contains invalid character!");
						System.exit(0);
					}
				}
				br.close();
				deComp.close();
		}

		public void userInterface(treeNode root, BufferedWriter outFile) throws IOException, FileNotFoundException {

				Scanner scnr = new Scanner(System.in);
				Scanner scnr2 = new Scanner(System.in);
				String nameOrg, nameCompress, nameDeCompress;
				char yesNo = ' ';

				while(yesNo != 'N')
				{
					System.out.println("Do you want to encode the file?");
					System.out.println("Type: 'Y' for yes / 'N' for no");
					yesNo = scnr.next().charAt(0);

					if(yesNo == 'N')
					{
						System.exit(0);
					} else {
						System.out.println("What do you want to name the file?");
						nameOrg = scnr2.nextLine();
						nameCompress = nameOrg + "_Compressed.txt";
						nameDeCompress = nameOrg + "_DeCompressed.txt";
						nameOrg += ".txt";

						File orgFile = new File(nameOrg);
						File compFile = new File(nameCompress);
						FileOutputStream deCompFile = new FileOutputStream(nameDeCompress);

						Encode(orgFile, compFile, outFile);
						Decode(compFile, deCompFile, root);
					}
				}
				scnr.close();
				scnr2.close();
		}
}