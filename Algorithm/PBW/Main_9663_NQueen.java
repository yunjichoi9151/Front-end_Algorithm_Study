package algo0408;

import java.io.*;
import java.util.*;

public class Main_9663_NQueen {
	// boj Gold4
	
	static int N, result;
	static boolean map [][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		map = new boolean [N][N];
		result = 0;
		
		chess(0,0);
		System.out.println(result);
	}
	
	private static void chess(int queen, int x) {
		// 갯수만큼 퀸을 다 두었다면 탈출
		if (queen == N) {
			result ++;
			return;
		}
		// 체스판의 마지막 칸이면 탈출
		if (x == N) {
			return;
		}
		
		for (int y = 0; y < N; y++) {
			
			boolean check = true;
			// 퀸의 이동가능 위치가 비어있는지 체크
			for (int i = 0; i < N; i++) {
				// 세로에 퀸이 있는지 체크
				if (i < x) {
					if (map[i][y]) {
						check = false;
						break;
					}
				}
				// 가로에 퀸이 있는지 체크
				// 대각 방향 퀸 체크 사전 조건
				if (i != 0) {
					// 왼쪽 위 대각에 퀸이 있는지 체크
					if (x - i >= 0 && y - i >= 0) {
						if (map[x-i][y-i]) {
							check = false;
							break;
						}
					}
					// 오른쪽 위 대각에 퀸이 있는지 체크
					if (x - i >= 0 && y + i < N) {
						if (map[x-i][y+i]) {
							check = false;
							break;
						}
					}
					// 아래 대각 방향은 퀸이 없다
				}
			}
			
	//		// 검토
	//		System.out.println("x : " + x + " y : " + y + " check : " + check);
			
			// 퀸을 둘 수 있는 곳이므로 퀸 두기
			if (check) {
				map[x][y] = true;
				chess(queen+1, x+1);
				map[x][y] = false;
			}
		
		}
	}
}
