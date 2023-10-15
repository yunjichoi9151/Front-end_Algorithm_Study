package algo;

import java.util.Scanner;

public class Main_3003_킹퀸룩비숍나이트폰 {
	// boj Bronze5
	
	public static void main(String[] args) {
		int chess [] = new int [] {1,1,2,2,2,8};
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			chess[i] -= sc.nextInt();
			System.out.print(chess[i] + " ");
		}
	}
}
