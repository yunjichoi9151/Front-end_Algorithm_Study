package algo0408;

import java.util.Scanner;

public class Main_10101_삼각형외우기 {
	// boj Bronze4
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if (A+B+C == 180) {
			if (A == B && B == C) {
				System.out.println("Equilateral");
			} else if (A == B || B == C || C == A) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		} else {
			System.out.println("Error");
		}
	}
}
