package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	// boj Gold3
	
	static int n,m;
	static int[][] map;
	static boolean[][] check;
	static boolean[][] drillcheck;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int result = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		check = new boolean [n][m];
		drillcheck = new boolean [n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		check[0][0] = true;
		bfs(new int[] {0,0,1,0});
		
		System.out.println(result);
	}

	private static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();
				
				// 최소거리 확인 후 탈출
				if (temp[0] == n-1 && temp[1] == m-1) {
					result = temp[2];
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + dx[j];
					int y = temp[1] + dy[j];
					int move = temp[2];
					int drill = temp[3];
					if (secure(x,y)) {
						// 벽 뚫기 사용여부
						if (drill == 0) {
							if (map[x][y] == 1 && !drillcheck[x][y]) {
								drillcheck[x][y] = true;
								queue.add(new int[] {x,y,move+1,1});
							} 
							if(map[x][y] == 0 && !check[x][y]) {
								check[x][y] = true;
								queue.add(new int[] {x,y,move+1,drill});
							}						
						} else {
							// 벽뚫기를 사용한 경우의 체크
							if(map[x][y] == 0 && !drillcheck[x][y]) {
								drillcheck[x][y] = true;
								queue.add(new int[] {x,y,move+1,drill});
							}
						}
					}
				}
			}
		}
	}
	
	// 갈 수 있는 좌표인지 체크
	private static boolean secure(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m) {
			return true;
		}
		return false;
	}
}
