package algo0408;

import java.io.*;
import java.util.*;

public class Main_1931_회의실배정 {
	// boj Silver1
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int table [][ ]= new int [N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(st.nextToken());
			table[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(table,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int result = 0;
		int time = 0;
		
		for (int i = 0; i < N; i++) {
			if (time <= table[i][0]) {
				result ++;
				time = table[i][1];
			}
		}
		
		System.out.println(result);
	}
}
