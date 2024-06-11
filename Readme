# Huffman Encoding/Decoding for text files
[![Build Status](https://img.shields.io/badge/Build_Status-passing-green)](https://github.com/ArbenTemaj/HuffmanEncoding-for-txt-files)


This java program uses huffman encoding to achieve lossless compression for the txt file encoded.
The inFile txt is use to set up or baseline char codes that we will use for the encoding process. 

## Encoding

- Huffman coding is a lossless data compression algorithm. 
- The idea is to assign variable-length codes to input characters.
- lengths of the assigned codes are based on the frequencies of corresponding characters.

```sh
public HuffmanCoding() 
{
	charCountAry = new int[256];
	charCode = new String[256];	
}

public void computeCharCounts(int[] charCountAry, FileInputStream inFile) throws IOException 
{
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
```
> We need a charCountAry[int] and CharCode[string],
> to get the frequencies we read the infile.txt
> charCountAry[index]++ for each char in the .txt
> Now we got frequencies and construct the charCodes.

### _Getting char and frequency of the charCountAry[index]_
```sh
    char c = (char)index;
    int frequency = charCountAry[index];
```

### _constructing the codes_
```sh
    constructCharCode(T.left, code + "0");
	constructCharCode(T.right, code + "1");
```

### See the full the code by clicking on link below ###

[Link to the Repository][df1]


## Decoding

*The program also decodes the txt file as well which is the decompression 
of the compressed file to double check if we get lossless compression.
The main.java is the driver for this project.*

```sh
public void Decode(File compFile, FileOutputStream deCompFile, treeNode root) throws IOException {
	PrintWriter deComp = new PrintWriter(deCompFile);

	FileReader fr = new FileReader(compFile);
	BufferedReader br =  new BufferedReader(fr);
```

*we need to read the compressed file "compFile" and write that to a decompressed
file which we will call "deCompFile"*

```sh
    int oneBit;
    treeNode Spot = root;

	while((oneBit = br.read()) != -1)
	{
		if(isLeaf(Spot))
		{
			 deComp.print(Spot.chStr); 
			Spot = root;
		}
		if(oneBit == 48) // is the bit a 0
		{
			Spot = Spot.left;
		}
		else if(oneBit == 49)// is the bit a 1
		{
			Spot = Spot.right;
		} 
		else // error to catch, you can check my code for my example
	}
```

*Basically we start from the root of the huffman tree and start the decompression there,
if the node is a leaf node, write the char to the decompressed file. Else we check the bit,
if a 0 bit then go left; OR if a 1 bit then go right. We should get the decompressed file 
the same as our inFile we pass in the beginning of the program.*

[//]: # 

  [john gruber]: <http://daringfireball.net>
  [df1]: <https://github.com/ArbenTemaj/HuffmanEncoding-for-txt-files/>
