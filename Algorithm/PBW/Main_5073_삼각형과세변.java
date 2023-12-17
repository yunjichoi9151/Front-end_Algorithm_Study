package algo0408;

import java.util.Arrays;
import java.util.Scanner;

public class Main_5073_삼각형과세변 {
	// boj Bronze3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			if (arr[0] + arr[1] + arr[2] == 0) {
				break;
			}
			
			if (arr[0] + arr[1] <= arr[2]) {
				System.out.println("Invalid");
				continue;
			}
			
			if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[0]) {
				System.out.println("Equilateral ");
			} else if (arr[0] != arr[1] && arr[1] != arr[2] && arr[2] != arr[0]) {
				System.out.println("Scalene");
			} else {
				System.out.println("Isosceles ");
			}
		}
	}
}
