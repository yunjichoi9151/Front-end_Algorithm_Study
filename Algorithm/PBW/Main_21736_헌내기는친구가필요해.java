package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736_헌내기는친구가필요해 {
	// boj Silver2
	
	static int N,M;
	static char[][] map;
	static boolean[][] check;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		check = new boolean [N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					queue.add(new int[] {i,j});
					check[i][j] = true;
				}
			}
		}
		
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + dx[j];
					int y = temp[1] + dy[j];
					if (x >= 0 && x < N && y >= 0 && y <M && map[x][y] != 'X' && !check[x][y]) {
						if (map[x][y] == 'P') {
							result++;
						}
						check[x][y] = true;
						queue.add(new int[] {x,y});
					}
				}
			}
		}
		
		if (result == 0 ) {
			System.out.println("TT");
		} else {
			System.out.println(result);
		}
	}
}
