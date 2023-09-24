package algo0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1269_대칭차집합 {
	// boj Silver4
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int check = set.size();
		int all = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			set.add(Integer.parseInt(st.nextToken()));
			if (check == set.size()) {
				all ++;
			} else {
				check ++;
			}
		}
		
		System.out.println(set.size() - all);
	}
}
