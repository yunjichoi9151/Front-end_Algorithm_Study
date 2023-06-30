package algo0408;

import java.util.*;

public class Main_1789_수들의합 {
	// boj Silver5
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		
		int result = 1;
		int num = 1;
		while(true) {
			long temp = S - num;
			if (temp <= num) {
				break;
			} else {
				S = temp;
				num ++;
				result ++;
			}
		}
		
		System.out.println(result);
	}
}
