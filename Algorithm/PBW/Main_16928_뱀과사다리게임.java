package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
	// boj Gold5
	
	static int N,M,result;
	static HashMap<Integer, Integer> map;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		check = new boolean [101];
		result = 0;
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
//		dfs(1,0);
		bfs(new int[] {1,0});
		
		System.out.println(result);
	}

	private static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] player = queue.poll();
				
				// 100에 도달하면 탈출
				if (player[0] == 100) {
					result = player[1];
					return;
				}
				
				for (int j = 1; j <= 6; j++) {
					int num;
					if (map.containsKey(player[0]+j)) {
						num = map.get(player[0] + j);						
					} else {
						num = player[0] + j;						
					}
					int sum = player[1];
					
					if (num <= 100 && !check[num]) {
						check[num] = true;
						queue.add(new int[] {num, sum+1});
					}
				}
			}
		}
	}

//	private static void dfs(int start, int sum) {
//		System.out.println("현재위치:"+start);
//		// 100번째 칸에 도달하면 끝
//		if (start == 100) {
//			result = sum < result ? sum : result;
//			return;
//		}
//		
//		// 경우의수 줄이기
//		if (sum > result) {
//			return;
//		}
//		
//		for (int i = 1; i <= 6; i++) {
//			if (start + i <= 100 && !check[start+i]) {
//				if (map.containsKey(start+i) && !check[map.get(start+i)]) {
//					linetrue(start);
//					dfs(map.get(start+i), sum+1);
//					linefalse(start);						
//				} else {
//					linetrue(start);
//					dfs(start+i, sum+1);
//					linefalse(start);
//				}
//			}	
//		}
//	}
//
//	private static void linefalse(int start) {
//		for (int i = 1; i <= 6; i++) {
//			if (start+i < 101) {
//				check[start+i] = false;				
//			}
//			if (map.containsKey(start+i)) {
//				check[map.get(start+i)] = false;
//			}
//		}
//		
//	}
//
//	private static void linetrue(int start) {
//		for (int i = 1; i <= 6; i++) {
//			if (start+i < 101) {
//				check[start+i] = true;				
//			}
//			if (map.containsKey(start+i)) {
//				check[map.get(start+i)] = true;
//			}
//		}
//	}
}
