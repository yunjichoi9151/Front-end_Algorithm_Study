package algo;

import java.io.*;
import java.util.*;

public class Main_2346_풍선터트리기 {
	// boj Silver3
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> balloon = new HashMap<>();
		Deque<Integer> deque = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			deque.add(i);
			balloon.put(i, Integer.parseInt(st.nextToken()));
		}
		
		while (!deque.isEmpty()) {
			int temp = deque.poll();
			bw.append(temp + " ");
			if (deque.isEmpty()) {
				break;
			}
			
			boolean direct = true;
			if (balloon.get(temp) < 0) {
				direct = false;
			}
			int move = Math.abs(balloon.get(temp));
			
			if (direct) {
				for (int i = 1; i < move; i++) {
					deque.addLast(deque.pollFirst());
				}
			} else {
				for (int i = 0; i < move; i++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
