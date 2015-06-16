package lab3;
import java.util.Scanner;
/**
*This program takes a sentence from the user and prints out the occurances of each character along with corresponding
* binary string. Finally, the amount of bits needs to encode the sentence in ASCII is printed. This program has been adapted in
* a later project to create a Huffman compressed version of the sentence
**/
public class BinaryStrings
{
	public static void main (String args[])
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter a sentence: ");
		String s = sc.nextLine();
		int [] ASCIIArray = new int [256];//array to store instances of characters
		char c = '#';
		
		sc.close();
		for(int i=0;i<s.length();i++)
		{
			int decimalValue = (int)s.charAt(i);//casting the character at position i in the string to an integer. This gives it's decimal value in the ASCII table
			ASCIIArray[decimalValue]++;//increment that position in the array by one
			String binaryValue = Integer.toBinaryString(decimalValue);//converting the decimal value into it's binary equivalent
			String binaryString="";
			for(int j=7;j>binaryValue.length();j--)
			{
				binaryString+="0";  //padding
			}
			binaryString += binaryValue;
			
			System.out.println(s.charAt(i) + " : " +binaryString);			
		}
		System.out.println("");
		for(int i=0;i<ASCIIArray.length;i++)
		{
			if(ASCIIArray[i]!=0)
				{
					c=(char)i;//cast the decimal value back to it's corresponding character
					System.out.println("'"+c+"'" +" appeared "+ASCIIArray[i] + " times");
				}
		}
		System.out.println("the sentence has "+ s.length()*7+" bits in ASCII");
		//from here, the next stage is to put the occurrences into a priority queue
		//each letter will be the root of a tree. Then they are connected in order of least significance
		int index=ASCIIArray.length-1;
		while(ASCIIArray[index]!=0)
		{
			c=(char)index;
			System.out.println("'"+c+"'" +" appeared "+ASCIIArray[index] + " times");
			index--;
		}
	}
}
