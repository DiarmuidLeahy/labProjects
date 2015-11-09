package lab9;

public class Queue
{
	private LinkedList thelist;

	public Queue()
	{
		thelist = new LinkedList();
	}

	public void insert(String s)
	{
		thelist.insertLast(s);
	}

	public String remove()
	{
		return thelist.deleteHead();
	}

	public boolean isEmpty()
	{
		return thelist.isEmpty();
	}

	public int getSize()
	{
		return thelist.getSize();
	}

	public void printout()
	{
		thelist.display();
		System.out.println("");
	}
}
