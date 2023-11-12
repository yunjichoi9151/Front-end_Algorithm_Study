package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_20529_가장가까운세사람의심리적거리 {
	// boj Silver1
	
	static int N, result;
	static String[] student;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			result = 1000;
			String str = br.readLine();
			student = str.split(" ");
			
			if (N > 36) {
				result = 0;
			} else {				
				int[] num = new int [3];
				comb(0,0,num);
			}
			
			System.out.println(result);
		}
	}

	private static void comb(int cnt, int n, int[] num) {
		if (cnt == 3) {
			mbti(num);
			return;
		}
		
		for (int i = n; i < N; i++) {
			num[cnt] = i;
			comb(cnt+1, i+1, num);
		}
	}

	private static void mbti(int[] num) {
		String A = student[num[0]];
		String B = student[num[1]];
		String C = student[num[2]];
		
		int AB = 0;
		int BC = 0;
		int CA = 0;
		
		for (int i = 0; i < 4; i++) {
			if (A.charAt(i) != B.charAt(i)) {
				AB++;
			}
			if (B.charAt(i) != C.charAt(i)) {
				BC++;
			}
			if (C.charAt(i) != A.charAt(i)) {
				CA++;
			}
		}
		
		if (AB + BC + CA < result) {
			result = AB + BC + CA;
		}
	}
}
