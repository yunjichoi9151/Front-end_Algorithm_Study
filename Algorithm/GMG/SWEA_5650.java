import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
	static int[][] map;
	static int N, ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] change = { { 0, 1, 2, 3 }, // 상하좌우
			{ 1, 3, 0, 2 }, // 하우상좌
			{ 3, 0, 1, 2 }, // 우상하좌
			{ 2, 0, 3, 1 }, // 좌상우하
			{ 1, 2, 3, 0 }, // 하좌우상
			{ 1, 0, 3, 2 } // 하상우좌
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 0;

			map = new int[N + 2][N + 2]; // 벽을 5번으로 둘러싸기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 범위를 벗어나면 방햐이 반대가 되므로 5번으로 감싸자.
			for (int i = 0; i <= N + 1; i++) {
				map[i][0] = map[i][N + 1] = map[0][i] = map[N + 1][i] = 5;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 빈칸에서
					if (map[i][j] == 0) {
						// 모든바향 출발
						for (int d = 0; d < 4; d++) {
							game(i, j, d);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // tc
	}// main

	static void game(int stR, int stC, int dir) {
		int r = stR;
		int c = stC;

		int score = 0;

		while (true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 시작지점으로 돌아왔거나 블랙홀이면 종료
			if ((nr == stR && nc == stC) || map[nr][nc] == -1) {
				if (ans < score)
					ans = score;
				return;
			}

			if (map[nr][nc] > 0) {
				// 블록이라면 점수 증가후 방향 변경
				if (map[nr][nc] < 6) {
					dir = change[map[nr][nc]][dir];
					score++;
				}
				// 웜홀 출구찾기
				else {
					outer: for (int i = 1; i <= N; i++) {
						for (int j = 1; j <= N; j++) {
							if ((nr != i || nc != j) && map[i][j] == map[nr][nc]) {
								nr = i;
								nc = j;
								break outer;
							}

						}
					}
				}
			}
			r = nr;
			c = nc;

		} // while
	}

}
