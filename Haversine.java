package lab9;

public class Haversine
{
	public static final double R = 6372.8;
	
	public static void main(String args[])
	{
		System.out.println("The distance between Maynooth and New York is " + String.format("%.3f",dist(53.3807,-6.5945,40.689,-74.044))+" Kilometers");
	}
	/**
	 * This method takes in the longitude and latitude for 2 point on the planet and return the distance between them in kilometers
	 * @param lat1 is the latitude of the first point
	 * @param lon1 is the longitude of the first point
	 * @param lat2 is the latitude of the second point
	 * @param lon2 is the longitude of the second point
	 * @return the distance between the two points int kilometers
	 */
	public static double dist(double lat1, double lon1, double lat2, double lon2)
	{
	   	double dLat = Math.toRadians(lat2 - lat1);
	   	double dLon = Math.toRadians(lon2 - lon1);
	    lat1 = Math.toRadians(lat1);
	    lat2 = Math.toRadians(lat2);
	 
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
	    double c = 2 * Math.asin(Math.sqrt(a));
	    return R * c;
    }
}
