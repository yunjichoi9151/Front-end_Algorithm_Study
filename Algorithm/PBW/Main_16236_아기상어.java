package algo;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {
	// boj Gold3
	static int N;
	static int map [][];
	static boolean check [][];
	static int x_move [] = {-1,0,0,1};
	static int y_move [] = {0,-1,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		check = new boolean [N][N];
		shark baby = new shark();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					baby.x = i;
					baby.y = j;
					map[i][j] = 0;
					check[i][j] = true;
				}
			}
		}
		
		bfs(baby);
	}
	
	private static void bfs(shark baby) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int [] {baby.x,baby.y});
		// 생선 최단거리 위치를 찾는 우선순위큐
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			};
		});
		int distance = 1;
		
		while (true) {
			int cnt = queue.size();
			
			while (cnt-- > 0) {
				int [] temp = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = temp[0] + x_move[i];
					int y = temp[1] + y_move[i];
					if (check(x,y,baby.size)) {
						// 먹을 수 있는 물고기가 있는지 체크
						if (map[x][y] > 0 && map[x][y] < baby.size) {
							pq.add(new int [] {x,y});
						} else {
							check[x][y] = true;
							queue.add(new int [] {x,y});
						}
					}
				}
			}
			
			if (!pq.isEmpty()) {
				int[] fish = pq.poll();
				baby.eat();
				baby.move += distance;
				distance = 1;
				baby.x = fish[0];
				baby.y = fish[1];
				pq.clear();
				queue.clear();
				baby.check_reset();
				map[fish[0]][fish[1]] = 0;
				queue.add(new int[] {baby.x,baby.y});
//				baby.map();
			} else if (queue.isEmpty()) {
				break;
			} else {
				distance++;
			}
		}
		
		System.out.println(baby.move);
		
	}
	
	// map 바깥인지, 지나온 길인지 체크
	private static boolean check(int x, int y, int size) {
		if (x >= 0 && x < N && y >= 0 && y < N && !check[x][y] && map[x][y] <= size) {
			return true;
		}
		return false;
	}
	
	// 상어 클래스
	static class shark {
		int size;
		int storage;
		int move;
		int x,y;
		
		public shark() {
			this.size = 2;
			this.storage = 0;
			this.move = 0;
		}
		
		// 먹이를 먹으면 몸집이 커진다
		public void eat() {
			storage++;
			if (storage == size) {
				size++;
				storage = 0;
			}
		}
		
		public void check_reset() {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = false;
				}
			}
			check[x][y] = true;
		}
		
		public void map() {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.print("이동거리:"+move + " 몸집"+size);
			System.out.println();
		}
	}
}
