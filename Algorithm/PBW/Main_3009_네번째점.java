package algo0408;

import java.util.Scanner;

public class Main_3009_네번째점 {
	// boj Bronze3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] square = new int [3][2];
		for (int i = 0; i < 3; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			square[i][0] = x;
			square[i][1] = y;
		}
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < 2; i++) {
			if (square[0][i] == square[1][i]) {
				square[0][i] = square[1][i] = 0;
			}
			if (square[1][i] == square[2][i]) {
				square[1][i] = square[2][i] = 0;
			}
			if (square[0][i] == square[2][i]) {
				square[0][i] = square[2][i] = 0;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (square[i][0] != 0) {
				x = square[i][0];
			}
			if (square[i][1] != 0) {
				y = square[i][1];
			}
		}
		
		System.out.println(x + " " + y);
	}
}
