import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleEnigma {
	
	public ArrayList<Letterwheel>wheels = new ArrayList<Letterwheel>();
	private int counter = 0;
	
	public String decrypt = "";
	
	public SimpleEnigma(int amount) {
		Random rand = new Random();
		for(int i = 0; i < amount; i++) {
			wheels.add(i,new Letterwheel() );
			for(int j = 0; j < rand.nextInt(50); j++) {
				wheels.get(i).rotate();
			}
			// Hier equals Vergleich machen
		}
		System.out.println(wheels.toString());
	}
	
	public void turnWheels() {
		int pos = 0; 
		counter++;
		for(int i = wheels.size()-1; i >= 0; i--) {
			pos++;
			if(counter % pos == 0) {
				Letterwheel wheel = wheels.get(i);
				wheel.rotate();
				wheels.set(i, wheel);
			}
		}
		
	}
	
	public boolean receive(char[] x) {
		char[]proc = new char[x.length];
		for(int i = 0; i < x.length; i++) {
			for(int j = wheels.size()-1; j >= 0; j--) {
				proc[i] = wheels.get(j).process(x[i]);
			}
			turnWheels();
		}
		decrypt = String.valueOf(proc);
		if(String.valueOf(proc) == "RING") {
			System.out.println("Input: " + String.valueOf(x));
			System.out.println("Output: " + decrypt);
			System.out.println("You have beaten the Machine!");
			return true;
		}
		else {
			System.out.println("Input: " + String.valueOf(x));
			System.out.println("Output: " + decrypt);
			return false;
		}
	}
	
	public String hint(int pos) {
		return wheels.get(wheels.size()-pos).toString();
	}
	
	public String[] hint() {
		String[]output = new String[wheels.size()];
		for(int i = 0; i < wheels.size(); i++) {
			output[i] = "Rad " + (i+1) + ": " + wheels.get(wheels.size()-1 -i).toString();
		}
		return output;
	}
	
}
