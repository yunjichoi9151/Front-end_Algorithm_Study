package algo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main_4673_셀프넘버 {
	// boj Silver5 
	static boolean[] arr = new boolean [10001];
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 1; i < 10001; i++) {
			if (!arr[i]) {
				selfNumber(i);
				bw.append(i + "\n");				
			}
		}
		
		bw.flush();
		bw.close();
	}

	private static void selfNumber(int num) {
		arr[num] = true;
		int nextnum = num;
		while (num != 0) {
			nextnum += num % 10;
			num /= 10;
		}
		
		if (nextnum <= 10000 && !arr[nextnum]) {
			selfNumber(nextnum);
		}
	}
}
