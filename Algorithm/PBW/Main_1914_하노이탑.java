package algo;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main_1914_하노이탑 {
	// boj Silver1
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String [] stick1 = new String [8];
		String [] stick2 = new String [8];
		String [] stick3 = new String [8];
		
		BigInteger [] hanoi_count = new BigInteger [101];
		BigInteger mul2 = new BigInteger("2");
		BigInteger add1 = new BigInteger("1");
		hanoi_count[1] = new BigInteger("1");
		
		for (int i = 2; i < 101; i++) {
			hanoi_count[i] = hanoi_count[i-1].multiply(mul2).add(add1);
		}
		bw.write(hanoi_count[N].toString()+"\n");
		
		if (N <= 20) {
			hanoi(N, 1, 3, 2);			
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void hanoi(int num, int start, int end, int temp) throws IOException {
		if (num != 0) {
			hanoi(num-1, start, temp, end);
			bw.write(start + " " + end + "\n");
			hanoi(num-1, temp, end, start);
		}
	}
}
