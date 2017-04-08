package package1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Teyu {

	public static Coordinate [][] events = new Coordinate [20][20];
	
	public static void main(String args[]) {
		int x,y;
		int id = 0;
		double price =0.0;
		ArrayList<String> used = new ArrayList<String>();
		for(int i=0;i<events.length;i++) {
			for(int j=0;j<events[0].length;j++) {
				events[i][j] = new Coordinate(i,j);
			}
		}
		Random rand = new Random();
		while(used.size() < 10) {
			x = rand.nextInt(20);
			y = rand.nextInt(20);
			String coord = x+","+y;
			if(!used.contains(coord)) {
				used.add(coord);
				
				price =  10 + (40) * rand.nextDouble();
				price = Math.round(price*100.0)/100.0;
				
				events[x][y].price = price;
				events[x][y].tickets = rand.nextInt(10);
				events[x][y].event = id++;
				
			}
		}
		
		int click_x = rand.nextInt(20);
		int click_y = rand.nextInt(20);
		ArrayList<Coordinate> nearest = getNearest(click_x, click_y);

		System.out.println("Closest Events to ("+click_x+","+click_y+"):");
		System.out.println("Event "+nearest.get(0).event +" - $"+nearest.get(0).price + ", Distance " + nearest.get(0).distance);
		System.out.println("Event "+nearest.get(1).event +" - $"+nearest.get(1).price + ", Distance " + nearest.get(1).distance);
		System.out.println("Event "+nearest.get(2).event +" - $"+nearest.get(2).price + ", Distance " + nearest.get(2).distance);
		
	}
	public static void printArray() {
		for(int i=0;i<events.length;i++) {
			for(int j=0;j<events[0].length;j++) {
				System.out.print(events[i][j].event + "\t");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<Coordinate> getNearest(int x, int y) {
		
		ArrayList<Coordinate> distances = new ArrayList<Coordinate>();

		for(int i=0;i<events.length;i++) {
			for(int j=0;j<events[0].length;j++) {
				if(events[i][j].event != 0) {
					
					events[i][j].distance = (Math.abs(x-events[i][j].x) + Math.abs(y-events[i][j].y));
					distances.add(events[i][j]);
				}
			}
		}
		
		Collections.sort(distances, new Comparator<Coordinate>() {

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
