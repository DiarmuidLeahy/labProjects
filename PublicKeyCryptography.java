package lab7;
import java.util.Scanner;
/**
 * Alice’s public key is (24852977, 2744, 8414508). You eavesdrop on the line and observe Bob send her the cipher (15268076, 743675).
 * Extract the message by any means.
 * Warning: for the programming part, make sure to use longs rather than ints (you may need to put an ‘l’ at the end of the number).
 * Also, make sure to keep modulo-ing every time the number in the calculation gets a little too big – never do large power multiplications
 * straight off because Java cannot process large numbers like this. 
 * @author Derri_000
 *
 */
public class PublicKeyCryptography
{
	public static void main (String args[])
	{
		Scanner myscanner = new Scanner(System.in);
		System.out.println("input mod");
		long mod = myscanner.nextLong();
		System.out.println("input generator");
		long gen = myscanner.nextLong();
		System.out.println("input g^x mod p");
		long third = myscanner.nextLong();
		long current = gen;
		long pow = 1;
		while(current!=third)		//brute forcing the private key
		{
			pow++;
			current = multiply(current,gen,mod);
			if(current >= mod)
			{
				current=current%mod;
			}
		}
		System.out.println("x = "+pow);
		System.out.println("Enter returning c1");
		long c1 = myscanner.nextLong();
		System.out.println("Enter returning c2");
		long c2 = myscanner.nextLong();
		long key = pow;
		long divisor = power(c1, mod-1-key, mod);
		long message = multiply(divisor,c2,mod);
		System.out.println("The message is "+"\""+message+"\"");
		myscanner.close();
	}
	/**
	 * Finding the power while moduloeing to keep the result within the limits of an Integer
	 * @param long number, long power, long modulus
	 * @return long result
	 * */
	public static long power(long number, long power, long modulus)
	{
		if(power==0) return 1;
		else if (power%2==0)
		{
			long halfpower=power(number, power/2, modulus);
			return multiply(halfpower,halfpower,modulus);
		}
		else
		{
			long halfpower=power(number, power/2, modulus);
			long xbit = multiply(halfpower,halfpower,modulus);
			return multiply(xbit,number,modulus);
		}
	}
	public static long multiply(long x, long y, long mod)
	{
		if(y==0) return 0;
		else if (y%2==0)
		{
			long half=multiply(x, y/2, mod);
			return (half+half)%mod;
		}
		else
		{
			long half=multiply(x, y/2, mod);
			return (half+half+x)%mod;
		}
	}
}
