package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {
	// boj Silver5
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean alphabet [] = new boolean [26];
			boolean check = true;
			for (int j = 0; j < str.length(); j++) {
				if (j - 1 >= 0) {
					if (str.charAt(j) == str.charAt(j-1)) {
						continue;
					}
				}
				if (alphabet[str.charAt(j) - 'a']) {
					check = false;
					break;
				}
				alphabet[str.charAt(j) - 'a'] = true;
			}
			
			if (check) {
				result ++;
			}
		}
		
		System.out.println(result);
	}
}
