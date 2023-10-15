package algo0408;

import java.util.Scanner;

public class Main_1439_뒤집기 {
	// boj Silver5
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int zero = 0;
		int one = 0;
		
		if (str.charAt(0) == '1') {
			one++;
		} else {
			zero++;
		}
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				if (str.charAt(i-1) != '1') {
					one++;
				}
			} else {
				if (str.charAt(i-1) != '0') {
					zero++;
				}
			}
		}
		
		System.out.println(one > zero ? zero : one);
	}
}
