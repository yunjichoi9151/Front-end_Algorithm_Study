package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {
	// boj Gold5
	
	static char[][] map, color_map;
	static boolean[][] check, color_check;
	static int N, result, color_result;
	static int[] px = {-1,0,0,1};
	static int[] py = {0,-1,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char [N][N];
		color_map = new char [N][N];
		check = new boolean [N][N];
		color_check = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'B') {
					color_map[i][j] = 'B';
				} else {
					color_map[i][j] = 'R';
				}
			}
		}
		
		result = 0;
		color_result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					result++;
					bfs(new int[] {i,j}, map[i][j]);	
				}
				if (!color_check[i][j]) {
					color_result++;
					color_bfs(new int[] {i,j}, color_map[i][j]);
				}
			}
		}
		
		System.out.println(result + " " + color_result);
	}

	private static void color_bfs(int[] num, char color) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(num);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + px[j];
					int y = temp[1] + py[j];
					if (x >= 0 && x < N && y >= 0 && y < N && !color_check[x][y] && color_map[x][y] == color) {
						queue.add(new int[] {x,y});
						color_check[x][y] = true;
					}
				}
			}
		}
	}

	private static void bfs(int[] num, char color) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(num);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = temp[0] + px[j];
					int y = temp[1] + py[j];
					if (x >= 0 && x < N && y >= 0 && y < N && !check[x][y] && map[x][y] == color) {
						queue.add(new int[] {x,y});
						check[x][y] = true;
					}
				}
			}
		}
	}
}
