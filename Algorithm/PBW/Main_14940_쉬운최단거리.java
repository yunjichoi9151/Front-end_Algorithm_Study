package algo0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {
	// boj Silver1
	
	static int[] px = {-1,0,0,1};
	static int[] py = {0,-1,1,0};
	static int n, m;
	static int[][] map, result;
	static boolean[][] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		result = new int [n][m];
		check = new boolean [n][m];
		
		int start_x = 0;
		int start_y = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start_x = i;
					start_y = j;
				}
			}
		}
		
		check[start_x][start_y] = true;
		result[start_x][start_y] = 0;
		bfs(new int[] {start_x,start_y,0});
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!check[i][j] && map[i][j] == 1) {
					result[i][j] = -1;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == m-1) {
					bw.append(result[i][j] + "\n");					
				} else {
					bw.append(result[i][j] + " ");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}

	private static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int temp[] = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + px[j];
					int y = temp[1] + py[j];
					int distance = temp[2];
					if (x >= 0 && x < n && y >=0 && y < m && !check[x][y] && map[x][y] != 0) {
							result[x][y] = distance + 1;
							check[x][y] = true;
							queue.add(new int[] {x,y,distance+1});							

					}
				}
			}
		}
	}
}
