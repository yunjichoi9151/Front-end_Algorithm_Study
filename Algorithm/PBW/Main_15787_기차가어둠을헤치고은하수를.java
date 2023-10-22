package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15787_기차가어둠을헤치고은하수를 {
	// boj Silver2
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] train = new int [N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int num;
			int seat;
			
			switch (command) {
			case 1:
				num = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());
				
				train[num] = train[num] | (1 << seat);
				break;
			case 2:
				num = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());
				
				train[num] = train[num] & ~(1 << seat);
				break;
			case 3:
				num = Integer.parseInt(st.nextToken());
				train[num] = train[num] << 1;
				train[num] = train[num] & ((1 << 21)-1);
				break;
			case 4:
				num = Integer.parseInt(st.nextToken());
				train[num] = train[num] >> 1;
				train[num] = train[num] & ~1;				
				break;
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(train[i]);
		}
		
		System.out.println(set.size());
	}
	
}
