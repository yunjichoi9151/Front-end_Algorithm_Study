import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_2383_점심식사시간 {
	static class Person implements Comparable<Person> {
		int r, c;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
			dist = new int[2];// 계단이 항상ㅋ 두개
		}

		int[] dist;
		int sel;// 선택되는 계단

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return dist[sel] - o.dist[o.sel];
		}
	}

	static class Stair {
		int r, c, height;

		public Stair(int r, int c, int height) {
			this.r = r;
			this.c = c;
			this.height = height;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			// N*N을 순회하면서, 입력받고.
			// 계단일 경우 계단의 위치(행,열)와 깊이를 기억 → 계단 하나를 위해 정수 세개가 필요 → 객체로 처리해봅시다
			// 사람일 경우 위치를 기억

			int sCnt = 0;
			Stair[] stairs = new Stair[2];
			int pCnt = 0;
			Person[] person = new Person[10];// 사람은 최대 10명 주어짐
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 0)
						continue;
					else if (map[i][j] == 1) {
						// 사람 입력받기
						person[pCnt++] = new Person(i, j);
					} else {
						// 계단!
						stairs[sCnt] = new Stair(i, j, map[i][j]);
						sCnt++;
					}
				}
			}

			// 각 사람별 계단별 거리를 구해주자.
			for (int i = 0; i < pCnt; i++) {
				for (int j = 0; j < sCnt; j++) {
					person[i].dist[j] = Math.abs(person[i].r - stairs[j].r) + Math.abs(person[i].c - stairs[j].c) + 1;
				}
			}
			ans = 987654321;
			powerSet(person, stairs, 0, pCnt);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	static void powerSet(Person[] person, Stair[] stairs, int idx, int pCnt) {
		if (idx == pCnt) {
			// 모든 사람에 대해서 계단 배정 완료
			int[][] stairTimeTable = new int[2][200];
			// 각 계단별로 먼저온놈순서로 위 타임테이블에 계단에 머무는 시간을 적어보기 위한 큐
			PriorityQueue<Person>[] stairQueue = new PriorityQueue[2];
			stairQueue[0] = new PriorityQueue<>();
			stairQueue[1] = new PriorityQueue<>();
			for (int i = 0; i < pCnt; i++) {
				// 자신이 배정된 계단의 큐에 추가
				stairQueue[person[i].sel].add(person[i]);
			}
			int max = 0;
			for (int i = 0; i < stairs.length; i++) {
				// 해당 사람이 타임테이블에서 끝나는 시간
				int to = 0;

				// 각 계단의 큐에서 사람을 하나씩 모두 꺼냄
				while (!stairQueue[i].isEmpty()) {
					Person p = stairQueue[i].poll();
					int from = p.dist[p.sel]; // 선택된 계단까지의 거리부터 계단을 내려가기 시작
					to = from + stairs[p.sel].height; // 도착으로부터 계단의 높이만큼의 시간동안 계단에 머뭄
					for (int j = from; j < to; j++) {
						if (stairTimeTable[p.sel][j] == 3) {
							// 3명이면 꽉찼으므로, 기록하지 않고 다음 시간으로 이동
							to++;
							continue;
						}
						stairTimeTable[p.sel][j]++;// 계단시간테이블의 내가 내려가는 계단의 시간에 사람이 있음을 추가
					}
				}
				if (max < to)
					max = to;

			}
			if (ans > max)
				ans = max;
			return;
		}
		// 0번계단 배정 후 호출
		person[idx].sel = 0;
		powerSet(person, stairs, idx + 1, pCnt);
		// 1번계단 배정 후 호출
		person[idx].sel = 1;
		powerSet(person, stairs, idx + 1, pCnt);
	}
}
