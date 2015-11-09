package lab9;

import java.util.Scanner;

public class QueueSystem
{

	public static void main (String[] args)
	{
		Queue myqueue = new Queue();
		Scanner sc = new Scanner(System.in);
		String command = "";
		while(!command.equals("quit"))
		{
			System.out.println("Do you want to insert, remove, getsize or quit?");
			command = sc.next();
			if(command.equals("insert"))
			{
				System.out.println("Enter name to insert");
				String name = sc.next();
				myqueue.insert(name);
				myqueue.printout();
				System.out.println(name +" has been inserted into the queue");
			}
			else if(command.equals("remove")&& myqueue.isEmpty())
			{
				try
				{
					myqueue.remove();
				}
				catch(NullPointerException e)
				{
					System.out.println("The queue is already empty!");
					continue;
				}
			}
			else if(command.equals("remove"))
			{  
				System.out.println(myqueue.remove()+ " has been removed from the queue");
				myqueue.printout();
				System.out.println("");
			}
			
			else if(command.equals("getsize"))
			{
				System.out.println("The size of the queue is "+myqueue.getSize());
			}
			else
			{
				System.out.println("***COMMAND NOT RECOGNISED***");
			}
		}
		sc.close();
		System.out.println("GOODBYE!");
	}
}

