package algo0408;

import java.util.Scanner;
import java.util.Stack;

public class Main_10799_쇠막대기 {
	// boj Silver2
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> stick = new Stack<>();
		
		int piece = 0;
		int stick_count = 0;
		for (int i = 0; i < str.length(); i++) {
			stick.add(str.charAt(i));
			if (stick.peek() == '(') {
				if (str.charAt(i+1) == '(') {
					stick_count ++;
				} else {
					piece += stick_count;
				}
			} else {
				if (str.charAt(i-1) == ')') {
					stick_count --;
					piece ++;
				}
			}
		}
		System.out.println(piece);
	}
}
