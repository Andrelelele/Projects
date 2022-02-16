import java.util.Scanner;
import java.util.Random;


/*
 * Controls the players movement and actions
 */
public class GameMaster {
	public static void main(String[] args){
		
		MapObject[][] map = new MapObject[12][12];
		
		placeItems(map); //DONE
		placePlayer(map);
		Player p = new Player();
		Scanner in = new Scanner(System.in);
		
		boolean decision = true;
		
		boolean walking = true;
		
		System.out.println(" ");
		System.out.println("~~~~~ Hello Traveler! ~~~~");
		System.out.println(" ");
		
		do {
			decision = true;
			
		
			System.out.println("What Do You Want To Do? ");
			System.out.println("\twalk. Walk ");
			System.out.println("\ttake. Take ");
			System.out.println("\tdrop. Drop ");
			System.out.println("\tmap. Open The Map ");
			System.out.println("\tinv. Open The Inventory ");
			
			String input = in.nextLine();
			switch (input) {
				
				case "walk":
				
					System.out.println("\t> You Want To Walk ");
					
					/*
					* DONE
					*/
					while (walking) {
						System.out.println("Where Do You Want To Walk? ");
						System.out.println("\tN. North ");
						System.out.println("\tE. East ");
						System.out.println("\tS. South ");
						System.out.println("\tW. West ");
						
						input = in.nextLine();
						
						int x = 0;
						int y = 0;
						for (int i = 0; i < map[0].length; i++) {
							for (int j = 0; j < map[0].length; j++) {
								try {
									if (map[i][j].getSymbol() == 'P') {
									x = j;
									y = i;
								}
								}
								catch (NullPointerException e) {
									
								}
							}
						}	
							switch (input) {
							case "N":
								map = movePlayer(map, x, y+1);
								
								break;
							
							case "E":
								map = movePlayer(map, x+1, y);
								break;
							case "S":
								map = movePlayer(map, x, y-1);
								break;
							case "W":
								map = movePlayer(map, x-1, y);
								break;
							
							default:
								System.out.println("Wrong Input! ");
								break;	
						}
						break;
					}
					break;
				
				case "take":
					System.out.println("You Took An Item ");
					break;
				
				case "drop":
					System.out.println("You Dropped An Item ");
					p.printInventory();
					
					System.out.println("\t.1. Do You Want To Drop An Item? ");
					System.out.println("\t.2. Close Inventory ");
					input = in.nextLine();
					
					switch (input) {
						
						case "1":
							System.out.println("Which Item Do You Want To Drop? ");
							input = in.nextLine();
							p.putItemDown(input);
							break;
						
						case "2":
							break;
						
						default:
						System.out.println("Wrong Input! ");
						break;
					}
					break;
				
				// DONE
				case "map":
					System.out.println("You Opened The Map ");
					printMap(map);
					break;
				
				// DONE
				case "inv":
					System.out.println("You Opened The Inventory ");
					p.printInventory();
					
					System.out.println("\t.1. Do You Want To Drop An Item? ");
					System.out.println("\t.2. Close Inventory ");
					input = in.nextLine();
					
					switch (input) {
						
						case "1":
							System.out.println("Which Item Do You Want To Drop? ");
							input = in.nextLine();
							p.putItemDown(input);
							break;
						
						case "2":
							break;
						
						default:
						System.out.println("Wrong Input! ");
						break;
					}
					break;
					
				default:
					System.out.println("Wrong Input! ");
					break;
			}
		}while (decision);
	}
	
	public static void placePlayer(MapObject[][] map) {
		int x;
		int y;
		x = 1;
		y = 1;
		Player player = new Player();
		player.setSymbol('P');
		map[x][y] = player;
	}
	
	/*
	* Puts specific amounts of items/symbols on the map
	*/
	public static void placeItems(MapObject[][] map) {
		Random rand = new Random();
		int x;
		int y;
		x = rand.nextInt(10)+1;
		y = rand.nextInt(10)+1;
		
		Item item = new Item();
		item.setSymbol('R');
		map[x][y] = item;
		
		/*
		Player player = new Player();
		player.setSymbol('P');
		map[x][y] = Player;
		*/
		
		for(int i = 0; i < rand.nextInt(5)+1; i++) {
			x = rand.nextInt(10)+1;
			y = rand.nextInt(10)+1;
			if (map[x][y]!= null) {
				i--;
			}
			else {
			Obstacle obstacle = new Obstacle();
			obstacle.setSymbol('#');
			map[x][y]  = obstacle;
			}
			
		}
		for(int i = 0; i < rand.nextInt(5)+1; i++) {
			x = rand.nextInt(10)+1;
			y = rand.nextInt(10)+1;
			if (map[x][y]!= null) {
				i--;
			}
			else {
				item = new Item();
				item.setSymbol('I');
				map[x][y] = item;
			}	
		}
	}
	
	/*
	* Shows the map on console
	*/
	public static void printMap(MapObject[][] map) {
		for (int i = 0; i < map[0].length; i++) {
			if (i > 0 && i < 12) {
				Obstacle obstacle = new Obstacle();
				obstacle.setSymbol('|');
				map[i][0]  = obstacle;
				map[i][map[0].length - 1] = obstacle;
			}
			for (int j = 0; j < map[0].length; j++) {
				if (i == 0 || i == map[0].length - 1) {
				Obstacle obstacle = new Obstacle();
				obstacle.setSymbol('-');
				map[i][j]  = obstacle;
				}
				try {
					System.out.print(map[i][j].getSymbol());
				}
				catch(NullPointerException e) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static boolean checkCoordinates(MapObject[][] map, int x, int y) {
		if(x > 1 || x < 10 && y > 1 || y < 10) {
			try {
				if(map[x][y].getCollision() == false) {
				return true;
				}
				else {
					System.out.println("You Cannot Past Here! ");
					return false;
				}
			}
			catch (NullPointerException e) {
				}
		}
		System.out.println("Next Move Is Outside Of The Map ");
		return false;
	}
	
	public static MapObject[][] movePlayer(MapObject[][] map, int x, int y) {
		if(checkCoordinates(map, x, y)) {
			for (int i = 0; i < map[0].length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					try {
						if (map[i][j].getSymbol() == 'P') {
							Player p = (Player)map[i][j];
							System.out.println(x + " " + y);
							System.out.println(j + " " + i);
							map[x][y] = p;
							map[j][i] = null;
							System.out.println(map[x][y].getSymbol());
							System.out.println("Player Moved A Direction");
							return map;
						}
					}
					catch (NullPointerException e) {
					}
				}
			}
		}
		return map;
	}
}
