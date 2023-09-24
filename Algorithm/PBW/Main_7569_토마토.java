package algo;

import java.io.*;
import java.util.*;

public class Main_7569_토마토 {
	// boj Gold5
	
	static int M,N,H;
	static int day = 0;
	static int grown = 0;
	static int undergrown = 0;
	static int box[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int [H][N][M];
		Queue<int[]> tomato = new LinkedList<>();
		
		for (int h = 0; h < H; h++) {
			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < M; n++) {
					box[h][m][n] = Integer.parseInt(st.nextToken());
					if (box[h][m][n] == 1) {
						grown ++;
						tomato.add(new int [] {h,m,n});
					} else if (box[h][m][n] == 0) {
						undergrown ++;
					}
//					System.out.print(box[h][m][n]);
				}
			}
		}
		
		if (undergrown == 0) {
			System.out.println(0);
		} else {
			while (!tomato.isEmpty()) {
				if (undergrown == 0) {
					break;
				}
				int gt = tomato.size();
				day ++;
				
				for (int i = 0; i < gt; i++) {
					int temp [] = tomato.poll();
					// 아랫 상자에 있는 토마토
					if (temp[0] - 1 >= 0) {
						if (box[temp[0]-1][temp[1]][temp[2]] == 0) {
							box[temp[0]-1][temp[1]][temp[2]] = 1;
							grown ++;
							undergrown --;
							tomato.add(new int [] {temp[0]-1,temp[1],temp[2]});
						}				
					}
					// 윗 상자에 있는 토마토
					if (temp[0] + 1 < H) {
						if (box[temp[0]+1][temp[1]][temp[2]] == 0) {
							box[temp[0]+1][temp[1]][temp[2]] = 1;
							grown ++;
							undergrown --;
							tomato.add(new int [] {temp[0]+1,temp[1],temp[2]});
						}				
					}
					// 위에 있는 토마토
					if (temp[1] + 1 < N) {
						if (box[temp[0]][temp[1] +1][temp[2]] == 0) {
							box[temp[0]][temp[1] +1][temp[2]] = 1;
							grown ++;
							undergrown --;
							tomato.add(new int [] {temp[0],temp[1] +1,temp[2]});
						}				
					}
					// 아래에 있는 토마토
					if (temp[1] -1 >= 0) {
						if (box[temp[0]][temp[1] -1][temp[2]] == 0) {
							box[temp[0]][temp[1] -1][temp[2]] = 1;
							grown ++;
							undergrown --;
							tomato.add(new int [] {temp[0],temp[1] -1,temp[2]});
						}				
					}
					// 오른쪽에 있는 토마토
					if (temp[2] + 1 < M) {
						if (box[temp[0]][temp[1]][temp[2] +1] == 0) {
							box[temp[0]][temp[1]][temp[2] +1] = 1;
							grown ++;
							undergrown --;
							tomato.add(new int [] {temp[0],temp[1],temp[2] +1});
						}				
					}
					// 왼쪽에 있는 토마토
					if (temp[2] -1 >= 0) {
						if (box[temp[0]][temp[1]][temp[2] -1] == 0) {
							box[temp[0]][temp[1]][temp[2] -1] = 1;
							grown ++;
							undergrown --;
							tomato.add(new int [] {temp[0],temp[1],temp[2] -1});
						}				
					}
				}
			}
			
			if (undergrown == 0) {
				System.out.println(day);
			} else {
				System.out.println(-1);
			}
		}
		
	}
	
}
