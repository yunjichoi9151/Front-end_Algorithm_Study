package algo0408;

import java.util.Scanner;

public class Main_1934_최소공배수 {
	// boj Bronze1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int big = 0;
			int small = 0;
			if (A > B) {
				big = A;
				small = B;
			} else {
				big = B;
				small = A;
			}
			
			int GCD = 0;
			while (true) {
				if (big % small == 0) {
					GCD = small;
					break;
				}
				
				int temp = big % small;
				big = small;
				small = temp;
			}
			
//			int result = 0;
//			for (int j = A; j <= 45000; j++) {
//				if (j % A == 0 && j % B ==0) {
//					result = j;
//					break;
//				}
//			}
			
			System.out.println(A*B/GCD);
		}
	}
}
