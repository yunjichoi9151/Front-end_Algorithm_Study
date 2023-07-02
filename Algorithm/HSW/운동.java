import java.util.*;

public class Main {
	static final int INF = (int) 1e9;
	static int V, E;
	static int[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		dist = new int[V+1][V+1];
		
		for(int i=1; i<V+1; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			
			dist[st][ed] = Math.min(dist[st][ed], cost);
		}
		
		floyd();
		
		int ans = Integer.MAX_VALUE;
		
		for(int s=1; s<V+1; s++) {
			for(int e=1; e<V+1; e++) {
				if(s == e) continue;
				if(dist[s][e] == INF || dist[e][s] == INF) continue;
				int distance = dist[s][e] + dist[e][s];
				ans = Math.min(ans, distance);
			}
		}
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

	static void floyd() {
		for(int w=1; w<V+1; w++) {
			for(int s=1; s<V+1; s++) {
				if(s == w || dist[s][w] == INF) continue;
				for(int e=1; e<V+1; e++) {
					if(w == e || dist[w][e] == INF) continue;
					dist[s][e] = Math.min(dist[s][e], dist[s][w] + dist[w][e]);
				}
			}
		}
	}
}
