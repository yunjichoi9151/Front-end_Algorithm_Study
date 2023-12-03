package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	// boj Silver1
	
	static int n, result;
	static List<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		list.add(new ArrayList<>());
		for (int i = 1; i < n+1; i++) {
			list.add(new ArrayList<>());
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.get(i).add(0);
			for (int j = 0; j < i; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		result = 0;
//		dfs(1,1,0);
		
		int[][] dp = new int[n+1][n+1];
		dp[1][1] = list.get(1).get(1);
		
		for (int i = 2; i < n+1; i++) {
			for (int j = 1; j < i+1; j++) {
				if (j == 1) {
					dp[i][j] = dp[i-1][j] + list.get(i).get(j);
				} else if (j == i) {
					dp[i][j] = dp[i-1][j-1] + list.get(i).get(j);
				} else {
					dp[i][j] = dp[i-1][j] < dp[i-1][j-1] ? dp[i-1][j-1] + list.get(i).get(j) : dp[i-1][j] + list.get(i).get(j);
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			if (dp[n][i] > result) {
				result = dp[n][i];
			}
		}
		
		System.out.println(result);
	}

//	// dfs는 시간초과가 난다.
//	private static void dfs(int num, int cnt, int sum) {
//		if (num > n) {
//			if (sum > result) {
//				result = sum;
//			}
//			return;
//		}
//		
//		sum += list.get(num).get(cnt);
//		dfs(num+1, cnt, sum);
//		dfs(num+1, cnt+1, sum);
//	}
}
