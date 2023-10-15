package algo0408;

import java.util.Scanner;

public class Main_1049_기타줄 {
	// boj Silver4
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int brand [][] = new int [M][2];
		
		int set = N / 6;
		int piece = N % 6;
		int set_result = Integer.MAX_VALUE;
		int piece_result = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			brand[i][0] = sc.nextInt();
			brand[i][1] = sc.nextInt();
			if (brand[i][0] < set_result) {
				set_result = brand[i][0];
			}
			if (brand[i][1] < piece_result) {
				piece_result = brand[i][1];
			}
		}
		
		if (piece_result * piece > set_result) {
			piece_result = set_result;
			piece = 1;
		}
		if (piece_result * 6 < set_result) {
			set_result = piece_result * 6;
		}

		
		System.out.println(set_result*set+piece_result*piece);
		
	}
}
