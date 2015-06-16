package lab4;

import lab2.Node;

public class Tree implements Comparable<Tree>
{
	public Node root;            
	public int frequency=0;
	
	public Tree()               
	{   
		root = null;
	}
	public int compareTo(Tree object)
	{
		if(frequency-object.frequency>0) return 1;
		else if(frequency-object.frequency<0) return -1;
		else return 0; 
	}
	String pathcode= "error";
	public String getCode(Node localRoot, char c, String path)
	{	
		if(localRoot!=null)
		{
			if(localRoot.letter==c) pathcode=path;
			else
			{
				getCode(localRoot.leftChild, c, path+"0");
				getCode(localRoot.rightChild, c, path+"1");
			}
		}
		return pathcode;		
	}
}
