import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 공을 던지는 횟수 1 ≤ N ≤ 4
			W = sc.nextInt(); // 맵의 가로크기 2 ≤ W ≤ 12
			H = sc.nextInt(); // 맵의 세로크기 2 ≤ H ≤ 15
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			}
			ans = 987654321;
			dfs(map, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	// 모든 경우에 대해 공을 떨궈보는 재귀함수
	static void dfs(int[][] map, int cnt) {
		//공다 쐈다.
		if (cnt == N) {
			ans = Math.min(ans, getCnt(map));
			return;
		}

		for (int j = 0; j < W; j++) {
			//현재 맵에 떨어뜨려서 맵을 변질시키면 X 복사해서 사용
			int[][] copy = new int[H][W];
			deepCopy(map, copy);
			// 공발사!
			for (int i = 0; i < H; i++) {
				if (copy[i][j] != 0) { //벽돌이라면
					boom(copy, i, j);
					break;
				}
			}
			gravity(copy);
			dfs(copy, cnt+1);
		}
	}

	// 특정 벽돌위치를 지정했을때 지워지는 모든 벽돌을 탐색하는 함수
	static void boom(int[][] map, int h, int w) {
		if (h < 0 || w < 0 || h >= H || w >= W) return;

		int range = map[h][w];
		map[h][w] = 0; //폭발
		//사방향으로 퍼뜨리기 (1은 필요없음)
		for (int i = 1; i < range; i++) {
			boom(map, h, w + i);
			boom(map, h, w - i);
			boom(map, h + i, w);
			boom(map, h - i, w);
		}
	}

	// 아래로 밀착시키는 함수
	static void gravity(int[][] map) {
		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] == 0) {
					// 현재 열의 현재 행 위로 이동 0이 아닌애를 발견할때까지.
					for (int k = i; k >= 0; k--) {
						if (map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	// 깊은 복사
	static void deepCopy(int[][] origin, int[][] copy) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}

	// 현재 벽돌의 갯수를 세는 함수
	static int getCnt(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}
}
