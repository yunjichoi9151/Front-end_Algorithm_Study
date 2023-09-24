package algo0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_18258_큐2 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				break;
			case "pop":
				if (queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.pop() + "\n");
				}
				break;
			case "size":
				bw.append(queue.size() + "\n");
				break;
			case "empty":
				if (queue.isEmpty()) {
					bw.append("1\n");
				} else {
					bw.append("0\n");
				}
				break;
			case "front":
				if (queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.peekFirst() + "\n");
				}
				break;
			case "back":
				if (queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.peekLast() + "\n");
				}
				break;
			}
		}
		
		bw.flush();
		bw.close();
		
	}
}
