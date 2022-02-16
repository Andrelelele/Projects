import java.util.Random;
import java.util.Scanner;

//DONE
public class Map {
	public static void main(String[] args) {
		char[][] map = new char[12][12];
		for (int i = 0; i < map[0].length; i++) {
			if (i > 0 && i < 12) {
				map[i][0]  = '|';
				map[i][map[0].length - 1] = '|';
			}
			for (int j = 0; j < map[0].length; j++) {
				if (i == 0 || i == map[0].length - 1) {
				map[i][j]  = '-';
				map[i][j] = ;
				}
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
