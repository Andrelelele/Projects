//public interface Player {
	
	//public void takeItem();
	
	//public void putItemDown();
	
	//public printitem();
	
//}
public class Player implements MapObject {
	
	public void addItem(String name) {
		
		for(int i = 0; i < item.length; i++) {
			if(item[i] == "") {
				item[i] = name;
				System.out.println("You Have Added: " + name + "! ");
				return;
			}
		}
		System.out.println("");
	}
	
	public void printInventory() {
		for(String x: item) {
			System.out.println(x);
		}
	}
	
	public void putItemDown(String name) {
		for(int i = 0; i < item.length; i++) {
			if(item[i].equals(name)) {
				item[i] = " ";
				i = item.length;
				System.out.println("You Dropped An Item From Your Inventory ");
			}
		}
	}
	
	public static String item[] = {"","",""};
	
	
	char player;
	String namePlayer;
	
	public String getName() {
		return namePlayer;
	}
	
	public void setName(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public char getSymbol() {
		return player;
	}
	
	public void setSymbol(char player) {
		this.player = player;
	}
	
	public boolean getCollision() {
		return true;
	}
	
	public boolean isLootable() {
		return true;
	}
}
