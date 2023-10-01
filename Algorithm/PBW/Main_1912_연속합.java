package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
	// boj Silver2
	
	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int [n+1];
		dp = new Integer [n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		max= dp[1];
		
		cons(n);
		
		System.out.println(max);
	}

	private static int cons(int n) {
		
		if (dp[n] == null) {
			dp[n] = Math.max(cons(n-1) + arr[n], arr[n]);
			
			max = Math.max(dp[n], max);
		}
		
		return dp[n];
	}
}
