package package1;

public class Coordinate {
public int x;
public int y;
public double price;
public int tickets;
public int event;
public int distance;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		price = 0.0;
		tickets = 0;
		event = 0;
		distance = Integer.MAX_VALUE;
	}
}
