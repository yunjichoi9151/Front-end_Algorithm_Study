package algo;

import java.util.*;
import java.io.*;

public class Main_2580_스도쿠 {
	// boj Gold4
	
	static int map [][] = new int [9][9];
	static boolean result = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sdoku(0,0);
		
	}
	
	private static boolean horizontal_check(int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num) {
				return true;
			}
		}
		return false;
	}

	private static boolean vertical_check(int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num) {
				return true;
			}
		}
		return false;
	}

	private static boolean square_check(int x, int y, int num) {
		for (int i = (x/3)*3; i < (x/3)*3+3; i++) {
			for (int j = (y/3)*3; j < (y/3)*3+3; j++) {
				if (map[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}

	
	private static void sdoku(int x, int y) {
		if (y > 8) {
			sdoku(x+1,0);
			return;
		}
		if (x > 8) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
//		System.out.println("x : " + x + " y : " + y);
		
		if (map[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (horizontal_check(x, i)) {
					continue;
				} else if (vertical_check(y, i)) {
					continue;
				} else if (square_check(x, y, i)) {
					continue;
				}
				
				map[x][y] = i;
				sdoku(x,y+1);
				map[x][y] = 0;
			}
			return;
		}
		
		sdoku(x,y+1);
		
	}
	
}
