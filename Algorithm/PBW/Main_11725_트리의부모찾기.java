package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	// boj Silver2
	
	static List<Node> tree = new ArrayList<>();
	static boolean[] check;
	
	static class Node {
		int root;
		List<Integer> obj = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		check = new boolean [N+1];
		
		for (int i = 0; i < N+1; i++) {
			tree.add(i,new Node());
		}
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			tree.get(start).obj.add(end);
			tree.get(end).obj.add(start);
		}
		
		bfs(1);
		for (int i = 2; i < N+1; i++) {
			System.out.println(tree.get(i).root);
		}
	}

	private static void bfs(int root) {
		check[root] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int num : tree.get(root).obj) {
			queue.add(num);
		}
		
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			check[temp] = true;
			
			for (int num : tree.get(temp).obj) {
				if (!check[num]) {
					queue.add(num);
				} else {
					tree.get(temp).root = num;
				}
			}
		}
	}
}
