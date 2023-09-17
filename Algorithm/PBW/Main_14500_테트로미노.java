package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	// boj Gold4
	
	static int result = 0;
	static int N,M;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[i][j] = true;
				dfs(i,j,1,map[i][j]);
				check[i][j] = false;
				figure(i,j);
			}
		}
		
		System.out.println(result);
	}

	private static void dfs(int x, int y, int num, int sum) {
		if (num == 4) {
			result = sum > result ? sum : result;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx >= 0 && mx < N && my >=0 && my < M && !check[mx][my]) {
				check[mx][my] = true;
				dfs(mx, my, num + 1, sum + map[mx][my]);
				check[mx][my] = false;
			}
		}
	}

	private static void figure(int x, int y) {
		int num = 0;
		
		if (x - 1 >= 0 && y - 1 >= 0 && y + 1 < M) {
			num = map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1];
			result = num > result ? num : result;
		}
		if (x + 1 < N && y - 1 >= 0 && y + 1 < M) {
			num = map[x][y] + map[x+1][y] + map[x][y-1] + map[x][y+1];
			result = num > result ? num : result;
		}
		if (x - 1 >= 0 && x + 1 < N && y + 1 < M) {
			num = map[x][y] + map[x+1][y] + map[x-1][y] + map[x][y+1];
			result = num > result ? num : result;
		}
		if (x - 1 >= 0 && x + 1 < N && y - 1 >= 0) {
			num = map[x][y] + map[x+1][y] + map[x-1][y] + map[x][y-1];
			result = num > result ? num : result;
		}
	}
}
