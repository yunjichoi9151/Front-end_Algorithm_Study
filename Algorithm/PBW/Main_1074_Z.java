package algo;

import java.io.*;
import java.util.*;

public class Main_1074_Z {
	// boj Silver1
	
	static int r,c;
	static int num = 0;
	static boolean result = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		Z_move(N,0,0);
	}
	
	private static void Z_move(int N, int x, int y) {
		if (result) {
			return;
		}
		if (N == 1) {
			if (x == r && y == c) {
				System.out.println(num);
				result = true;
			}
			num++;
		} else {
			int plus = (int) Math.pow(N/2, 2);
			if (r < x + N/2 && c < y + N/2) {
				Z_move(N/2,x,y);				
			} else if (r < x + N/2 && c >= y + N/2) {
				num += plus;
				Z_move(N/2,x,y+N/2);
			} else if (r >= x + N/2 && c < y + N/2) {
				num += plus * 2;
				Z_move(N/2,x+N/2,y);
			} else {				
				num += plus * 3;
				Z_move(N/2,x+N/2,y+N/2);
			}

		}
	}
}
