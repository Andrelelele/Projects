import java.util.*;
import java.util.Scanner;
public class Mastermind {
	public static void main (String[] args) {
		selberRaten();
	}
	public static void selberRaten () {
		Scanner sc = new Scanner(System.in);
		int[] zahlen=new int[4];
		int a = 0;
		zahlen=zahlenErstellen();
		int cnt = 0;
		while(a<10) {
			System.out.println("Bitte die Zahl eingeben ");
			String nextNumber = sc.next();
			for(int i = 0; i<4;i++){
				if(zahlen[i]==Integer.parseInt(String.valueOf(nextNumber.charAt(i)))){
					System.out.print("X");
					cnt++;
				}
				else{
					System.out.print("O");
				}
			}
			System.out.println("");
			a++;
			if(cnt==4){
				System.out.print("Die richtige Zahl wurde erraten! ");
				break;
			}
			cnt=0;
		}
	}
	public static int[] zahlenErstellen () {
		Random rand = new Random();
		int a = 0;
		int[] zahlen=new int[4];
		int count=0;
		List<Integer> b= new ArrayList<Integer>();
		while (a<4) {
			int zufallsZahl = rand.nextInt(8)+1;
			if (!b.contains(zufallsZahl)){
				b.add(zufallsZahl);
				zahlen[a]=zufallsZahl;
				//System.out.print(zufallsZahl);
				a++;
			}
		}
		return zahlen;
	}	
}
