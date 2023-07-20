package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986_좋은단어 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				if (stack.isEmpty()) {
					stack.add(str.charAt(j));
				} else if (stack.peek() == str.charAt(j)) {
					stack.pop();
				} else {
					stack.add(str.charAt(j));
				}
			}
			
			if (stack.isEmpty()) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
}
