package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525_IOIOI {
	// boj Silver1
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
//		String ioioi = "";
//		for (int i = 0; i < N; i++) {
//			ioioi += "IO";
//		}
//		ioioi += "I";
//		System.out.println(ioioi);
		
		int memo [] = new int [M];
		int result = 0;
		
//		for (int i = 0; i < M - (N*2); i++) {
//			String temp = S.substring(i, i+(N*2+1));
////			System.out.print(temp + " ");
//			if (temp.equals(ioioi)) {
//				result ++;
//			}
//		}
		
		for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= N && S.charAt(i - 2 * N + 1) == 'I')
                    result++;
            }
        }
		
		System.out.println(result);
	}
}
