package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789_도키도키간식드리미 {
	// boj Silver3
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		int num = 1;
		boolean result = true;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			queue.add(temp);
		}
		
		while (!queue.isEmpty()) {
			if (queue.peek() == num) {
				queue.poll();
				num ++;
			} else if (!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				num++;
			} else {
				stack.add(queue.poll());
			}
		}
		
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			if (temp == num) {
				num++;
			} else {
				result = false;
				break;
			}
		}
		
		if (result) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
