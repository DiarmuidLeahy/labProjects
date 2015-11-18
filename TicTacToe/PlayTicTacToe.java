/**

 * The implementation of the TicTacToe class
 * 
 * @author Diarmuid Leahy 
 * @version 12/11/014
 */
package ticTacToe;
import java.util.Scanner;
public class PlayTicTacToe extends TicTacToe
{
    public static void main (String args[])
    {
        // Create game and initialize it.
        // First player will be 'x'
        TicTacToe game = new TicTacToe();
        //Take input from players using a scanner
        Scanner sc = new Scanner (System.in);
        //Initialising the variables used for user input. r=rows, c=columns
        int r=0,c=0;
        System.out.println("WELCOME TO THE GAME");
        game.printBoard();
        //loop until the board is full, at which point, the game will be declared as a draw unless a winner is found
        while(game.isBoardFull()==false)
        {           
            System.out.println("Where would you like to place a marker?");
            System.out.print("row : ");
            r=sc.nextInt();
            while((r!=1)&&(r!=2)&&(r!=3))
            {
                System.out.println("please enter a number between 1 and 3");
                r=sc.nextInt();
            }
            System.out.print("column : ");
            c=sc.nextInt();
            while((c!=1)&&(c!=2)&&(c!=3))
            {
                System.out.println("please enter a number between 1 and 3");
                c=sc.nextInt();
            }            
            //fill the board at requested coordinates with the current marker.
            //To make it more intuitive, I have labelled the board 1 to 3 instead of 0 to 2 as is array convention.
            //This must be corrected by taking 1 from the input before feeding it to the placeMarker method to
            //prevent an out of bounds exception
            game.placeMark((r-1),(c-1));
            //I need to put something here to prevent invalid inputs
            
            //time to print the board to show the current state of play
            game.printBoard();

            // Did we have a winner?
            if (game.checkForWin())
            {
                System.out.println("Congratulations!! We have a winner");
                //System command to end the program
                System.exit(0);
            }

            // If there is no winner, switch players between x's and o's
            game.changePlayer();
        }
        System.out.println("Appears we have a draw!");
        sc.close();
        System.exit(0);
    }
}
