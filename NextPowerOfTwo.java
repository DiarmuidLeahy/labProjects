import java.util.Scanner;
public class NextPowerOfTwo
{
  /**
  *A user enters a number and the program outputs the next power of two
  **/
  
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a number:");
		int num = sc.nextInt();
		long start = System.nanoTime();
		nextPower(num);
		long elapsed = System.nanoTime()-start;
		System.out.println("time taken : "+elapsed+"ns");
		sc.close();
	}
	/**
	 * Finds the next power of two to an inputed integer using bitwise operators and recursion
	 * @param n
	 */
	public static void nextPower(int n)
	{
		if((n & (n-1)) == 0) System.out.println("The next Power of 2 is " + n);
		else nextPower(addition(n,1));
	}
	/**
	 * Performs an addition on two integers without the use of mathematical operators or iteration
	 * @param a
	 * @param b
	 * @return a+b
	 */
	public static int addition(int a, int b)
	{
		int sum,carry; 
		if(b==0) return a;

		else
		{
			sum = a^b;
			carry = (a&b)<<1;
			return addition(sum,carry);
		}
	}
}
