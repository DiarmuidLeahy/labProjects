package lab8;

import java.io.*;
import java.util.*;

public class Hashing
{
	static int size = 239999; //The largest prime number below 240,000 which is required for a load factor of 0.9

	static String[] hashTable = new String[size];
	static String[] array = new String[216555];

	public static void main (String[] args) throws IOException
	{
		File testFile = new File("C:/Users/Derri_000/Documents/Document.tsv");

		//fill the hash table so that every slot contains a space
		getContents(testFile);
		//loads up the file
		System.out.println("Which type of open addressing would you like to use?");
		System.out.println("1) Linear Probing");
		System.out.println("2) Quadratic Probing");
		System.out.println("3) Double Hashing");
		Scanner in = new Scanner(System.in);
		int strategy = in.nextInt();
		//the user enters a number for the hashing strategy they want to use
		switch(strategy)
		{
		case 1: 
			fillLinearProbing();
			break;
		case 2: 
			fillQuadraticProbing();
			break;
		case 3: 
			fillDoubleHash();
			break;
		}     
		in.nextLine();
		System.out.print("\nEnter a word to find: ");
		String word = in.nextLine();
		while(!word.equals("quit")){
			find(word, strategy);
			System.out.print("\nEnter a word to find: ");
			word = in.nextLine();
			//in.close();
			//the user is asked to enter words to search for until they enter the word 'quit'
		}
		in.close();
	}

	public static void find(String word, int strategy)
	{
		//this method takes in a word to look for and the strategy by which it has been placed in the hash table
		int probes = 1;
		int index = getHashKey(word);
		//calculate the hash key for the word
		System.out.println();												
		while(hashTable[index]!=null&&!hashTable[index].equals(word))
		{
			System.out.println("Checking slot "+index+"...collision with "+hashTable[index]);			
			//as long as you do not stumble across either the word or a blank keep searching
			if(strategy==1)
			{
				//depending on the strategy go up in linear jumps, quadratic jumps or the double hash jump
				index++;
				probes++;
				index=index%size;
				//always mod the index size so it doesn't go out of bounds
			}
			else if(strategy==2)
			{
				index+=(probes*probes);
				probes++;
				index=index%size;
			}
			else if(strategy==3)
			{
				index+=getDoubleHashKey(word);
				probes++;
				index=index%size;
			}
		}
		if(hashTable[index]==null)
		{
			System.out.println("NOT IN HASHTABLE");
			//if you've found a space then the word cannot be in the hash table
		}
		else
		{
			System.out.println("The word "+word+" was found in slot "+index+" of the hashtable");
		}     
		System.out.println("Number of hash table probes: "+probes);
		//print out the total number of attempts to find the correct slot
	}


	public static int getHashKey(String word)
	{
		int total = 0;
		int pow=128;
		for(int i=0; i<word.length();i++)
		{
			total=total+modMult((int)word.charAt(i),modPow(pow,i+9,size),size);//trial and error shows that +9 gives the best result
			pow++;
			//raise each letter to successive powers of 128
			//this will create a unique value for every possible string because there are only 127 ASCII characters
		}
		return total%size;
	}

	public static int getDoubleHashKey(String word)
	{
		int total = 0;
		for(int i=0; i<word.length();i++)
		{
			total+=(int)(word.charAt(i));
			//add up all of the letters
		}
		
		int maxjump = 149;
		return (maxjump - (total % maxjump));
	}

	public static void fillLinearProbing()
	{
		int totalcollisions=0;
		//this variable stores the total number of collisions that have occurred for every word
		for(int i=0; i<array.length;i++)
		{
			//go through all words
			int collisions=0;
			int index = getHashKey(array[i]);
			//generate a hash key
			while(hashTable[index]!=null)
			{
				//if that slot is already filled move onto the next slot and increment the collisions
				collisions++;
				index++;
				index=index%size;
				//make sure you don't go off the edge of the hash table
			}
			hashTable[index]=array[i];
			if(i%100==0)
			{
				System.out.println(array[i] + " was placed in slot "+index+" of the hash table after "+collisions+" collisions");
			}
			totalcollisions+=collisions;
			//print out the information for the last 1,000 words only, otherwise it takes quite long and gets annoying
		}
		System.out.println("The total number of collisions was "+ totalcollisions);
	}

