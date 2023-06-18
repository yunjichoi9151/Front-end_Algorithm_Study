package algo0408;

import java.util.*;

public class Main_2581_소수 {
	// boj Bronze2
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int result_sum = 0;
		int result = 0;
		int [] arr = new int [10001];
		for (int i = 1; i < 10001; i++) {
			arr[i] = i;
		}
		for (int i = 2; i < 10001; i++) {
			if (arr[i] != 0) {
				if (i >= M && i <= N) {
					if (result == 0) {
						result = i;
					}
					result_sum += i;
				}
				for (int j = 2; j*i < 10001; j++) {
					arr[j*i] = 0;
				}
			}
		}
		if (result == 0) {
			System.out.println(-1);
		} else {			
			System.out.println(result_sum);
			System.out.println(result);
		}
	}
}
