package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {
	// boj Gold5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] belt = new int [N*2][2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N*2; i++) {
			belt[i][1] = Integer.parseInt(st.nextToken());
//			System.out.println(belt[i][0] + " " + belt[i][1]);
		}
		
		int result = 0;
		while (true) {
			result++;
			
			// 1. 벨트 회전
			int temp = belt[N*2-1][1];
			for (int i = N*2-1; i > 0; i--) {
				belt[i][0] = belt[i-1][0];
				belt[i][1] = belt[i-1][1];
			}
				// 벨트 시작점
			belt[0][1] = temp;
			belt[0][0] = 0;
				// 상자가 벨트끝에 도착하면 삭제
			belt[N-1][0] = 0;
			
			// 2. 로봇 이동
			for (int i = N - 2; i >= 0; i--) {
				if (belt[i][0] == 1 && belt[i+1][0] != 1 && belt[i+1][1] != 0) {
					belt[i][0] = 0;
					belt[i+1][0] = 1;
					belt[i+1][1]--;
				}
			}
			belt[N-1][0] = 0;
			
			// 3. 로봇 생성
			if (belt[0][1] != 0) {
				belt[0][0] = 1;
				belt[0][1]--;
			}
			
			// 4. 과정 종료
			int destroy = 0;
			for (int i = 0; i < N*2; i++) {
				if (belt[i][1] == 0) {
					destroy++;
				}
			}
			if (destroy >= K) {
				break;
			}
			
			// 컨베이어 벨트 확인
//			for (int i = 0; i < N*2; i++) {
//				System.out.print(belt[i][1] + " ");
//			}
//			System.out.print(destroy);
//			System.out.println();
		}
		System.out.println(result);
	}
}
