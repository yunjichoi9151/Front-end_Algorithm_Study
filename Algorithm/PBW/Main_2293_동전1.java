package algo0408;

import java.util.*;

public class Main_2293_동전1 {
	// boj Gold1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dp [] = new int [k+1];
		int coin [] = new int [n+1];
		
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}
		Arrays.sort(coin);
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
