package algo0408;

import java.util.*;
import java.io.*;

public class Main_14719_빗물 {
	// boj Gold5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		boolean [][] map = new boolean[H][W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int block = Integer.parseInt(st.nextToken());
			for (int j = H - 1; j > H - 1 -block ; j--) {
				map[j][i] = true;				
			}
		}
		
		int result = 0;
		
		// map 표시
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W -1; j++) {
				if (map[i][j]) {
					int temp = j+1;
					int water = 0;
					while (!map[i][temp]) {
						if (temp == W -1) {
							water = 0;
							break;
						}
						water ++;
						temp ++;
					}
					result += water;
				}
			}
		}
		
		System.out.println(result);
	}
}
