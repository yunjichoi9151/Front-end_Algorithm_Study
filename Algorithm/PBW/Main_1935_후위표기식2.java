package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main_1935_후위표기식2 {
	// boj Silver3
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			char alphabet = (char) (65 + i);
			int num = Integer.parseInt(br.readLine());
			map.put(alphabet, num);
		}
		
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			Character temp = str.charAt(i);
			if ('A' <= temp && temp <= 'Z') {
				stack.add((double) map.get(temp));
			} else {
				double a1 = stack.pop();
				double a2 = stack.pop();
				switch (temp) {
				case '+':
					stack.add(a2 + a1);
					break;
				case '-':
					stack.add(a2 - a1);
					break;
				case '/':
					stack.add(a2 / a1);
					break;
				case '*':
					stack.add(a2 * a1);
					break;
				}
			}
		}
		
		String result = String.format("%.2f", stack.pop());
		System.out.println(result);
	}
}
