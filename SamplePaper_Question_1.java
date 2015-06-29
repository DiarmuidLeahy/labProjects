/**
 * Write a Java program that outputs the quantity of prime numbers
   under an input number n which is inputed by the user. For
   example, if the user inputs 10, then the program outputs 4.
   Provide comments which explain how the algorithm works. 
 * 
 * This could be done with a sieve but I did it the old fashioned way 
 */
package sampleExam;
import java.util.Scanner;
public class SamplePaper_ Question_1
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int count = 0;
		for(int i=2;i<n;i++)//don't need to check 1 so start at 2
		{
			if(isPrime(i))//the method is being called in a loop which, in turn, uses a loop so the algorithm is O(n^2) 
			{
				count++;//each time a true is returned, we've found a prime so increment the count by 1
				System.out.println(i);//the question doesn't ask for this, just a count of how many occur between 2 and a given 'n'
			}
		}
		System.out.println("There are "+count+" primes between 1 and "+n);

	}
	public static boolean isPrime(int num)
	{
		if (num==2) return true;//2 is prime
		if (num % 2 == 0) return false;//discount all evens
		for (int i = 3; i * i <= num; i += 2)//starts at 3 and goes up in steps of 2 until the square root of num
		{
			if (num % i == 0) return false; //order n^2 checks
		}
		return true; //if the if statement wasn't triggered, the number is prime
	}
}
