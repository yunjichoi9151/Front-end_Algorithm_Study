package algo0408;

import java.util.Scanner;

public class Main_1057_토너먼트 {
	// boj Silver4
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int human = sc.nextInt();
		int jimin = sc.nextInt();
		int hansu = sc.nextInt();
		
		int round = 0;

		while (!(jimin == hansu)) {
			round++;
			if (jimin % 2 == 0) {
				jimin /= 2;
			} else {
				jimin = jimin / 2 + 1;
			}
			if (hansu % 2 == 0) {
				hansu /= 2;
			} else {
				hansu = hansu / 2 + 1;
			}
		}
		
		System.out.println(round);
	}
}
