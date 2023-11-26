package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2535_아시아정보올림피아드 {
	// boj Silver5
	
	public static class Node {
		int centry;
		int no;
		int score;
		
		public Node(int centry, int no, int score) {
			this.centry = centry;
			this.no = no;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.score - o1.score;
			}
		});
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int centry = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			Node student = new Node(centry,no,score);
			pq.add(student);
		}
		
		int[] check = new int[101];
		for (int i = 0; i < 3;) {
			Node result = pq.poll();
			if (check[result.centry] < 2) {
				check[result.centry]++;
				i++;
				System.out.println(result.centry + " " + result.no);
			}
		}
		
	}
}
