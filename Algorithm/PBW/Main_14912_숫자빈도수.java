package algo0408;

import java.util.Scanner;

public class Main_14912_숫자빈도수 {
	// boj Silver5
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		
		int result = 0;
		for (int i = 1; i < n+1; i++) {
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) - '0' == d) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
