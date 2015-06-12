import java.util.*;

public class Lotto
{
	/**
	 * This program predicts the chances of two consecutive numbers appearing in the national lottery.
	 * Numbers ranging from 0-45 are drawn at random and then sorted. What are the chances that two numbers
	 * drawn differ from one another by only 1? (ie - 4 & 5 or 23 & 24)
	 */
	public static void main (String args[])
	{
		int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45};
		double probability=0.0;
		int count = 0,runs=1000000;
		long start = System.currentTimeMillis();
		for(int i=0;i<runs;i++)	//perform a monte carlo simulation to achieve a more accurate result
		{
			int [] shuffled = new int [6];
			shuffleArray(arr); //call the shuffleaArray method below
			for(int j=0;j<6;j++)
			{
				shuffled[j]=arr[j]; //copy the first 6 numbers of the shuffled array into a new array
			}
			Arrays.sort(shuffled);
			if(isContinuous(shuffled)) count++;
		}
		probability=((double)(runs-count)/runs)*100;
		System.out.println(String.format("%.2f", probability)+"%");
		System.out.println("Two consecutive digits occur roughly " + count + ((count == 1) ? " time" : " times")+" out of " + runs + " draws");
		System.out.println("That took "+(System.currentTimeMillis()-start)+" milliseconds to compute");
	}
	/**
	 * Randomizes the contents of an array
	 * @param array
	 * @return array with shuffled contents
	 */
	private static int[] shuffleArray(int[] array)
	{
		int index, temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
		return array;
	}
	/**
	 * Checks to see if there are two contiguous digits present in the array
	 * @param arr
	 * @return boolean true or false
	 */
	private static boolean isContinuous(int [] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==arr[i+1]-1)	return true;
		}
		return false;
	}
}
