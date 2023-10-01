package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {
	// boj Silver2
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int [N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int [N+1];
		dp[1] = 1;
		int result = 1;
		
		int num = arr[1];
		for (int i = 2; i < N+1; i++) {
			dp[i] = 1;
			
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			
			result = dp[i] > result ? dp[i] : result;
		}
		
		System.out.println(result);
	}
}


