import java.util.Arrays;
import java.util.Scanner;


public class GameMaster {
	
	public static void main (String[] args) {
		try {
			SimpleEnigma ligma = new SimpleEnigma(Integer.parseInt(args[0]));
			runtime(ligma);
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Number Entered");
			return;
		}
		
		/*
		SimpleEnigma x = new SimpleEnigma(5);
		System.out.println(Arrays.toString(x.hint()));
		System.out.println(x.hint(1));
		System.out.println(x.hint(3));
		System.out.println(x.hint(5));
		String input = "ABCD";
		System.out.println(x.receive(input.toCharArray()));
		Scanner in = new Scanner(System.in);
		*/
		
	}
	
	public static void runtime(SimpleEnigma ligma) {
		boolean result = false;
		
		System.out.println(" ");
		System.out.println("~~~~~ Enter the Code ~~~~");
		System.out.println(" ");
		
		
		
		Scanner in = new Scanner(System.in);
		
		do {
			result = false;
			System.out.println("\tN. hint ");
			System.out.println("\tN. hintNumber ");
			System.out.println("\tN. enter ");
			String input = in.nextLine();
			switch (input) {
				
				case "hint":
					String[]hint = ligma.hint();
					for(String s: hint) {
						System.out.println(s);
					}
					break;
				case "hintNumber":
					System.out.println("Enter Wheel Number");
					System.out.println(ligma.hint(in.nextInt()));
					break;
				case "enter":
					System.out.println("Enter Code");
					String code = in.nextLine();
					boolean output = ligma.receive(code.toCharArray());
					if (output) result = true;
					break;
				default:
				
					break;
			}			
		} while (!result);
	}
	
}
