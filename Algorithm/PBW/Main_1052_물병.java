package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052_물병 {
	// boj Silver1
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = 0;
		if (bitcount(N) <= K) {
			System.out.println(0);
		} else {
			while (bitcount(N+result) > K) {
				result++;
			}
			System.out.println(result);
		}
	}

	private static int bitcount(int n) {
		if (n == 0) {
			return 0;
		}
		
		return n % 2 + bitcount(n / 2);
	}

}
