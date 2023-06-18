package algo0408;

import java.util.*;

public class Main_2504_괄호의값 {
	// boj Silver1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String paren = sc.next();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		int temp = 1;
		
		for (int i = 0; i < paren.length(); i++) {
			if (paren.charAt(i) == '(') {
				temp *= 2;
				stack.push('(');
			} else if (paren.charAt(i) == '[') {
				temp *= 3;
				stack.push('[');
			} else if (paren.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}
				if (paren.charAt(i - 1) == '(') {
					result += temp;
				}
				stack.pop();
				temp /= 2;
			} else if (paren.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}
				if (paren.charAt(i - 1) == '[') {
					result += temp;
				}
				stack.pop();
				temp /= 3;
			}
//			System.out.print("result : " + result + " temp : " + temp + " " + paren.charAt(i) + " ");
//			if (!stack.isEmpty()) {
//				System.out.println(stack.peek());
//			}
		}
		
		if (stack.isEmpty()) {
			System.out.println(result);
		} else {
			System.out.println(0);
		}

	}
}
