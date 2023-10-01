package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1235_학생번호 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String [N];
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		int line = arr[0].length();
		int result = 0;
		while (true) {
			result++;
			
			for (int i = 0; i < N; i++) {
				set.add(arr[i].substring(line - result));
			}
			
			if (set.size() == N) {
				break;
			} else {
				set.clear();
			}
		}
		
		System.out.println(result);
	}
}
