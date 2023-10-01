package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_20164_홀수홀릭호석 {
	// boj Gold5
	
	static int max_result = 0;
	static int min_result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
//		String str = "123456789";
//		System.out.println(str.substring(0, 1));
		odd(N,0);
		System.out.println(min_result + " " + max_result);
	}

	private static void odd(String N, int sum) {
		int size = N.length();
		int num = Integer.parseInt(N);
		
		// 홀수 더하기
		for (int i = 0; i < size; i++) {
			if ((N.charAt(i) - '0') % 2 == 1) {
				sum++;
			}
		}
		
		// 1자리수
		if (size == 1) {
			if (sum > max_result) {
				max_result = sum;
			}
			if (sum < min_result) {
				min_result = sum;
			}
			return;
		}
		
		// 2자리수
		if (size == 2) {
			String temp = String.valueOf(num / 10 + num % 10);
			odd(temp, sum);
		}
		
		// 3자리수 이상
		if (size >= 3) {
			for (int i = 0; i < size - 2; i++) {
				for (int j = i+1; j < size - 1; j++) {
					int a = Integer.parseInt(N.substring(0, i+1));
					int b = Integer.parseInt(N.substring(i+1, j+1));
					int c = Integer.parseInt(N.substring(j+1, size));
					odd(String.valueOf(a+b+c), sum);
				}
			}
		}
	}
}
