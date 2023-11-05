package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	// boj Gold4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int [n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int bus = Integer.parseInt(st.nextToken());
			if (map[start][end] != 0 && map[start][end] < bus) {
				continue;
			}
			map[start][end] = bus;				
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				for (int k = 1; k < n+1; k++) {
					if (j == k) {
						continue;
					}
					if (map[j][i] != 0 && map[i][k] != 0) {
						map[j][k] = map[j][k] == 0 ? map[j][i] + map[i][k] : Math.min(map[j][k], map[j][i] + map[i][k]);
					}
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				bw.append(map[i][j]+" ");
			}
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
