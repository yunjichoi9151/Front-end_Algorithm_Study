package algo0408;

import java.util.Scanner;

public class Main_9506_약수들의합 {
	// boj Bronze1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			
			if (n == -1) {
				break;
			}
			
			String result = n + " = 1";
			int check = 1;
			
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					check += i;
					result += " + " + i;
				}
			}
			
			if (check == n) {
				System.out.println(result);
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}
	}
}
