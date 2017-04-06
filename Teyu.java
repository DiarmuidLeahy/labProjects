import java.util.*;
public class Teyu {

	public static int  id = 0, x_coordinate = 0, y_coordinate = 0, num_tickets;
	public static double price = 0.0;
	public static int [][] events = new int [20][20];
	public static int [][] tickets = new int [20][20];
	public static double [][] prices = new double [20][20];
	

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		String string_rounded = "";
		Double rounded = 0.0;

		for(int i = 0; i<10; i++) {	//Fill the matrices

			x_coordinate = rand.nextInt(20);
			y_coordinate = rand.nextInt(20);

			price =  10 + (40) * rand.nextDouble();
			string_rounded = String.format("%.2f", price);
			rounded = Double.parseDouble(string_rounded);

			num_tickets = rand.nextInt(10);
			
			events[x_coordinate][y_coordinate] = id++;
			tickets[x_coordinate][y_coordinate] = num_tickets;
			prices[x_coordinate][y_coordinate] = rounded;
		}

		int clickPoint_x = rand.nextInt(20);
		int clickPoint_y = rand.nextInt(20);

	}
	public static void printMatrix(int [][] a) {
		for(int row=0; row<a.length; row++) {
			for(int col=0; col<a[0].length; col++) {
				System.out.print(a[row][col] +"  ");
			}
			System.out.println("\n");
		}
	}

	public static void printMatrix(double [][] a) {
		for(int row=0; row<a.length; row++) {
			for(int col=0; col<a[0].length; col++) {
				System.out.print(a[row][col] +"  ");
			}
			System.out.println("\n");
		}
	}

	public static ArrayList<interger> search(int x, int y) {
		
		for (int d = 1; d<maxDistance; d++)
		{
		    for (int i = 0; i < d + 1; i++)
		    {
		        int x1 = xs - d + i;
		        int y1 = ys - i;

		        // Check point (x1, y1)

		        int x2 = xs + d - i;
		        int y2 = ys + i;

		        // Check point (x2, y2)
		    }


		    for (int i = 1; i < d; i++)
		    {
		        int x1 = xs - i;
		        int y1 = ys + d - i;

		        // Check point (x1, y1)

		        int x2 = xs + d - i;
		        int y2 = ys - i;

		        // Check point (x2, y2)
		    }
		}
	} 
}