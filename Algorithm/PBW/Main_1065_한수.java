package algo0408;

import java.util.*;

public class Main_1065_한수 {
	//boj Silver4
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			String num = String.valueOf(i);
			int arr [] = new int [num.length()];
			boolean check = true;
			for (int j = 0; j < num.length(); j++) {
				arr[j] = num.charAt(j) - 48;
				if (j-2 >= 0) {
					if (arr[j-2] - arr[j-1] != arr[j-1] - arr[j]) {
						check = false;
					}
				}
			}
			if (check) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
