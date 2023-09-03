package algo0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1817_짐챙기는숌 {
	// boj Silver5
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int result = 0;
		int box = 0;
		if (N != 0) {		
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int book = Integer.parseInt(st.nextToken());
				if (box + book <= M) {
					if (box == 0) {
						result ++;
					}
					box += book;
				} else {
					result ++;
					box = book;
				}
			}
		}
		
		System.out.println(result);
	}
}
