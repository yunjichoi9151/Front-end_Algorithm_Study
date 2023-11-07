package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	// boj Gold5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int [N+1][N+1];
		int INF = 100000000;
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if (map[start][end] > cost) {
				map[start][end] = cost;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] root = new int [N+1];
		boolean[] check = new boolean [N+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		for (int i = 1; i < N+1; i++) {
			root[i] = map[A][i];
		}
		root[A] = 0;
		
		pq.add(new int[] {A,root[A]});
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			if (check[temp[0]]) {
				continue;
			}
			pq.clear();
			check[temp[0]] = true;			
			
			for (int i = 1; i < N+1; i++) {
				if (map[temp[0]][i] + temp[1] < root[i]) {
					root[i] = map[temp[0]][i] + temp[1];
				}
				pq.add(new int[] {i,root[i]});
//				System.out.print(root[i] + " ");
			}
//			System.out.println();
		}
		
		System.out.println(root[B]);
//		// 플루이드 워샬 (시간초과)
//		for (int i = 1; i < N+1; i++) {
//			for (int j = 1; j < N+1; j++) {
//				for (int k = 1; k < N+1; k++) {
//					if (j == k) {
//						map[j][k] = 0;
//						continue;
//					}
//					if (map[j][i] != -1 && map[i][k] != -1) {
//						map[j][k] = map[j][k] == -1 ? map[j][i] + map[i][k] : Math.min(map[j][k], map[j][i] + map[i][k]);
//					}
//				}
//			}
//		}
//		
//		System.out.println(map[A][B]);
	}
}
