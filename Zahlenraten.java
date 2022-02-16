
import java.util.Random;
import java.util.Scanner;
public class Zahlenraten {
	public static void main (String[] args) {
		if (args.length>0) {
			int x= Integer.parseInt(args[0]);
			computerRaten(x);
		}
		else {
			selberRaten();
		}
	}
	public static void selberRaten () {
		Random rand = new Random ();
		Scanner sc = new Scanner(System.in);
		int zufallszahl= rand.nextInt(100)+1;
		int nextNumber = sc.nextInt();
		while(nextNumber!= zufallszahl) {
			nextNumber = sc.nextInt();
			if (nextNumber>zufallszahl) {
				System.out.println("Die eingegebene Zahl ist zu gross ");
			}
			else {
				System.out.println("Die eingegebene Zahl ist zu klein ");
			}
		} 
		
	}
	public static void computerRaten (int arg) {
		Random rand = new Random ();
		int zufallszahl= rand.nextInt(100)+1;
		int count=0;
		while(arg!= zufallszahl) {
			zufallszahl= rand.nextInt(100)+1;
			count++;
		} 
		System.out.println("Du hast fuer die Zahl: " + arg + " versuche benoetigt: "+ count);
	}

}	
