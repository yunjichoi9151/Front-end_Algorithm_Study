package algo;

import java.util.*;

public class Main_1193_분수찾기 {
	// boj Silver5
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		int N = 0;
		int weight = 1;
		while(true) {
			if (N < X) {
				N += weight;
			} else {
				break;
			}
			weight++;
		}
		
		for (int i = 1; i < weight; i++) {
			if (weight - i - 1 == N - X) {
				if (weight % 2 == 0) {
					System.out.println((weight-i) + "/" + i);	
				} else {
					System.out.println(i + "/" + (weight-i));					
				}
			}
		}
	}
}
