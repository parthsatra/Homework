import java.util.ArrayList;
import java.util.List;

public class HeuristicValue {
	
	public static List<City> Locations = new ArrayList<City>();
	
	public class City {
		private String cityName;
		private double latitude;
		private double longitute;
		
		public City(String cityName, double latitude, double longitute) {
			super();
			this.cityName = cityName;
			this.latitude = latitude;
			this.longitute = longitute;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitute() {
			return longitute;
		}

		public void setLongitute(double longitute) {
			this.longitute = longitute;
		}
	}
	
	public void initialise() {
		Locations.add(new City("albanyGA",31.58,84.17));
		Locations.add(new City("albanyNY",42.66,73.78));
		Locations.add(new City("albuquerque",35.11,106.61));
		Locations.add(new City("atlanta",33.76,84.40));
		Locations.add(new City("augusta",33.43,82.02));
		Locations.add(new City("austin",30.30,97.75));
		Locations.add(new City("bakersfield",35.36,119.03));
		Locations.add(new City("baltimore",39.31,76.62));
		Locations.add(new City("batonRouge",30.46,91.14));
		Locations.add(new City("beaumont",30.08,94.13));
		Locations.add(new City("boise",43.61,116.24));
		Locations.add(new City("boston",42.32,71.09));
		Locations.add(new City("buffalo",42.90,78.85));
		Locations.add(new City("calgary",51.00,114.00));
		Locations.add(new City("charlotte",35.21,80.83));
		Locations.add(new City("chattanooga",35.05,85.27));
		Locations.add(new City("chicago",41.84,87.68));
		Locations.add(new City("cincinnati",39.14,84.50));
		Locations.add(new City("cleveland",41.48,81.67));
		Locations.add(new City("coloradoSprings",38.86,104.79));
		Locations.add(new City("columbus",39.99,82.99));
		Locations.add(new City("dallas",32.80,96.79));
		Locations.add(new City("dayton",39.76,84.20));
		Locations.add(new City("daytonaBeach",29.21,81.04));
		Locations.add(new City("denver",39.73,104.97));
		Locations.add(new City("desMoines",41.59,93.62));
		Locations.add(new City("elPaso",31.79,106.42));
		Locations.add(new City("eugene",44.06,123.11));
		Locations.add(new City("europe",48.87,-2.33));
		Locations.add(new City("ftWorth",32.74,97.33));
		Locations.add(new City("fresno",36.78,119.79));
		Locations.add(new City("grandJunction",39.08,108.56));
		Locations.add(new City("greenBay",44.51,88.02));
		Locations.add(new City("greensboro",36.08,79.82));
		Locations.add(new City("houston",29.76,95.38));
		Locations.add(new City("indianapolis",39.79,86.15));
		Locations.add(new City("jacksonville",30.32,81.66));
		Locations.add(new City("japan",35.68,220.23));
		Locations.add(new City("kansasCity",39.08,94.56));
		Locations.add(new City("keyWest",24.56,81.78));
		Locations.add(new City("lafayette",30.21,92.03));
		Locations.add(new City("lakeCity",30.19,82.64));
		Locations.add(new City("laredo",27.52,99.49));
		Locations.add(new City("lasVegas",36.19,115.22));
		Locations.add(new City("lincoln",40.81,96.68));
		Locations.add(new City("littleRock",34.74,92.33));
		Locations.add(new City("losAngeles",34.03,118.17));
		Locations.add(new City("macon",32.83,83.65));
		Locations.add(new City("medford",42.33,122.86));
		Locations.add(new City("memphis",35.12,89.97));
		Locations.add(new City("mexia",31.68,96.48));
		Locations.add(new City("mexico",19.40,99.12));
		Locations.add(new City("miami",25.79,80.22));
		Locations.add(new City("midland",43.62,84.23));
		Locations.add(new City("milwaukee",43.05,87.96));
		Locations.add(new City("minneapolis",44.96,93.27));
		Locations.add(new City("modesto",37.66,120.99));
		Locations.add(new City("montreal",45.50,73.67));
		Locations.add(new City("nashville",36.15,86.76));
		Locations.add(new City("newHaven",41.31,72.92));
		Locations.add(new City("newOrleans",29.97,90.06));
		Locations.add(new City("newYork",40.70,73.92));
		Locations.add(new City("norfolk",36.89,76.26));
		Locations.add(new City("oakland",37.80,122.23));
		Locations.add(new City("oklahomaCity",35.48,97.53));
		Locations.add(new City("omaha",41.26,96.01));
		Locations.add(new City("orlando",28.53,81.38));
		Locations.add(new City("ottawa",45.42,75.69));
		Locations.add(new City("pensacola",30.44,87.21));
		Locations.add(new City("philadelphia",40.72,76.12));
		Locations.add(new City("phoenix",33.53,112.08));
		Locations.add(new City("pittsburgh",40.40,79.84));
		Locations.add(new City("pointReyes",38.07,122.81));
		Locations.add(new City("portland",45.52,122.64));
		Locations.add(new City("providence",41.80,71.36));
		Locations.add(new City("provo",40.24,111.66));
		Locations.add(new City("raleigh",35.82,78.64));
		Locations.add(new City("redding",40.58,122.37));
		Locations.add(new City("reno",39.53,119.82));
		Locations.add(new City("richmond",37.54,77.46));
		Locations.add(new City("rochester",43.17,77.61));
		Locations.add(new City("sacramento",38.56,121.47));
		Locations.add(new City("salem",44.93,123.03));
		Locations.add(new City("salinas",36.68,121.64));
		Locations.add(new City("saltLakeCity",40.75,111.89));
		Locations.add(new City("sanAntonio",29.45,98.51));
		Locations.add(new City("sanDiego",32.78,117.15));
		Locations.add(new City("sanFrancisco",37.76,122.44));
		Locations.add(new City("sanJose",37.30,121.87));
		Locations.add(new City("sanLuisObispo",35.27,120.66));
		Locations.add(new City("santaFe",35.67,105.96));
		Locations.add(new City("saultSteMarie",46.49,84.35));
		Locations.add(new City("savannah",32.05,81.10));
		Locations.add(new City("seattle",47.63,122.33));
		Locations.add(new City("stLouis",38.63,90.24));
		Locations.add(new City("stamford",41.07,73.54));
		Locations.add(new City("stockton",37.98,121.30));
		Locations.add(new City("tallahassee",30.45,84.27));
		Locations.add(new City("tampa",27.97,82.46));
		Locations.add(new City("thunderBay",48.38,89.25));
		Locations.add(new City("toledo",41.67,83.58));
		Locations.add(new City("toronto",43.65,79.38));
		Locations.add(new City("tucson",32.21,110.92));
		Locations.add(new City("tulsa",36.13,95.94));
		Locations.add(new City("uk1",51.30,0.00));
		Locations.add(new City("uk2",51.30,0.00));
		Locations.add(new City("vancouver",49.25,123.10));
		Locations.add(new City("washington",38.91,77.01));
		Locations.add(new City("westPalmBeach",26.71,80.05));
		Locations.add(new City("wichita",37.69,97.34));
		Locations.add(new City("winnipeg",49.90,97.13));
		Locations.add(new City("yuma",32.69,114.62));
	}
	
