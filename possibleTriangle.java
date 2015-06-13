public class possibleTriangle
{
	public static void main (String args[])
	{
		int possibleCount=0,negativeCount=0,runs=1000000;
		double probability=0.0,temp=0.0;
		for(int i=0;i<runs;i++)
		{
			double length = 100.00;
			double split = snap(length);
			double a = split,b = length-split,c = 0.0;		
			int num=((int)(Math.random()*2))+1; //random selection between 1 and 2
			
			//This determines which piece to break after the first break
			switch(num)
			{
			case 1: temp=snap(a);c= a-temp;a=temp;break;
			case 2: temp=snap(b);c= b-temp;b=temp;break;
			}
			
			if(possible(a,b,c)) possibleCount++;
			else negativeCount++;
		}
		probability=((double)(possibleCount)/runs)*100;
		System.out.println(possibleCount+" : "+negativeCount+"\n"+String.format("%.2f",probability)+"%");
	}
	public static double snap(double num)
	{
		return Math.random()*num;
	}
	public static boolean possible(double x, double y, double z)
	{
		double longest;
		if((x>y)&&(x>z)) longest = x;	//find the longest piece.
		else if((y>x)&&(y>z)) longest = y;
		else longest=z;

		if(longest>=((x+y+z)/2.0)) return false;  //if the largest piece is larger than half the total length, a triangle is not possible
		else return true;
	}
	/**
	 * This method is an alternative to the one above.
	 * They both do the same thing but the one below uses the triangle inequality proof from mathematics
	 * @param double x, double y, double z
	 * @return boolean
	 **/
	public static boolean possible2(double x, double y, double z)
	{
		if(((x+y)>z)&&((x+z)>y)&&((y+z)>x)) return true;
		else return false;
	}
}

