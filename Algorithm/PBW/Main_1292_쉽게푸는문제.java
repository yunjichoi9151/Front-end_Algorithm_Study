package algo;

import java.util.Scanner;

public class Main_1292_쉽게푸는문제 {
	// boj Bronze1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int [] arr = new int [1001];
		int result_num = 1;
		int num = 0;
		int sum = 0;
		for (int i = 1; i < 1001; i++) {
			if (num < result_num) {
				sum += result_num;
				num++;
			} else {
				result_num ++;
				num = 1;
				sum += result_num;
			}
			arr[i] = sum;
//			System.out.println(arr[i]);
		}
		System.out.println(arr[B]-arr[A-1]);
	}
}
