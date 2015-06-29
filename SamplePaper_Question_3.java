/**
 * Write a Java method that takes in a reference to the head of a
   double-ended doubly-linked list and reverses it. Provide
   comments which explain how the algorithm works
 */

import java.util.Scanner;
public class SamplePaper_Question_3
{
	/**
	 * The main method is just to test if the reversing method works as expected
	 */
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		List myList = new List();
		List backwards = new List();
		System.out.println("Enter data to go into a linked list");
		for (int i=0;i<5;i++)
		{
			System.out.println("link "+ i + ": ");
			myList.insertHead(sc.next());
			myList.printout();
		}
		sc.close();
		backwards = reverseList(myList);
		backwards.printout();
	}
	
	/**
	 * This method takes in a linked list and returns the list in reverse order
	 * @param List a
	 * @return List reversed
	 */
	public static List reverseList(List a)
	{
		List reversed = new List(); //creating a new List to store the reversed list
		String temp; //'temp' is to store the data returned from the delete method
		while(!(a.isEmpty())) //keep looping until the list taken into the method contains links
		{
			temp = a.removeHead(); //store the content of the deleted head of the old linked list
			reversed.insertHead(temp);	//insert that content to the head of a new linked list		
		}
		return reversed; //return the reversed list
	}

}
