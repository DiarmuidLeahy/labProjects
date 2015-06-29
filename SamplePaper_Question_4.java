/**
 * Write a Java method that takes in an array of strings and sorts
   them by the number of unique characters in each string. Provide
   comments which explain how the algorithm works.
   
   How on earth anyone is expected to be able to do this in 23 minutes on paper is beyond me.
 */
package sampleExam;
import java.util.Scanner;
public class SamplePaper_Question_4
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a size for the array");
		int size=sc.nextInt();
		String[] names = new String[size];
		for(int i=0;i<size;i++)
		{
			names[i]=sc.next(); //fill the array with strings from the user
		}
		sc.close();
		insertionSort(names);
		for(int i=0;i<names.length;i++)
		{
			System.out.println(names[i]);//print out the sorted array
		}
	}
	public static void insertionSort( String [ ] num)
	{
		int j;    
		String key;
		int i;  
		for (j = 1; j < num.length; j++)
		{
			key = num[ j ];
			for(i = j - 1; (i >= 0) && (countUniqueCharacters(num[ i ]) < countUniqueCharacters(key)); i--) //converts strings to ints by calling the method to count unique chars
			{
				num[ i+1 ] = num[ i ];//shifts everything right
			}
			num[ i+1 ] = key; //makes the switch
		}
	}
	public static int countUniqueCharacters(String s)
	{
		String lowerCase = s.toLowerCase();//just in case user enters an upper case letter
		char characters[] = lowerCase.toCharArray();//put all characters into an array
		int countOfUniqueChars = s.length();//assume that each character is unique
		for (int i = 0; i < characters.length; i++)
		{
			if (i != lowerCase.indexOf(characters[i]))//if the current index is not the only index of the character in question, it is not unique
			{
				countOfUniqueChars--;  //so decrement by 1
			}
		}
		return countOfUniqueChars;
	}
}
