public class AffineCypher
{
	private static final int m = 26;	//size of the alphabet being encrypted
	private static char [] Alphabet = new char [m];
	
	public static void main(String args[])
	{
		int a = 5, b=8, y=m-a;	//A and B are arbitrary values and Y is the remainder left in the alphabet after subtracting A.
		
		char [] EncryptedAlphabet = new char[m];
		char [] DecryptedAlphabet = new char[m];
		
		for(int i=0;i<Alphabet.length;i++)	//Fill the alphabet array
		{
			Alphabet[i] = (char)('A'+i);
		}		
		
		EncryptedAlphabet = EncryptAffine(a,b);
		System.out.println("Encrypting Alphabet:...");
		for(int i=0;i<m;i++)
		{	
			System.out.println(Alphabet[i] + " : " + EncryptedAlphabet[i]);
		}		
		
		DecryptedAlphabet = DecryptAffine(EncryptedAlphabet, y, b);
		System.out.println("Decrypting Alphabet:...");
		for(int i=0;i<m;i++)
		{
			System.out.println(EncryptedAlphabet[i] + " : " + DecryptedAlphabet[i]);
		}
	}
	/**
	 * Encrypting the alphabet using the Affine cipher. The formula for encryption is:  y = ((x * a) + b) % m 
	 * Where a and b are arbitrary values and m is the size of the alphabet.
	 * @param a
	 * @param b
	 * @return char [] encrypted array
	 */
	public static char [] EncryptAffine(int a, int b)
	{
		char [] encrypted = new char [m];
		for(int i=0;i<m;i++)
		{
			encrypted[i] = (char)('A'+((Alphabet[i]*a)+b)%m);
		}
		return encrypted;
	}
	/**
	 * The reverse of the Encryption method. The formula for decryption is given as: x = a(inverse)(y-b) % m 
	 * @param arr
	 * @param aInv
	 * @param b
	 * @return char [] decrypted array
	 */
	public static char [] DecryptAffine(char [] arr, int aInv, int b)
	{
		char [] decrypted = new char[m];
		for(int i=0;i<m;i++)
		{
			decrypted[i]= 	(char)('A'+(aInv*(arr[i]-b)%m));
		}
		return decrypted;
	}
}
