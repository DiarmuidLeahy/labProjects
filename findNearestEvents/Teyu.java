package package1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Teyu2 {

	public static Coordinate [][] events = new Coordinate [21][21];	//Defined globally so that all methods have access
	
	public static void main(String args[]) {
		
		int x,y;
		int id = 0;
		double price =0.0;
		Random rand = new Random();
		ArrayList<String> used = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<events.length;i++) {	//Fill the 2D array with Coordinate objects and assign their x,y values
			for(int j=0;j<events[0].length;j++) {
				events[i][j] = new Coordinate(i,j);
			}
		}
		
		while(used.size() < 10) {	//The 'used' list contains coordinates that have already been taken. This prevent 2 events at the same position on the grid
			x = rand.nextInt(21);
			y = rand.nextInt(21);
			String coord = x+","+y;
			if(!used.contains(coord)) {
				used.add(coord);
				//Randomly seeded data for each event
				price =  10 + (40) * rand.nextDouble();
				price = Math.round(price*100.0)/100.0;
				events[x][y].price = price;
				events[x][y].tickets = rand.nextInt(11);
				events[x][y].event = id++;	//auto-increment the id so that it is serial
				
			}
		}
		//Allow user to input their location
		System.out.print("Enter your X coordinate: ");
		int click_x = sc.nextInt();
		
		System.out.print("Enter your Y coordinate: ");
		int click_y = sc.nextInt();
		sc.close();
		//Manipulation the user input to convert a 0 to 20 grid into a -10 to +10 grid with NE, SE, SW, NW quadrants
		ArrayList<Coordinate> nearest = getNearest((click_y*-1)+10, click_x+10);

		printArray((click_y*-1)+10, click_x+10);
		
		System.out.println("*The # symbol represents your position*\n");
		
		System.out.println("Closest Events to ("+click_x+","+click_y+"):");
		System.out.println("Event "+nearest.get(0).event +" - $"+nearest.get(0).price + ", Distance " + nearest.get(0).distance);
		System.out.println("Event "+nearest.get(1).event +" - $"+nearest.get(1).price + ", Distance " + nearest.get(1).distance);
		System.out.println("Event "+nearest.get(2).event +" - $"+nearest.get(2).price + ", Distance " + nearest.get(2).distance);
		
	}
	public static void printArray() {
		for(int i=0;i<events.length;i++) {
			for(int j=0;j<events[0].length;j++) {
				System.out.print((events[i][j].event == 0) ? "_\t" : events[i][j].event + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void printArray(int x, int y) {
		for(int i=0;i<events.length;i++) {
			for(int j=0;j<events[0].length;j++) {
				System.out.print((i == x && y == j) ? "#\t" : (events[i][j].event == 0) ? "_\t" : events[i][j].event + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static ArrayList<Coordinate> getNearest(int x, int y) {
		//This list will store all Coordinates and their distances from the user-inputed position
		ArrayList<Coordinate> distances = new ArrayList<Coordinate>();

		for(int i=0;i<events.length;i++) {
			for(int j=0;j<events[0].length;j++) {
				if(events[i][j].event != 0) {
					events[i][j].distance = (Math.abs(x-events[i][j].x) + Math.abs(y-events[i][j].y));		//Calculate Manhattan distances
					distances.add(events[i][j]);
				}
			}
		}
		
		Collections.sort(distances, new Comparator<Coordinate>() {	//Sort the list based on their distance attribute

	        public int compare(Coordinate o1, Coordinate o2) {
	            return compareDistance(o1.distance,o2.distance);
	        }
	    });
		
		return distances;
	}
	
	public static int compareDistance(int a, int b) {
	    return a < b ? -1
	         : a > b ? 1
	         : 0;
	}
}



