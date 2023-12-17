package algo0408;

import java.util.Scanner;

public class Main_11653_소인수분해 {
	// boj Bronze1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		pf(N);
	}

	private static void pf(int N) {
		for (int i = 2; i <= N; i++) {
			if (N % i == 0) {
				System.out.println(i);
				pf(N / i);
				break;
			}
		}
	}
}
