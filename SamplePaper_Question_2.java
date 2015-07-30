/**
 * Write a Java program that prints the integers from 1 to 100. But
  for multiples of three print "Fizz" instead of the number and for
  the multiples of five print "Buzz". For numbers which are
  multiples of both three and five print "FizzBuzz".
  Provide comments which explain how the algorithm works.
  
 * I added in the woof at multiples of 7 because it came up in a HackerRank competition but the idea is still the same.
 */
package sampleExam;
import java.util.Scanner;
public class SamplePaper_Question_2
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt(); //I did it so it runs for a user inputed length rather than 100 as the question asks
		System.out.print("1"); //This line is purely because of the format they were looking for in the competition
		for(int i=2;i<=n;i++)
		{
			//you have to do the largest numbers first otherwise the correct if statement won't be reached
			if(i%105==0) System.out.print(", fizzbuzzwoof"); //multiples of 3, 5 and 7
			else if(i%35==0) System.out.print(", buzzwoof"); //multiples of 5 and 7
			else if(i%21==0) System.out.print(", fizzwoof"); //multiples of 3 and 7
			else if(i%15==0) System.out.print(", fizzbuzz"); //multiples of 3 and 5
			else if(i%3==0) System.out.print(", fizz");
			else if(i%5==0) System.out.print(", buzz");
			else if(i%7==0) System.out.print(", woof");
			else System.out.print(", "+i); //for every other number, just print the number 
		}
		sc.close();
	}
}
