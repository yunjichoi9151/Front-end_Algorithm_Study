package algo0408;

import java.util.Scanner;

public class Main_12927_배수스위치 {
	// boj Silver4
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int cnt = str.length();
		char[] arr = new char [cnt+1];
		
		for (int i = 0; i < cnt; i++) {
			arr[i+1] = str.charAt(i);
		}
		
		int result = 0;
		for (int i = 1; i < cnt+1; i++) {
			if (arr[i] == 'Y') {
				result++;
				for (int j = 1; j * i < cnt + 1; j++) {
					arr[j*i] = arr[j*i] == 'N' ? 'Y' : 'N';
				}
			}
		}
		
		System.out.println(result);
	}
}
