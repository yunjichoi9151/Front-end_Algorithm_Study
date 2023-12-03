package algo0408;

import java.util.Scanner;

public class Main_20492_세금 {
	// boj Bronze5
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(N / 100 * 78 + " " + (N / 100 * 80 + N / 100 * 20 / 100 * 78));
	}
}
