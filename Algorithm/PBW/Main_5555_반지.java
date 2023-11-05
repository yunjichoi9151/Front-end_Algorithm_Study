package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5555_반지 {
	// boj Silver5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		int num = str.length();
		for (int i = 0; i < N; i++) {
			String ring = br.readLine();
			String temp = ring.substring(0, num);
			ring += temp;
			
			if (ring.contains(str)) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
