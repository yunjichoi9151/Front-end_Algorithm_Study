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
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
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
			int endTime = cnt.poll();
		
			if (endTime <= room[0]) {
				cnt.add(room[1]);
			} else {
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
