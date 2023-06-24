package algo;

import java.io.*;

public class Main_6588_골드바흐의추측 {
	// boj Silver1
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] map = new int [1000001];
		for (int i = 2; i < 1000001; i++) {
			if (map[i] == 0) {
				map[i] = 1;
				for (int j = 2; j * i < 1000001; j++) {
					map[i*j] = -1;
				}
			}
//			System.out.println(i+" : " + map[i]);
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			boolean check = true; 
			if (N == 0) {
				break;
			}
			
			for (int i = 3; i < 1000001; i++) {
				if (map[i] == 1 && map[N-i] == 1) {
					System.out.println(N + " = " + i + " + " + (N-i));
					check = false;
					break;
				}
			}
			
			if (check) {
				System.out.println("Goldbach's conjecture is wrong.");				
			}
			
		}
	}

}
