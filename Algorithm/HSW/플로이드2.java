import java.util.*;

public class Main {
	static final int INF = 100000000;
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //도시의 개수
		m = sc.nextInt(); //버스의 개수
		
		int[][] dist = new int[n+1][n+1]; //각 도시 -> 도시간 거리를 저장할 배열
		int[][] min = new int[n+1][n+1]; //도시 -> 도시로 갈 때 가장 짧은 경유지 정보
		
		//min[s][e] = e라면, s와 e 사이에 경유지가 없다고 생각
		//min[s][e] = INF라면, s에서 e로 가는 방법이 없다고 생각
		for(int i=1; i<n+1; i++) {
			Arrays.fill(dist[i], INF); //최대 거리로 초기화
			Arrays.fill(min[i], INF);
		}
		
		
		for(int i=1; i<n+1; i++) {
			dist[i][i] = 0; // i->i간 거리는 0
			min[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			
			if(dist[st][ed] > cost) {
				dist[st][ed] = cost;
				min[st][ed] = st;
			}
		}
		
		//경유지 w
		for(int w=1; w<n+1; w++) {
			//출발지 s
			for(int s=1; s<n+1; s++) {
				//도착지 e
				for(int e=1; e<n+1; e++) {
					if(dist[s][e] > dist[s][w] + dist[w][e]) {
						dist[s][e] = dist[s][w] + dist[w][e];
						min[s][e] = min[w][e];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(dist[i][j] == INF) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		//i->j로 갈때 최단 경유지를 찾아야함
		for(int s=1; s<n+1; s++) {
			for(int e=1; e<n+1; e++) {
				int i = s;
				int j = e;
				if(i == j || min[i][j] == INF) {
					sb.append(0).append("\n");
					continue;
				}
				Stack<Integer> stack = new Stack<>();
				
				while(true) {
					if(min[i][j] == i) {
						stack.push(j);	
						stack.push(i);
						break;
					}
					else {
						stack.push(j);
						j = min[i][j];
					}
				}
				sb.append(stack.size()).append(" ");
				while(!stack.isEmpty()) {
					sb.append(stack.pop()).append(" ");
				}
//				sb.append(min[s][e]).append(" ");
				sb.append("\n");
			}
//			sb.append("\n");
		}

		
		System.out.println(sb);
	}
}
