package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	// boj Gold5
	
	static int N,result;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		if (map[N][N] == 1) {
			System.out.println(0);
		} else {
			bfs(new int[] {1,2,0});
			System.out.println(result);			
		}
	}

	private static void bfs(int[] pipe) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(pipe);
		
		while (!queue.isEmpty()) {
			int[] move = queue.poll();
			
			if (move[0] == N && move[1] == N) {
				result++;
				continue;
			}
			
			// 가로
			if (move[2] == 0) {
				if (move[1] < N && map[move[0]][move[1] + 1] == 0) {
					queue.add(new int[] {move[0],move[1] + 1, 0});
				}
				if (move[0] < N && move[1] < N && map[move[0]][move[1] + 1] == 0 && map[move[0] + 1][move[1]] == 0 && map[move[0] + 1][move[1] + 1] == 0) {
					queue.add(new int[] {move[0] + 1, move[1] + 1, 2});
				}
			}
			
			// 세로
			if (move[2] == 1) {
				if (move[0] < N && map[move[0] + 1][move[1]] == 0) {
					queue.add(new int[] {move[0] + 1, move[1], 1});
				}
				if (move[0] < N && move[1] < N && map[move[0]][move[1] + 1] == 0 && map[move[0] + 1][move[1]] == 0 && map[move[0] + 1][move[1] + 1] == 0) {
					queue.add(new int[] {move[0] + 1, move[1] + 1, 2});
				}
			}
			
			// 대각선
			if (move[2] == 2) {
				if (move[1] < N && map[move[0]][move[1] + 1] == 0) {
					queue.add(new int[] {move[0],move[1] + 1, 0});
				}
				if (move[0] < N && map[move[0] + 1][move[1]] == 0) {
					queue.add(new int[] {move[0] + 1, move[1], 1});
				}
				if (move[0] < N && move[1] < N && map[move[0]][move[1] + 1] == 0 && map[move[0] + 1][move[1]] == 0 && map[move[0] + 1][move[1] + 1] == 0) {
					queue.add(new int[] {move[0] + 1, move[1] + 1, 2});
				}
			}

		}
	}
}
