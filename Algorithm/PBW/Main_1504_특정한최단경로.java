package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	// boj Gold4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int [N+1][N+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int line = Integer.parseInt(st.nextToken());
			map[start][end] = map[end][start] = line;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (map[j][i] != 0 && map[i][k] != 0) {
						map[j][k] = map[j][k] == 0 ? map[j][i] + map[i][k] : Math.min(map[j][k], map[j][i] + map[i][k]);
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int result = 0;
		
		
		if ((map[1][v1] == 0 && map[1][v2] == 0) || map[v1][v2] == 0 || (map[v1][N] == 0 && map[v2][N] == 0)) {
			// 목적지에 갈 수 없을 때
			System.out.println(-1);
		} else if(v1 == 1 && v2 == N) {
			// v1이 1, v2가 N일때
			result = map[1][N];
			System.out.println(result);
		} else {
			// 1 -> v1 -> v2 -> N 과 1 -> v2 -> v1 -> N 중 짧은 것 선택
			if (map[1][v1] + map[v2][N] > map[1][v2] + map[v1][N]) {
				result = map[1][v2] + map[v1][N] + map[v1][v2];
			} else {
				result = map[1][v1] + map[v2][N] + map[v1][v2];
			}
			System.out.println(result);			
		}
	}
}
