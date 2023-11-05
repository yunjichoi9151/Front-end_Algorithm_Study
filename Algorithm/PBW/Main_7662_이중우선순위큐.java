package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main_7662_이중우선순위큐 {
	// boj Gold4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
				
		for (int t = 0; t < T; t++) {
			PriorityQueue<Integer> minPq = new PriorityQueue<>();
			PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();	
			
			int Q = Integer.parseInt(br.readLine());
			for (int i = 0; i < Q; i++) {
				String str = br.readLine();
				char command = str.charAt(0);
				int num = Integer.parseInt(str.split(" ")[1]);
				
				if (command == 'I') {
					minPq.add(num);
					maxPq.add(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
					continue;
				}
				
				if (!map.isEmpty()) {
					if (num == -1) {
						remove(minPq,map);
					} else {
						remove(maxPq,map);
					}					
				}
			}
			
			if (map.isEmpty()) {
				bw.append("EMPTY\n");
			} else {
				int max = print(maxPq,map);
				int min = print(minPq,map);
				bw.append(max + " " + min + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
				
	}

	private static int print(PriorityQueue<Integer> Pq, Map<Integer, Integer> map) {
		int cnt;
		while(true) {
			cnt = Pq.poll();
			if (map.getOrDefault(cnt,0) > 0) {
				return cnt;
			}
		}
	}

	private static void remove(PriorityQueue<Integer> Pq, Map<Integer, Integer> map) {
		int cnt;
		while(true) {
			cnt = Pq.poll();
			if (map.getOrDefault(cnt,0) > 0) {
				if (map.get(cnt) > 1) {
					map.put(cnt, map.get(cnt) - 1);					
				} else {
					map.remove(cnt);
				}
				return;
			}
		}
	}
}
