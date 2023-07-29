package algo0408;

import java.util.Scanner;

public class Main_2447_별찍기10 {
	// boj Gold5
	
	static String arr [][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		arr = new String [N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = " ";
			}
		}
		
		star(0,0,N);
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void star(int x, int y, int N) {
		
		if (N / 3 != 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1 ) {
						continue;
					}
					star(x+i*(N/3),y+j*(N/3),N/3);					
				}
			}
		} else {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					if (i == x + N / 3 && j == y + N / 3 ) {
						continue;
					}
					arr[i][j] = "*";
				}
			}
		}
	}
}
