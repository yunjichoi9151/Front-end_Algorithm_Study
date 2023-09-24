package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1339_단어수학 {
	// boj Gold4;

	static int N;
	static String word [];
	static int eng [] = new int [26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		word = new String [N];
		// 단어입력
		for (int i = 0; i < N; i++) {
			word[i] = sc.next();
			int temp = 0;
			for (int j = word[i].length() - 1; j >= 0; j--) {
				eng[word[i].charAt(j)-'A'] += Math.pow(10, temp);
				temp++;
			}
		}
		Arrays.sort(eng);
		
//		// 배열확인
//		System.out.println(Arrays.toString(eng));
		
		int result = 0;
		int num = 9;
		for (int i = 25; i >= 0; i--) {
			if (eng[i] == 0) {
				break;
			}
			result += eng[i] * num;
			num--;
		}
		
		System.out.println(result);
	}
}
