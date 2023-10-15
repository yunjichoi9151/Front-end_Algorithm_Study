package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16938_캠프준비 {
	// boj Gold5
	
	static int N,L,R,X;
	static int result = 0;
	static int[] quiz;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		quiz = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			quiz[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int j = 2; j <= N ; j++) {
//				System.out.print(i + " " + j + " ");
			comb(0,j,0,Integer.MAX_VALUE,0,0);
		}
		
		System.out.println(result);
	}

	private static void comb(int start, int num, int cnt, int low, int high, int sum) {
		if (cnt == num) {
			if (high - low >= X && sum >= L && sum <= R) {
//				System.out.println(num + " " + (high-low) + " " + sum + " " + result);
				result++;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			int low_temp = low;
			int high_temp = high;
			if (quiz[i] < low_temp) {
				low_temp = quiz[i];
			}
			if (quiz[i] > high_temp) {
				high_temp = quiz[i];
			}
			comb(i+1,num, cnt+1, low_temp, high_temp, sum+quiz[i]);
		}
	}
	
}