	public static void main(String args[]) {
		HeuristicValue h = new HeuristicValue();
		h.initialise();
		double calculateHeuristicCost = h.calculateHeuristicCost("columbus", "montreal");
		System.out.println(calculateHeuristicCost);
	}
	
	private double calculateHeuristicCost(String path, String destCity) {
		double latitude1 = 0;
		double latitude2 = 0;
		double longitude1 = 0;
		double longitude2 = 0;
		for (City city : Locations) {
			if(city.getCityName().equalsIgnoreCase(path)) {
				latitude1 = city.getLatitude();
				longitude1 = city.getLongitute();
			} else if(city.getCityName().equalsIgnoreCase(destCity)) {
				latitude2 = city.getLatitude();
				longitude2 = city.getLongitute();
			}
		}
		double heuristicCost = heuristicFunction(latitude1,longitude1, latitude2, longitude2);
		return heuristicCost;
	}

	private double heuristicFunction(double latitude1, double longitude1,
			double latitude2, double longitude2) {
		double lat_sum = latitude1 + latitude2;
		double lat_sub = latitude1 - latitude2;
		double long_sub = longitude1 - longitude2;
		
		double term1 = Math.pow(69.5 * lat_sub, 2);
		double term2 = Math.pow(69.5 * Math.cos(lat_sum / 360 * Math.PI) * long_sub, 2); 
		double heuristicValue = Math.sqrt(term1 + term2);
		return heuristicValue;
	}
}
