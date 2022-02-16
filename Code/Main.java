import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) throws Exception {
		int input;
		if (args.length == 0) {
			Scanner read = new Scanner(System.in);

			System.out.print("Please type the numerical code you want to create: ");
			try {
				input = read.nextInt();
			}
			catch(Exception e) {
				throw new WrongInputException("Error: " + read.nextLine() + " is not a valid number! ");
			}
			

		} else {
			try {
				input = Integer.parseInt(args[0]);
			}
			catch(Exception e) {
				throw new WrongInputException("Error: " + args[0] + " is not a valid number! ");
			}
		}

		Code code = new Code(input);

		System.out.println();
		System.out.println("The code " + code.toString() + " was created.");
	}
}

