/**
 * This is a bank account class that has the methods for creating an account along with
 * the getter and setter methods for updating the account 
 */
package atm;

public class BankAccount
{

    private double balance;

	/**
	 * This is the default constructor. It initializes the account balance to 0.0
	 */
	public BankAccount()
	{
		balance = 0;
	}
	/**
	 * This a constructor that takes in a value and sets it as the account balance
	 * @param initialBalance
	 */
	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}
	/**
	 * This method takes in a value and adds it to the existing balance
	 * @param amount
	 */
	public void deposit(double amount)
	{      
		double newBalance = balance + amount;
	    balance = newBalance;   
	} 
	/**
	 * This methods takes in a value and takes it away from the existing balance 
	 * @param amount
	 */
	public void withdraw(double amount)    
	{ 
		double newBalance = balance - amount;
        balance = newBalance;
    } 
	/**
	 * This method returns the current balance
	 * @return balance
	 */
	public double getBalance() 
	{ 
		return balance;
	}
}
