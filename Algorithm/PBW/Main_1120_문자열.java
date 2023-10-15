package algo0408;

import java.util.Scanner;

public class Main_1120_문자열 {
	// boj Silver4
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i <= B.length() - A.length(); i++) {
			int temp = 0;
			for (int j = i; j < i + A.length(); j++) {
				if (B.charAt(j) != A.charAt(j-i)) {
					temp ++;
				}
			}
			if (temp < result) {
				result = temp;
			}
		}
		
		System.out.println(result);
	}
}