	public static void fillQuadraticProbing()
	{
		int totalcollisions=0;
		for(int i=0; i<array.length;i++)
		{
			int collisions=0;
			int index = getHashKey(array[i]);
			int queries=1;
			while(hashTable[index]!=null)
			{
				collisions++;
				index=index+(queries*queries);
				index=index%size;
				queries++;
			}
			hashTable[index]=array[i];
			if(i%100==0)
			{
				System.out.println(array[i] + " was placed in slot "+index+" of the hash table after "+collisions+" collisions");
			} 
			totalcollisions+=collisions;
		}
		System.out.println("The total number of collisions was "+ totalcollisions);
	}

	public static void fillDoubleHash()
	{
		int totalcollisions=0;
		for(int i=0; i<array.length;i++)
		{
			int collisions=0;
			int index = getHashKey(array[i]);
			int doubleHash = getDoubleHashKey(array[i]);
			while(hashTable[index]!=null)
			{
				collisions++;
				index=index+doubleHash++;  //made a change here so that the jumps increase by on each collision. added ++
				index%=size;
			}
			hashTable[index]=array[i];
			if(i%100==0)
			{					
				System.out.println(array[i] + " was placed in slot "+index+" of the hash table after "+collisions+" collisions");
			}
			totalcollisions+=collisions;
		}
		System.out.println("The total number of collisions was "+ totalcollisions);
	}

	public static int modPow(int number, int power, int modulus)
	{
		//raises a number to a power with the given modulus
		//when raising a number to a power, the number quickly becomes too large to handle
		//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
		//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
		//the trick is to use recursion - keep breaking the problem down into smaller pieces and use the modMult method to join them back together         
		if(power==0)
			return 1;
		else if (power%2==0)
		{
			int halfpower=modPow(number, power/2, modulus);
			return modMult(halfpower,halfpower,modulus);
		}
		else
		{
			int halfpower=modPow(number, power/2, modulus);
			int firstbit = modMult(halfpower,halfpower,modulus);
			return modMult(firstbit,number,modulus);
		}
	}

	public static int modMult(int x, int y, int mod)
	{
		if(y==0) return 0;
		else if (y%2==0)
		{
			int half=modMult(x, y/2, mod);
			return (half+half)%mod;
		}
		else
		{
			int half=modMult(x, y/2, mod);
			return (half+half+x)%mod;
		}
		//return ((x%mod)*(y%mod))%mod;
	}


	/**
	 * Fetch the entire contents of a text file, and return it in a String.
	 * This style of implementation does not throw Exceptions to the caller.
	 *
	 * @param aFile is a file which already exists and can be read.
	 */
	public static String getContents(File aFile)
	{
		//...checks on aFile are elided
		StringBuffer contents = new StringBuffer();

		//declared here only to make visible to finally clause
		BufferedReader input = null;
		try
		{
			//use buffering, reading one line at a time
			//FileReader always assumes default encoding is OK!
			input = new BufferedReader( new FileReader(aFile) );
			String line = null; //not declared within while loop
			/*
			 * readLine is a bit quirky :
			 * it returns the content of a line MINUS the newline.
			 * it returns null only for the END of the stream.
			 * it returns an empty String if two newlines appear in a row.
			 */
			int i = 0;
			while (( line = input.readLine()) != null)
			{
				array[i]=line;
				i++;
				contents.append(System.getProperty("line.separator"));
			}
		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (input!= null)
				{
					//flush and close both "input" and its underlying FileReader
					input.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return contents.toString();
	}
	public static void setContents(File aFile) throws FileNotFoundException, IOException
	{
		Writer output = null;
		try
		{
			//use buffering
			//FileWriter always assumes default encoding is OK!
			output = new BufferedWriter( new FileWriter(aFile) );
			int i=0;
			while(array[i]!=null)
			{
				output.write( array[i] );
				output.write(System.getProperty("line.separator"));
				i++;
			}
		}
		finally
		{
			//flush and close both "output" and its underlying FileWriter
			if (output != null) output.close();
		}
	}
}
