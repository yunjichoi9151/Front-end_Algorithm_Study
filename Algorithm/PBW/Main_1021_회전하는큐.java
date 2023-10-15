package algo0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {
	// boj Silver3
	
	static int N, M;
	static LinkedList<Integer> deque = new LinkedList<>();
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		for (int i = 0; i < M; i++) {
			if (check(num[i])) {
				while (num[i]!=deque.get(0)) {
					deque.addLast(deque.pollFirst());
					count++;
				}
			} else {
				while (num[i]!=deque.get(0)) {
					deque.addFirst(deque.pollLast());
					count++;
				}
			}
			deque.poll();
		}
		
		System.out.println(count);
	}
	
	public static boolean check(int a) {
		for (int i = 0; i <= deque.size()/2; i++) {
			if (a == deque.get(i)) {
				return true;
			}
		}
		return false;
	}
}
