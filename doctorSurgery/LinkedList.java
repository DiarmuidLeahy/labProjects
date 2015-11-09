package lab9;

public class LinkedList
{
	private Link first,last;
	private int numLinks;

	public LinkedList()
	{
		first=null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insertFirst(String name)
	{
		Link newLink = new Link(name);
		if(isEmpty()) last=newLink;
		else last.next=newLink;
		newLink.next = first;
		first = newLink;
		numLinks++;
	}
	public void insertLast(String name)
	{
		Link newLink=new Link(name);
		if(isEmpty()) first=newLink;
		else last.next=newLink;
		newLink.next = null;
		last=newLink;
		numLinks++;
	}
	public Link delete(String key)
	{
		Link current=first,previous=first;
		while(current.data!=key)
		{
			if(current.next==null) return null;
			else
			{
				previous=current;
				current=current.next;
			}
		}
		if(current==first) first=first.next;
		else previous.next=first.next;
		numLinks--;
		return current;
	}
	public int getSize()
	{
		return numLinks;
	}
	public String deleteHead()
	{
		Link temp=first;
		first=first.next;
		numLinks--;
		return temp.data;
	}
	public void display()
	{
		Link current = first;
		while(current!=null)
		{
			System.out.print(current.data+",");
			current=current.next;
		}
	}
}
