package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
	// boj Silver1
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] stk = new int [2][n+1];
			int[][] dp = new int [2][n+1];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n+1; j++) {
					stk[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = stk[0][1];
			dp[1][1] = stk[1][1];
			
			for (int i = 2; i < n+1; i++) {
				dp[0][i] = dp[1][i-1] > dp[1][i-2] ? dp[1][i-1] + stk[0][i] : dp[1][i-2] + stk[0][i];
				dp[1][i] = dp[0][i-1] > dp[0][i-2] ? dp[0][i-1] + stk[1][i] : dp[0][i-2] + stk[1][i];
			}
			
			int result = dp[0][n] > dp[1][n] ? dp[0][n] : dp[1][n];
			System.out.println(result);
		}
	}
}
