import java.util.Random;
import java.util.Scanner;

public class Battle {
	public static void main(String[] args) {
		
		//System Objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println(" ~~~Start of the Battle~~~ ");
		
		//Hobbit - 4 Hobbits
		Hobbit[] heroes = new Hobbit[4];
		String[] heroNames = new String[]{"Meri" , "Pepin" , "Frodo" , "Sam"};
		for(int i = 0; i<heroes.length; i++){
			Hobbit myHobbit = new Hobbit(heroNames[i]);
			heroes[i] = myHobbit;
		}
			
		

		// Ork - 10 Orks
		//String[] enemies = {"Ork "};
		Ork[] enemies = new Ork[10];
		for(int i = 0; i<enemies.length; i++){
			Ork myOrk = new Ork("Ork");
			//myOrk.Name = "Ork ";
			enemies[i] = myOrk;
			//System.out.println(myOrk.name + " [ " + myOrk.weapon.getName() + " ] dealt " + myOrk.weapon.dealDamage() + " damage ");
			//Weapon sword = new Sword ();
			//System.out.println(sword.strength);
		}
		
		for(int i = 0; i<enemies.length; i++){
			int  enemyDamage = enemies[i].health;
			System.out.println("Round " + (i + 1));
			for(int j = 0; j<heroes.length; j++){
				int  heroHealth = heroes[j].health;
				if(heroes[j].isAlive()&& enemies[i].isAlive()){
					System.out.println(heroes[j].name + " [ " + heroes[j].weapon.getName() + " ] dealt " + heroes[j].weapon.dealDamage() + " damage ");
					enemies[i].setHealth(enemies[i].getHealth() - heroes[j].weapon.dealDamage());
					System.out.println(enemies[i].name + " [ " + enemies[i].weapon.getName() + " ] dealt " + enemies[i].weapon.dealDamage() + " damage ");
					heroes[j].setHealth(heroes[j].getHealth() - enemies[i].weapon.dealDamage());
					if(!heroes[j].isAlive()) {
						System.out.println(heroes[j].name + " died :C ");
					}
					if(!enemies[i].isAlive()){
						System.out.println(enemies[i].name + " died >:D ");
					}
				}
			}
		}		
		
		/*
		Sword mySword = new Sword();
		mySword.Name = " Excalibur ";
		mySword.strength = 30; // Damages about 20 - 30 Healthpoints
		
		Fist myFist = new Fist();
		myFist.Name = " One Punch ";
		myFist.strength = 10; // Damages about 5 - 10 Healthpoints
		
		
		boolean running = true;
		
		//while(running) {
		//	int OrkHealth = rand.nextInt(lowOrkHealth);
		//	String enemy = enemies[(enemies.length)];
		//}
		*/
		
	}
}	

class Hobbit {
	
	Random rand = new Random();
	public String name;
	int health = 100;
	Weapon weapon;
	
	public Hobbit (String name) {
		this.name = name;
		if(rand.nextInt(100)<30){
			this.weapon = new Sword();
		}
		else {
			this.weapon = new Fist();
		}
	}
	
	public boolean isAlive(){
		if(health>0){
			return true;
		}
		else {
			return false;
			
		}
	}
	
	public void healed(){
		if(isAlive()){
			health = health + rand.nextInt(15);
		}
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public int getHealth(){
		return health;
	}
}

class Ork {
	
	Random rand = new Random();
	public String name;
	int lowHealth = 80;
	int maxHealth = 150;
	int health;
	Weapon weapon;
	
	public Ork (String name) {
		this.name = name;
		this.health = rand.nextInt(maxHealth - lowHealth) + lowHealth;
		if(rand.nextInt(100)<30){
			this.weapon = new Sword();
		}
		else {
			this.weapon = new Fist();
		}
	}
	public boolean isAlive(){
		if(health>0){
			return true;
		}
		else {
			return false;
			
		}
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public int getHealth(){
		return health;
	}
}

class Weapon {
	Random rand = new Random();
	public String name;
	int strength;
	int minStrength;
	int maxStrength;
	
	public Weapon (String name , int minStrength , int maxStrength) {
		this.name = name;
		this.minStrength = minStrength;
		this.maxStrength = maxStrength;
		this.strength = rand.nextInt(maxStrength - minStrength) + minStrength;
	}
	public int dealDamage(){
		return strength;
	}
	public String getName(){
		return name;
	}
}

class Sword extends Weapon {
	
	//static Random rand = new Random();
	//static int strength = rand.nextInt(10) + 20;
	public Sword() {		
		super("Sword" , 20 , 30);
					
	}
}

class Fist extends Weapon {
	
	public Fist() {
		super("Fist" , 5 , 10);
		
	}
	
}
