package lab5;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Countdown
{
	public static void main (String args[])
	{
		char [] vowel={'a','e','i','o','u'},consonant={'q','w','r','t','y','p','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'},letters=new char[9];
		Scanner sc =new Scanner(System.in); 
		int choice;
		
		FileIO reader = new FileIO();
		String input="";
		String[] dictionary = reader.load("C:/Users/Derri_000/Documents/Document.tsv");//file is separated by line
		ArrayList<String> word = new ArrayList<String>();	//declaring an array list to store possible words
		System.out.println("enter 0 for a vowel and 1 for a consonant: ");
		for(int i=0;i<9;i++)		//fill an array with vowels and consonants as chosen by user
		{
			try						//accounting for incorrect inputs
			{
				choice=sc.nextInt();	
				switch(choice)
				{
				case 0: letters[i]=getVowel(vowel);printArray(letters);break;
				case 1: letters[i]=getConsonant(consonant);printArray(letters);break;
				}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("***incorrect input***");
				sc.next();	//clear the buffer
				i--;		//go back to the same point as before
			}
		}
		System.out.println();
			//start the clock
		for(int i=0;i<letters.length;i++)		//convert the char array into a String
		{
			input+=letters[i];
		}
		//System.out.println("enter the nine letters");
		//input=sc.nextLine();//*****STRING OF LETTERS GOES HERE*****
		System.out.println(input.toUpperCase());
		long start=System.currentTimeMillis();
		sc.close();
		for(int i=0;i<dictionary.length;i++)
		{
			String check=dictionary[i].trim();	//taking off carriage return from the end of each line in dictionary
			for(int j=0;j<input.length();j++)
			{
				check=check.replaceFirst((Pattern.quote(Character.toString(input.charAt(j)))),"");	//remove each letter as it's used
			}
			if(check.length()==0) word.add(dictionary[i]);	//add to array list if possible
		}
		long endtime;
		if(word.size()==0)
		{
			System.out.println("\nCould not find a match!!");
			endtime = System.currentTimeMillis();
			System.out.println("Time taken: " + (endtime-start)+" milliseconds");
		}
		else
		{
			Comparator<String> comparator = new Comparator<String>()	//keep track of the longest words found so far
					{
				public int compare(String o1, String o2)
				{
					if(o1.length() > o2.length())	return -1;
					if(o2.length() > o1.length())	return 1;
					return 0;
				}
					};
					Collections.sort(word,  comparator);	//sort by longest
					String tenLargest[];
					if(word.size()>10)
					{
						tenLargest = new String[10];
						for(int i = 0; i < 10; i++)				//take the 10 largest from the array list
						{
							tenLargest[i] = word.get(i);
						}
					}
					else
					{
						tenLargest = new String[word.size()];
						for(int i = 0; i < word.size(); i++)				//take the entire contents from the array list
						{
							tenLargest[i] = word.get(i);
						}
					}	
					System.out.println(tenLargest[0].length()-1+" letter word possible! Here's the top"+(word.size()<10 ? " words" : " ten words"));	//length of the longest word
					for(int i = 0; i < tenLargest.length; i++)
					{
						System.out.print((i+1)+" : "+ tenLargest[i]);	//printing out then 10 largest
					}
					endtime = System.currentTimeMillis();
					System.out.println("Time taken: " + (endtime-start)+" milliseconds");
		}
	}
	public static char getVowel(char[] v)		//returns a random vowel as chosen by the switch statement
	{
		Random r = new Random();
		return v[r.nextInt(5)];
	}
	public static char getConsonant(char[] c)	//returns a random consonant as chosen by the switch statement
	{
		Random r = new Random();
		return c[r.nextInt(20)];
	}
	public static void printArray(char [] a)	//print the current state of the players selection
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]);
		}
	}
}

