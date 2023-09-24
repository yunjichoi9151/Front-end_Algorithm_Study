package algo;

import java.io.*;
import java.util.*;

public class Main_7576_토마토 {
	// boj Gold5
	
	//좌상우하
	static int [] move_x = {0,-1,0,1};
	static int [] move_y = {-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int ungrown = 0;
		int date = 0;
		
		int box [][] = new int [N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new int [] {i,j});
				} else if (box[i][j] == 0) {
					ungrown ++;
				}
			}
		}
		
		if (ungrown == 0) {
			System.out.println(0);
		} else {
			while (!queue.isEmpty()) {
				if (ungrown == 0) {
					break;
				}
				int temp = queue.size();
				date ++;
				for (int i = 0; i < temp; i++) {
					int tomato [] = queue.poll();
					for (int j = 0; j < 4; j++) {
						int x = tomato[0] + move_x[j];
						int y = tomato[1] + move_y[j];
						if (x < N && x >= 0 && y < M && y >= 0 ) {
							if (box[x][y] == 0) {
								box[x][y] = 1;
								ungrown --;
								queue.add(new int [] {x,y});
							}
						}
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(box[i][j] + " ");
//				}
//				System.out.println();
//			}
			if (ungrown == 0) {
				System.out.println(date);
			} else {
				
				System.out.println(-1);
			}
		}
	}

}
