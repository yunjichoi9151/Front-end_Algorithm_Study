package algo0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {
	// boj Silver1
	
	static int N;
	static int[][] tree = new int [26][2];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';
			
			tree[root][0] = left == -19 ? -1 : left;
			tree[root][1] = right == -19 ? -1 : right;
		}
		
		preOrder(0);
		bw.append("\n");
		inOrder(0);
		bw.append("\n");
		postOrder(0);
		bw.flush();
		bw.close();
	}

	private static void preOrder(int start) throws IOException {
		bw.append((char)(start + 'A'));
		if (tree[start][0] != -1) {
			preOrder(tree[start][0]);
		}
		if (tree[start][1] != -1) {
			preOrder(tree[start][1]);
		}
	}
	
	private static void inOrder(int start) throws IOException {
		if (tree[start][0] != -1) {
			inOrder(tree[start][0]);
		}
		bw.append((char)(start + 'A'));
		if (tree[start][1] != -1) {
			inOrder(tree[start][1]);
		}
	}
	
	private static void postOrder(int start) throws IOException {
		if (tree[start][0] != -1) {
			postOrder(tree[start][0]);
		}
		if (tree[start][1] != -1) {
			postOrder(tree[start][1]);
		}
		bw.append((char)(start + 'A'));
	}
}
