package algo;

import java.util.*;
import java.io.*;

public class Main_1002_터렛 {
	// boj Sliver3
	
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for (int t = 0; t < T; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int r1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				
				int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//				System.out.println(distance);
				if (x1 == x2 && y1 == y2 && r1 == r2) {
					System.out.println(-1);
				} else if (distance > (int)Math.pow(r1 + r2, 2)) {
					System.out.println(0);
				} else if (distance < (int)Math.pow(r2 - r1, 2)) {
					System.out.println(0);
				} else if (distance == (int)Math.pow(r2 - r1, 2)) {
					System.out.println(1);
				} else if (distance == (int)Math.pow(r1 + r2, 2)) {
					System.out.println(1);
				} else {
					System.out.println(2);
				}
			}
		}
}
