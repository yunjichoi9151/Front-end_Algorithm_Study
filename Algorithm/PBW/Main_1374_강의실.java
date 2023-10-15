package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1374_강의실 {
	// boj Gold5
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 수업의 시작시간과 종료시간을 담은 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		// 강의실의 종료시간을 담은 우선순위 큐
		PriorityQueue<Integer> cnt = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new int[] {start,end});
		}
		
		cnt.add(0);
		while (!pq.isEmpty()) {
			int room[] = pq.poll();
			// 가장 빨리 끝나는 수업의 종료시간을 가져온다
			int endTime = cnt.poll();
			
			// 수업의 시작시간과 가장 빨리 끝나는 수업의 종료시간 비교
			if (endTime <= room[0]) {
				// 수업 종료 후에 시작하면 강의실을 추가 안함, 늦게 끝나는 수업 종료 시간을 넣음
				cnt.add(room[1]);
			} else {
				// 수업 종료 전에 시작하면 강의실을 추가함, 각각의 수업 종료 시간을 넣음
				cnt.add(endTime);
				cnt.add(room[1]);
			}
			
//			System.out.println(room[0]+ " " + room[1] + " " + endTime);
		}
		
		System.out.println(cnt.size());
		
		// 1안 : 10억짜리 배열은 공간이 터져서 실패
//		int[] time = new int [1000000001];
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int num = Integer.parseInt(st.nextToken());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			
//			for (int j = start; j < end; j++) {
//				time[j]++;
//			}
//		}
//		
//		int result = 0;
//		for (int i = 0; i < 1000000001; i++) {
//			if (time[i] > result) {
//				result = time[i];
//			}
//		}
//		
//		System.out.println(result);
	}

}
