package algo0408;

import java.util.Scanner;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {
	// boj Silver3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<String> stack = new Stack<>();
		String result = "";
		boolean check = true;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				check = false;
				while (!stack.empty()) {
					result = result + stack.pop();
				}
			}
			if (str.charAt(i) == '>') {
				check = true;
				result = result + ">";
				continue;
			}
			if (str.charAt(i) == ' ') {
				while (!stack.empty()) {
					result = result + stack.pop();
				}
				result += " ";
				continue;
			}
			if (check) {
				stack.add(String.valueOf(str.charAt(i)));
			} else {
				result = result + String.valueOf(str.charAt(i));
			}
		}
		
		while (!stack.empty()) {
			result = result + stack.pop();
		}
		
		System.out.println(result);
	}
}
