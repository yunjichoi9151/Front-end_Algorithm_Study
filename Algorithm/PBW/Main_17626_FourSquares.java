package algo0408;

import java.util.Scanner;

public class Main_17626_FourSquares {
	// boj Silver3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int [n+1];
		
		dp[1] = 1;
		for (int i = 2; i < n+1; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int j = 1; j*j <= i; j++) {
				int num = i - j * j;
				min = min > dp[num] ? dp[num] : min;
			}
			
			dp[i] = min + 1;
		}
		
		System.out.println(dp[n]);
	}
}
