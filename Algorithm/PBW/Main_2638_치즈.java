package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	// boj Gold3
	
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int cheese = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese++;
				}
			}
		}
		
		int result = 0;
		while (cheese > 0) {
			result++;
			cheese -= melt(new int[] {0,0});	
		}
		
		System.out.println(result);
	}

	private static int melt(int[] start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] check = new int[N][M];
		queue.add(start);
		int num = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();	
				
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + dx[j];
					int y = temp[1] + dy[j];
					if (checkmap(x,y,check)) {
						if (map[x][y] == 0) {
							check[x][y] = -1;
							queue.add(new int[] {x,y});							
						} else {
							check[x][y]++;
							if (check[x][y] == 2) {
								map[x][y] = 0;
								check[x][y] = -1;
								num++;
							}
						}
					}
				}
			}
		}
		
		return num;
	}

	private static boolean checkmap(int x, int y, int[][] check) {
		if (x >= 0 && x < N && y >= 0 && y < M && check[x][y] >= 0) {
			return true;
		}
		return false;
	}
}
