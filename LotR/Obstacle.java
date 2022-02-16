/*
* Obstacle = Rock
*/
public class Obstacle implements MapObject {
	/*
	* Symbol # represents the obstacle
	*/
	char obstacle;
	String nameObstacle;
	
	public String getName() {
		return nameObstacle;
	}
	
	public char getSymbol() {
		return obstacle;
	}
	
	public boolean isLootable() {
		return false;
	}
	
	public boolean getCollision() {
		return false;
	}
	
	public void setSymbol(char obstacle) {
		this.obstacle = obstacle;
	}
	
}

