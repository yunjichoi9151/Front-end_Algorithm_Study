package algo0408;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2587_대표값2 {
	// boj Bronze2
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int [5];
		int avg = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
			avg += arr[i];
		}
		
		Arrays.sort(arr);
		System.out.println(arr[2]);
		System.out.println(avg/5);
	}
}
