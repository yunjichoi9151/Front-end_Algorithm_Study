package algo0408;

import java.util.Scanner;

public class Main_2193_이친수 {
	// boj Silver3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long [100];
		
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i < N+1; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[N]);
	}
}
