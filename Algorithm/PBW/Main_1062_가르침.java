package algo0408;

import java.util.*;
import java.io.*;

public class Main_1062_가르침 {
	// boj Gold4
	
	static int N,K,result;
	static String [] word;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = 0;
		
		word= new String [N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			word[i] = temp.substring(4,temp.length()-4);
//			System.out.println(word[i]);
		}
		boolean alphabet [] = new boolean [26];
		alphabet[0] = true;
		alphabet[2] = true;
		alphabet[8] = true;
		alphabet[13] = true;
		alphabet[19] = true;
		
		// 알파벳 아스키 코드 체크
//		System.out.println('a' - 97 + " : " + alphabet['a' - 97]);
//		System.out.println('c' - 97 + " : " + alphabet['c' - 97]);
//		System.out.println('i' - 97 + " : " + alphabet['i' - 97]);
//		System.out.println('n' - 97 + " : " + alphabet['c' - 97]);
//		System.out.println('t' - 97 + " : " + alphabet['t' - 97]);
		
		if (K < 5) {
			System.out.println(result);
		} else {
			int study = K - 5;
			studing(study, 0, 0, alphabet);
			System.out.println(result);
		}
	}
	
	public static void studing(int study, int cnt, int num, boolean [] alphabet) {
		if (cnt == study) {
			int studingWord = 0;
			// 단어를 배울 수 있는지 여부 체크
			for (int i = 0; i < N; i++) {				
				boolean check = true;
				for (int j = 0; j <	26; j++) {
					if (!alphabet[j] && word[i].indexOf( String.valueOf((char)(j+97)) ) != -1) {
						check = false;
						break;
					}
				}
				if (check) {
					studingWord ++;
				}
			}
			
			if (studingWord > result) {
				result = studingWord;
			}
		}
		
		// 알파벳 학습 재귀
		for (int i = num; i < 26; i++) {
			if (!alphabet[i]) {
				alphabet[i] = true;
				studing(study, cnt+1, i+1, alphabet);
				alphabet[i] = false;
			}
		}
		
	}
}
