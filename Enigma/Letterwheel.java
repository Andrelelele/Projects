import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Letterwheel {
	public ArrayList<Character>wheel;
	public ArrayList<Character>compare;
	
	public Letterwheel() {
		wheel = new ArrayList<Character>();
		compare = new ArrayList<Character>();
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (char c : chars) {
			wheel.add(c);
			compare.add(c);
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(wheel.toArray()).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
	}
	
	public void rotate() {
		wheel.add(wheel.get(0));
		wheel.remove(0);
	}
	
	public char process(char input) {
		input = Character.toUpperCase(input);
		int index = compare.indexOf(input);
		return wheel.get(index);
	}

	@Override
	public boolean equals(Object x) {
		System.out.println(x);
		System.out.println(this);
		//return (this == (Letterwheel)x);
		//if ((Letterwheel)x == this) {
			
		//}
		Letterwheel l = (Letterwheel)x;
		if (l == this) {
            return true;
        }
		else {
			System.out.println("Error");
			return false;
		}
	}
}
