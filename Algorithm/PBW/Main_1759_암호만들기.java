package algo0408;

import java.util.*;
import java.io.*;

public class Main_1759_암호만들기 {
	// boj Gold5
	static int L,C;
	static String [] code;
			
	public static void main(String [] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		code = new String [C];
//		System.out.println("L : " + L + " C : " + C);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			code[i] = st.nextToken();
//			System.out.println(code[i]);
		}
		Arrays.sort(code);

		comb(0,0,"");
	}
	
	private static void comb(int cnt, int num, String str) {
		if (cnt == L) {
			int vowel = 0;
			int consonant = 0;
			for (int i = 0; i < L; i++) {
				if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
					vowel++;
				} else consonant++;
				
				if (vowel > 0 && consonant > 1) {
					System.out.println(str);
					break;
				}
			}
			return;
		}
		
		for (int i = num; i < C; i++) {
			comb(cnt+1,i+1,str+code[i]);
		}
	}
}
