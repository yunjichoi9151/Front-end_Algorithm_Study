import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기2 {
	static class Pos {
		int r, c, cnt;

		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, W, H, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			}
			min = 987654321;
			go(0, map);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void go(int cnt, int[][] map) {
		if (cnt == N) {
			min = Math.min(min, getCnt(map));
			return;
		}
		int[][] newMap = new int[H][W];
		for (int j = 0; j < W; ++j) { // 매열마다 구슬 떨어드리는 시도.
			deepCopy(map, newMap);
			// 구슬을 떨어뜨리면 맞는 벽돌이 있는 행 찾기
			for (int i = 0; i < H; i++) {
				if (newMap[i][j] != 0) { // 벽돌이라면
					boom(newMap, i, j);
					break;
				}
			}
			// 터트리는 시도하기 전에 직전 count횟수까지의 맵 상태를 이용하여 배열 복사하여 초기화
			gravity(newMap);
			go(cnt + 1, newMap);
		}
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Pos> queue = new LinkedList<Pos>();
		if (map[r][c] > 1) { // 주변 영향 미치는 벽돌이면 터지는 시작점으로 큐에 넣기
			queue.offer(new Pos(r, c, map[r][c]));
		}
		map[r][c] = 0; // 자신은 제거 처리
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			for (int d = 0; d < 4; ++d) {
				int nr = p.r, nc = p.c;
				for (int k = 1; k < p.cnt; ++k) {// 자신의 숫자-1만큼 제거처리할 벽돌 큐에 넣기
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if (map[nr][nc] > 1) {
							queue.offer(new Pos(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
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

	// 깊은 복사
	static void deepCopy(int[][] origin, int[][] copy) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}
}
