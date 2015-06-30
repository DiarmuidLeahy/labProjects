
package atm;

import javax.swing.JOptionPane;
/**
 * This class uses a GUI to take inputs and tasks depending on the input from the user
 * @author Diarmuid Leahy
 * @version v1.0
 */
public class JOptionPaneDemo
{
	public int answer1,answer2,amount;
	public BankAccount ba;
	/**
	 * Default constructor for a JOptionPaneDemo object
	 */
	public JOptionPaneDemo()
	{
		answer1=0;
		answer2=0;
		amount=0;
		ba = new BankAccount();
	}
	public static void main(String[] args)
	{
		JOptionPaneDemo jopd = new JOptionPaneDemo();
		int turn = 0;
		while(turn<3)
		{
			turn++;
			jopd.getInput();
		}		
		System.exit(0);
	}
	/**
	 * This methods takes input from the user using a GUI
	 * @ return void
	 */
	public void getInput()
	{	   
		answer1 = JOptionPane.showConfirmDialog(null,
				"Make a Deposit?", null, JOptionPane.YES_NO_OPTION);

		if (answer1 == JOptionPane.YES_OPTION)
		{
			String depString =
					JOptionPane.showInputDialog(
							"Enter amount:");
			amount = Integer.parseInt(depString);
			ba.deposit(amount);
		}

		else if (answer1 == JOptionPane.NO_OPTION)
		{
			answer2 = JOptionPane.showConfirmDialog(null,
					"Make a Withdrawl?", null, JOptionPane.YES_NO_OPTION);

			if (answer2 == JOptionPane.YES_OPTION)
			{
				String withString =
						JOptionPane.showInputDialog(
								"Enter amount:");
				amount = Integer.parseInt(withString);
				ba.withdraw(amount); 	  
			}
		}	
		JOptionPane.showMessageDialog(
				null, "Your Balance is: = " + (ba.getBalance()));
	}
}

