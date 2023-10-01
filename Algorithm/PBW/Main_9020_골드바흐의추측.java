package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9020_골드바흐의추측 {
	// boj Silver2
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] sosu = new boolean [10001];
		
		for (int i = 2; i < 5001; i++) {
			if (!sosu[i]) {
				int num = 2;
				while (num * i < 10001) {
					sosu[i*num] = true;
					num++;
				}
			}
		}
		
//		for (int i = 0; i < 10001; i++) {
//			if (!sosu[i]) {
//				System.out.println(i);
//			}
//		}
		for (int t = 0; t < n; t++) {
			int number = Integer.parseInt(br.readLine());
			int a = 0;
			int b = 0;
			for (int i = 2; i <= number / 2; i++) {
				if (!sosu[i] && !sosu[number-i]) {
					a = i;
					b = number - i;
				}
			}
			System.out.println(a + " " + b);
		}
	}
}
