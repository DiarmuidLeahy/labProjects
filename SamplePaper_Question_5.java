/**
 * Write a Java program that takes in an array of ints and finds the
   maximum contiguous subsequence sum, given an input length
   n. For example, for the following array, where n = 3 and the
   array is {-5 -1 2 -3 0 -3 3} the best possible sum of at least length
   3 would be 0, where the subsequence is the last three elements
   (0, -3, 3). Provide comments which explain how the algorithm works.
   
 * The hardest part of this one was to handle array out of bounds exceptions
 * It could possibly be done all in the main but I find it easier this way
 */

import java.util.Scanner;
public class SamplePaper_Question_5
{
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a size for the array:");
		int n = sc.nextInt();
		int [] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt(); //filling the array with user input
		}
		System.out.print("enter the size of the sebsequence: "); //this is the amount of indexes in a row to be added up
		int num=sc.nextInt();
		System.out.println(subsequenceSum(array,num));
		sc.close();
	}
	public static int subsequenceSum(int[]arr,int n)
	{
		int sum=0,largest=0;
		//after a lot of playing around, this gets around the out of bounds exception combined with the condition on line 38
		for(int i=0;i<arr.length-(n+1);i++)//it stops at the length of the array minus the subsequence, the inner loop looks after the remaining elements of the array
		{
			sum=0;
			for(int j=i;j<i+n;j++) //this starts at the position of the outer loop and sumtotals from there to the length of the subsequence (n)
			{
				sum+=arr[j];
			}
			if(sum>largest) largest=sum; //keeps track of the largest subsequence
		}
		return largest;
	}
}
