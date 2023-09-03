package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_25192_인사성밝은곰곰이 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			if (temp.equals("ENTER")) {
				result += set.size();
				set.clear();
			} else {
				set.add(temp);
			}
		}
		
		result += set.size();
		System.out.println(result);
	}
}
