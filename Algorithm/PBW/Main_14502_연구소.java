package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	// boj Gold4
	static int n,m;
	static int result = 0;
	static int map[][];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(result);
	}

	private static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall+1);
					map[i][j] = 0;
				}
			}
		}
		
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		int[][] safeMap = new int [n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				safeMap[i][j] = map[i][j];
				if (safeMap[i][j] == 2) {
					que.add(new int[] {i,j});
				}
			}
		}
		
		while (true) {
			int size = que.size();
			
			if (size == 0) {
				int safe = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (safeMap[i][j] == 0) {
							safe++;
						}
					}
				}
				
				if (result < safe) {
					result = safe;
				}
//				System.out.println(safe);
				return;
			}
			
			for (int i = 0; i < size; i++) {
				int[] temp = que.poll();
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + dx[j];
					int y = temp[1] + dy[j];
					if (x >= 0 && x < n && y >= 0 && y < m && safeMap[x][y] == 0) {
						que.add(new int[] {x,y});
						safeMap[x][y] = 2;
					}
				}
			}
		}
	}
}
