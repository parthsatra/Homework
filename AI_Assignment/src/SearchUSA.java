import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class SearchUSA {
	
	public static List<Road> Routes = new ArrayList<Road>();
	public static List<City> Locations = new ArrayList<SearchUSA.City>();
	public static final String ASTAR = "astar";
	public static final String GREEDY = "greedy";
	public static final String UNIFORM = "uniform";
	
	private static final String PATH_SEPERATOR = ",";
	
	public void intialize() {
		Routes.add(new Road("albanyNY", "montreal", 226));
		Routes.add(new Road("albanyNY", "boston", 166));
		Routes.add(new Road("albanyNY", "rochester", 148));
		Routes.add(new Road("albanyGA", "tallahassee", 120));
		Routes.add(new Road("albanyGA", "macon", 106));
		Routes.add(new Road("albuquerque", "elPaso", 267));
		Routes.add(new Road("albuquerque", "santaFe", 61));
		Routes.add(new Road("atlanta", "macon", 82));
		Routes.add(new Road("atlanta", "chattanooga", 117));
		Routes.add(new Road("augusta", "charlotte", 161));
		Routes.add(new Road("augusta", "savannah", 131));
		Routes.add(new Road("austin", "houston", 186));
		Routes.add(new Road("austin", "sanAntonio", 79));
		Routes.add(new Road("bakersfield", "losAngeles", 112)); 
		Routes.add(new Road("bakersfield", "fresno", 107));
		Routes.add(new Road("baltimore", "philadelphia", 102));
		Routes.add(new Road("baltimore", "washington", 45));
		Routes.add(new Road("batonRouge", "lafayette", 50));
		Routes.add(new Road("batonRouge", "newOrleans", 80));
		Routes.add(new Road("beaumont", "houston", 69));  
		Routes.add(new Road("beaumont", "lafayette", 122));
		Routes.add(new Road("boise", "saltLakeCity", 349)); 
		Routes.add(new Road("boise", "portland", 428));
		Routes.add(new Road("boston", "providence", 51));
		Routes.add(new Road("buffalo", "toronto", 105)); 
		Routes.add(new Road("buffalo", "rochester", 64));  
		Routes.add(new Road("buffalo", "cleveland", 191));
		Routes.add(new Road("buffalo", "toronto", 105)); 
		Routes.add(new Road("buffalo", "cleveland", 191));
		Routes.add(new Road("calgary", "vancouver", 605)); 
		Routes.add(new Road("calgary", "winnipeg", 829));
		Routes.add(new Road("charlotte", "greensboro",  91));
		Routes.add(new Road("chattanooga", "nashville",  129));
		Routes.add(new Road("chicago", "milwaukee",  90));  
		Routes.add(new Road("chicago", "midland",  279));
		Routes.add(new Road("cincinnati", "indianapolis",  110));  
		Routes.add(new Road("cincinnati", "dayton",  56));
		Routes.add(new Road("cleveland", "pittsburgh",  157));  
		Routes.add(new Road("cleveland", "columbus",  142));
		Routes.add(new Road("coloradoSprings", "denver",  70)); 
		Routes.add(new Road("coloradoSprings", "santaFe",  316));
		Routes.add(new Road("columbus", "dayton", 72));
		Routes.add(new Road("dallas", "denver", 792));  
		Routes.add(new Road("dallas", "mexia", 83));
		Routes.add(new Road("daytonaBeach", "jacksonville", 92));  
		Routes.add(new Road("daytonaBeach", "orlando",  54));
		Routes.add(new Road("denver", "wichita",  523));  
		Routes.add(new Road("denver", "grandJunction", 246));
		Routes.add(new Road("desMoines", "omaha", 135));  
		Routes.add(new Road("desMoines", "minneapolis", 246));
		Routes.add(new Road("elPaso", "sanAntonio", 580)); 
		Routes.add(new Road("elPaso", "tucson", 320));
		Routes.add(new Road("eugene", "salem", 63)); 
		Routes.add(new Road("eugene", "medford", 165));
		Routes.add(new Road("europe", "philadelphia", 3939));
		Routes.add(new Road("ftWorth", "oklahomaCity", 209));
		Routes.add(new Road("fresno", "modesto", 109));
		Routes.add(new Road("grandJunction", "provo", 220));
		Routes.add(new Road("greenBay", "minneapolis", 304));
		Routes.add(new Road("greenBay", "milwaukee", 117));
		Routes.add(new Road("greensboro", "raleigh", 74));
		Routes.add(new Road("houston", "mexia", 165));
		Routes.add(new Road("indianapolis", "stLouis", 246));
		Routes.add(new Road("jacksonville", "savannah", 140));
		Routes.add(new Road("jacksonville", "lakeCity", 113));
		Routes.add(new Road("japan", "pointReyes", 5131)); 
		Routes.add(new Road("japan", "sanLuisObispo", 5451));
		Routes.add(new Road("kansasCity", "tulsa", 249));  
		Routes.add(new Road("kansasCity", "stLouis", 256)); 
		Routes.add(new Road("kansasCity", "wichita", 190));
		Routes.add(new Road("keyWest", "tampa", 446));
		Routes.add(new Road("lakeCity", "tampa", 169));  
		Routes.add(new Road("lakeCity", "tallahassee", 104));
		Routes.add(new Road("laredo", "sanAntonio", 154));
		Routes.add(new Road("laredo", "mexico", 741));
		Routes.add(new Road("lasVegas", "losAngeles", 275)); 
		Routes.add(new Road("lasVegas", "saltLakeCity", 486));
		Routes.add(new Road("lincoln", "wichita", 277));
		Routes.add(new Road("lincoln", "omaha", 58));
		Routes.add(new Road("littleRock", "memphis", 137)); 
		Routes.add(new Road("littleRock", "tulsa", 276));
		Routes.add(new Road("losAngeles", "sanDiego", 124)); 
		Routes.add(new Road("losAngeles", "sanLuisObispo",  182));
		Routes.add(new Road("medford", "redding",  150));
		Routes.add(new Road("memphis",  "nashville",  210));
		Routes.add(new Road("miami",  "westPalmBeach",  67));
		Routes.add(new Road("midland",  "toledo",  82));
		Routes.add(new Road("minneapolis",  "winnipeg",  463));
		Routes.add(new Road("modesto",  "stockton",  29));
		Routes.add(new Road("montreal",  "ottawa",  132));
		Routes.add(new Road("newHaven",  "providence",  110));  
		Routes.add(new Road("newHaven",  "stamford",  92));
		Routes.add(new Road("newOrleans",  "pensacola",  268));
		Routes.add(new Road("newYork",  "philadelphia",  101));
		Routes.add(new Road("norfolk",  "richmond",  92));  
		Routes.add(new Road("norfolk",  "raleigh",  174));
		Routes.add(new Road("oakland",  "sanFrancisco",  8)); 
		Routes.add(new Road("oakland",  "sanJose",  42));
		Routes.add(new Road("oklahomaCity", "tulsa",  105));
		Routes.add(new Road("orlando", "westPalmBeach",  168)); 
		Routes.add(new Road("orlando", "tampa",  84));
		Routes.add(new Road("ottawa",  "toronto",  269));
		Routes.add(new Road("pensacola",  "tallahassee",  120));
		Routes.add(new Road("philadelphia",  "pittsburgh",  319));
		Routes.add(new Road("philadelphia",  "newYork",  101)); 
		Routes.add(new Road("philadelphia",  "uk1",  3548));
		Routes.add(new Road("philadelphia",  "uk2",  3548));
		Routes.add(new Road("phoenix",  "tucson",  117));  
		Routes.add(new Road("phoenix",  "yuma",  178));
		Routes.add(new Road("pointReyes",  "redding",  215)); 
		Routes.add(new Road("pointReyes",  "sacramento",  115));
		Routes.add(new Road("portland",  "seattle",  174));  
		Routes.add(new Road("portland",  "salem",  47));
		Routes.add(new Road("reno",  "saltLakeCity",  520)); 
		Routes.add(new Road("reno",  "sacramento",  133));
		Routes.add(new Road("richmond",  "washington",  105));
		Routes.add(new Road("sacramento",  "sanFrancisco",  95));  
		Routes.add(new Road("sacramento",  "stockton",  51));
		Routes.add(new Road("salinas",  "sanJose",  31));  
		Routes.add(new Road("salinas",  "sanLuisObispo",  137));
		Routes.add(new Road("sanDiego",  "yuma",  172));
		Routes.add(new Road("saultSteMarie", "thunderBay",  442));  
		Routes.add(new Road("saultSteMarie",  "toronto",  436));
		Routes.add(new Road("seattle",  "vancouver",  115));
		Routes.add(new Road("thunderBay",  "winnipeg",  440));
	
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
	
	public class Road {
		private String srcCity;
		private String destCity;
		private int cost;
		
		public Road(String srcCity, String destCity, int cost) {
			super();
			this.srcCity = srcCity;
			this.destCity = destCity;
			this.cost = cost;
		}
		
		public String getSrcCity() {
			return srcCity;
		}
		public void setSrcCity(String srcCity) {
			this.srcCity = srcCity;
		}
		public String getDestCity() {
			return destCity;
		}
		public void setDestCity(String destCity) {
			this.destCity = destCity;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o != null && o instanceof Road) {
				Road r = (Road)o;
				if(r.getSrcCity().equals(srcCity) && r.getDestCity().equals(destCity)) {
					return true;
				} else if(r.getSrcCity().equals(destCity) && r.getDestCity().equals(srcCity)) {
					return true;
				}
			}
			return false;
		}
	}
	
	class Node implements Comparable<Node>{
		private String path;
		private int actualCost;
		private double heuristicCost;
		
		public Node(String path, int actualCost, double heuristicCost) {
			super();
			this.path = path;
			this.actualCost = actualCost;
			this.heuristicCost = heuristicCost;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public int getActualCost() {
			return actualCost;
		}

		public void setActualCost(int actualCost) {
			this.actualCost = actualCost;
		}

		public double getHeuristicCost() {
			return heuristicCost;
		}

		public void setHeuristicCost(double heuristicCost) {
			this.heuristicCost = heuristicCost;
		}

		@Override
		public int compareTo(Node o) {
			double totalCost = actualCost + heuristicCost;
			double totalCost_o = o.getActualCost() + o.getHeuristicCost();
			if(totalCost == totalCost_o) {
				return 0;
			} else if (totalCost > totalCost_o) {
				return 1;
			} else if (totalCost < totalCost_o) {
				return -1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj != null && obj instanceof Node) {
				Node newNode = (Node)obj;
				String existingCity = getCurrentCity(getPath());
				String newCity = getCurrentCity(newNode.getPath());
				if(existingCity.equalsIgnoreCase(newCity)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static void logOutput(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String args[]) {
		SearchUSA search = new SearchUSA();
		search.intialize();
		
		if (args.length == 3) {
			String searchType = args[0];
			String srcCity = args[1];
			String destCity = args[2];
			
			if (ASTAR.equals(searchType)) {
				search.astar(srcCity, destCity);
			} else if (GREEDY.equals(searchType)) {
				search.greedy(srcCity, destCity);
			} else if (UNIFORM.equals(searchType)) {
				search.uniform(srcCity, destCity);
			}
		}
	}

	private void astar(String srcCity, String destCity) {
		Queue<Node> queue = new PriorityQueue<Node>();
		List<String> visitedList = new ArrayList<String>();
		queue.add(new Node(srcCity, 0, 0));
		int totalNodesExpanded = 0;
		while(!queue.isEmpty()) {
			Node currentNode = queue.remove();
			if(isGoalAchieved(currentNode.getPath(), destCity)) {
				logOutput("");
				logOutput("Total Nodes Expanded by A* = " + totalNodesExpanded);
				logOutput("Path generated by A*: " + currentNode.getPath());
				logOutput("Path length generated by A*: " + getPathLength(currentNode.getPath()));
				logOutput("Cost of A*: " + currentNode.actualCost);
				return;
			} else {
				String currentCity = getCurrentCity(currentNode.getPath());
				if(totalNodesExpanded != 0) {
					System.out.print(", ");
				} else {
					System.out.print("Nodes Expanded are : ");
				}
				System.out.print(currentCity);
				totalNodesExpanded ++;
				if(!visitedList.contains(currentCity)) {
					visitedList.add(currentCity);
				}
				List<Node> possibleMoves = moveGenerator(currentCity);
				for (Node possibleMove : possibleMoves) {
					if(!visitedList.contains(possibleMove.getPath())) {
						String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
						int totalCost = currentNode.getActualCost() + possibleMove.getActualCost();
						double newHeuristicCost = calculateHeuristicCost(possibleMove.getPath(), destCity);
						Node node = new Node(newPath, totalCost, newHeuristicCost);
						if(queue.contains(node)) {
							updateQueueNode(queue, node);
						} else {
							queue.add(node);
						}
					}
				}
			}
		}		
		
		logOutput("\nNo path found for A*");
	}


	private void uniform(String srcCity, String destCity) {
		Queue<Node> queue = new PriorityQueue<Node>();
		List<String> visitedList = new ArrayList<String>();
		queue.add(new Node(srcCity, 0, 0));
		int totalNodesExpanded = 0;
		while(!queue.isEmpty()) {
			Node currentNode = queue.remove();
			if(isGoalAchieved(currentNode.getPath(), destCity)) {
				logOutput("");
				logOutput("Total Nodes Expanded by Uniform = " + totalNodesExpanded);
				logOutput("Path generated by Uniform Cost: " + currentNode.getPath());
				logOutput("Path length generated by Uniform Cost: " + getPathLength(currentNode.getPath()));
				logOutput("Cost of Unifrom: " + currentNode.actualCost);
				return;
			} else {
				String currentCity = getCurrentCity(currentNode.getPath());
				if(totalNodesExpanded != 0) {
					System.out.print(", ");
				} else {
					System.out.print("Nodes Expanded are : ");
				}
				totalNodesExpanded++;
				System.out.print(currentCity);
				visitedList.add(currentCity);
				List<Node> possibleMoves = moveGenerator(currentCity);
				for (Node possibleMove : possibleMoves) {
					if(!visitedList.contains(possibleMove.getPath())) {
						String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
						int totalCost = currentNode.getActualCost() + possibleMove.getActualCost();
						Node node = new Node(newPath, totalCost, 0);
						if(queue.contains(node)) {
							updateQueueNode(queue, node);
						} else {
							queue.add(node);
						}
					}
				}
			}
		}		
		logOutput("\nNo path found for Uniform Cost");
	}

	private void greedy(String srcCity, String destCity) {
		Queue<Node> queue = new PriorityQueue<Node>();
		List<String> visitedList = new ArrayList<String>();
		queue.add(new Node(srcCity, 0, 0));
		int totalNodesExpanded = 0;
		while(!queue.isEmpty()) {
			Node currentNode = queue.remove();
			if(isGoalAchieved(currentNode.getPath(), destCity)) {
				logOutput("");
				logOutput("Total Nodes Expanded by Greedy = " + totalNodesExpanded);
				logOutput("Path generated by Greedy: " + currentNode.getPath());
				logOutput("Path length generated by Greedy: " + getPathLength(currentNode.getPath()));				
				int totalCost = getPathCost(currentNode.getPath());
				logOutput("Cost of Greedy: " + totalCost);
				return;
			} else {
				String currentCity = getCurrentCity(currentNode.getPath());
				if(totalNodesExpanded != 0) {
					System.out.print(", ");
				} else {
					System.out.print("Nodes Expanded are : ");
				}
				totalNodesExpanded++;
				System.out.print(currentCity);
				visitedList.add(currentCity);
				List<Node> possibleMoves = moveGenerator(currentCity);
				for (Node possibleMove : possibleMoves) {
					if(!visitedList.contains(possibleMove.getPath())) {
						String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
						double newHeuristicCost = calculateHeuristicCost(possibleMove.getPath(), destCity);
						Node node = new Node(newPath, 0, newHeuristicCost);
						if(queue.contains(node)) {
							updateQueueNode(queue, node);
						} else {
							queue.add(node);
						}
					}
				}
			}
		}		
		logOutput("\nNo path found for Greedy");
	}

	private int getPathLength(String path) {
		String[] cities = path.split(PATH_SEPERATOR);
		return cities.length;
	}
	
	private int getPathCost(String path) {
		String[] cities = path.split(PATH_SEPERATOR);
		int totalCost = 0;
		for (int i = 0; i < cities.length - 1 ; i++) {
			Road r = new Road(cities[i], cities[i+1], 0);
			if(Routes.contains(r)) {
				int indexOf = Routes.indexOf(r);
				Road road = Routes.get(indexOf);
				totalCost += road.getCost();
			}
		}
		return totalCost;
	}

	private static boolean isGoalAchieved(String path, String destCityName) {
        String lastVisitedCity = getCurrentCity(path);
        if(lastVisitedCity != null && !lastVisitedCity.trim().equals("") && lastVisitedCity.equalsIgnoreCase(destCityName)) {
            return true;
        }
        return false;
    }
	
	private List<Node> moveGenerator(String currentCity) {
		List<Node> possibleMoves = new ArrayList<Node>();
        if(currentCity != null) {
        	for (Road road : Routes) {
				if(road.getSrcCity().equalsIgnoreCase(currentCity)) {
					possibleMoves.add(new Node(road.getDestCity(), road.getCost(), 0));
				} else if (road.getDestCity().equalsIgnoreCase(currentCity)) {
					possibleMoves.add(new Node(road.getSrcCity(), road.getCost(), 0));
				}
			}
        }
        return possibleMoves;
	}
	
	private static String getCurrentCity(String currentPath) {
        if(currentPath != null) {
            int index = currentPath.lastIndexOf(PATH_SEPERATOR);
            if(index != -1)
            {
                String lastVisitedCity = currentPath.substring(index + 1);
                return lastVisitedCity;
            } else {
                return currentPath;
            }
        }
        return null;
    }
	
	private void updateQueueNode(Queue<Node> queue, Node newNode) {
		for (Node existingNode : queue) {
			if(existingNode.equals(newNode)) {
				if(existingNode.getActualCost() + existingNode.getHeuristicCost() > newNode.getActualCost() + newNode.getHeuristicCost()) {
					existingNode.setPath(newNode.getPath());
					existingNode.setActualCost(newNode.getActualCost());
					existingNode.setHeuristicCost(newNode.getHeuristicCost());
				}
			}
		}
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
			}
			if(city.getCityName().equalsIgnoreCase(destCity)) {
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
