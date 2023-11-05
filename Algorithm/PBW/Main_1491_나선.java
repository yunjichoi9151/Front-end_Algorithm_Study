package algo0408;

import java.util.Scanner;

public class Main_1491_나선 {
	// boj Silver4
	
	static int N,M;
	static int[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int [N][M];
		
		map[N-1][0] = 0;
		twist(N-1,0);
	}

	private static void twist(int start_x, int start_y) {
		int x = start_x;
		int y = start_y;
		int locate = 0;
		while (true) {
//			System.out.println(x + " " + y);
			while (x >= 0 && x < N && y >= 0 && y < M && map[x][y] == 0) {
				map[x][y] = 1;
				x += dx[locate];
				y += dy[locate];
//				System.out.println(x + " " + y);
			}
			
			x -= dx[locate];
			y -= dy[locate];
			
			if (locate == 3) {
				locate = 0;
				x += dx[0];
				y += dy[0];
			} else {
				locate++;
				x += dx[locate];
				y += dy[locate];
			}
			
			if (map[x][y] == 1) {
				x -= dx[locate];
				y -= dy[locate];
				break;
			}
		}
		
		System.out.println(x + " " + y);
	}
}
