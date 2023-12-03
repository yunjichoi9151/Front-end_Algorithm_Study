package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1068_트리 {
	// boj Gold5
	
	static int N, result;
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		int del = Integer.parseInt(br.readLine());
		
		deleteNode(del);
		
		result = 0;
		for (int i = 0; i < N; i++) {
			if (tree[i] == -2) {
				continue;
			}
			
			boolean check = true;
			for (int j = 0; j < N; j++) {
				if (tree[j] == i) {
					check = false;
//					System.out.println(tree[j] + " " + j + " " + i);
					break;
				}
			}
			
			if (check) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static void deleteNode(int del) {
		tree[del] = -2;
		for (int i = 0; i < N; i++) {
			if (tree[i] == del) {
				deleteNode(i);
			}
		}
	}
}
