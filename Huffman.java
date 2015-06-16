package lab4;

import java.util.*;
import lab2.Node;
public class Huffman
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your sentence: ");
		String sentence = in.nextLine();
		String binaryString="";
		for(int i=0; i < sentence.length(); i++)
		{
			int decimalValue = (int)sentence.charAt(i);
			String binaryValue = Integer.toBinaryString(decimalValue);   
			for(int j=7;j>binaryValue.length();j--)
			{
				binaryString+="0";  //padding
			}
			binaryString += binaryValue+" "; 
		}
		System.out.println(binaryString); 
		int[] array = new int[256];  
		for(int i=0; i < sentence.length(); i++)
		{  
			array[(int)sentence.charAt(i)]++;
		}
		PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  
		for(int i=0; i<array.length; i++)
		{ 
			if(array[i]>0)
			{
				System.out.println("'"+(char)i+"' appeared "+array[i]+((array[i] == 1) ? " time" : " times"));
				Tree myTree = new Tree(); 
				myTree.frequency = array[i];
				myTree.root=new Node(); 
				myTree.root.letter = (char)i;
				//System.out.println(myTree.root.letter);
				PQ.add(myTree);
			}
		}
		while(PQ.size()>1)
		{             
			Tree firstTree = PQ.poll();		//takes the tree out of the queue
			Tree secondTree = PQ.poll();
			Tree comboTree = new Tree();
			comboTree.frequency=firstTree.frequency+secondTree.frequency;
			comboTree.root=new Node();
			comboTree.root.leftChild=firstTree.root;
			comboTree.root.rightChild=secondTree.root;
			PQ.add(comboTree);
			System.out.println(comboTree.frequency);
		}
		
		Tree HuffmanTree = PQ.poll();
		//System.out.println(HuffmanTree.frequency);
		int totalLength=0;
		String theCode="";
		for(int i=0; i<sentence.length(); i++)
		{
			theCode=HuffmanTree.getCode(HuffmanTree.root, sentence.charAt(i), theCode);
			System.out.print(theCode+" ");
			totalLength+=theCode.length();
			theCode="";
		}
		System.out.println("\nCompressed size is "+totalLength+" bits / "+sentence.length()*7+" bits = "+(int)((totalLength*100)/(sentence.length()*7))+" %\n");
		in.close();
	}      
}
