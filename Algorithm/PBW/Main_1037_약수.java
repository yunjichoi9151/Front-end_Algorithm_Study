package algo;

import java.util.*;

public class Main_1037_약수 {
	// boj Bronze1
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int [] arr = new int [cnt];
		
		for (int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(arr[0] * arr[cnt-1]);
	}
	
}
