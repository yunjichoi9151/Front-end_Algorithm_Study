package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자정사각형 {
	// boj Silver3
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map [][] = new int [N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}
		
		int short_line = N > M ? M : N;
		boolean result = false;
		for (int s = short_line -1; s >= 0; s--) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i+s < N && j + s < M) {
						if (map[i][j] == map[i][j+s] && map[i][j] == map[i+s][j+s] && map[i][j] == map[i+s][j]) {
							result = true;
							System.out.println((s+1)*(s+1));
						}
					}
					if (result) {
						break;
					}
				}
				if (result) {
					break;
				}
			}
			if (result) {
				break;
			}
		}
	}
}
