import java.util.*;

public class Main {
	static final int INF = (int) 1e6;
	static int N, M, X;
	static int[][] dist;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		dist = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
	
		
		for(int i=0; i<M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			
			dist[st][ed] = Math.min(dist[st][ed], cost);
		}
		
		floyd();
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<N+1; i++) {
			int distance = dist[i][X] + dist[X][i];
			max = Math.max(max, distance);
		}
		
		System.out.println(max);
	}
	
	static void floyd() {
		for(int w=1; w<N+1; w++) {
			for(int s=1; s<N+1; s++) {
				if(s == w || dist[s][w] == INF) continue;
				for(int e=1; e<N+1; e++) {
					if(w == e || dist[w][e] == INF) continue;
					if(dist[s][e] > dist[s][w] + dist[w][e]) {
						dist[s][e] = dist[s][w] + dist[w][e];
					}
				}
			}
		}
	}

}
