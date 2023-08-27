package algo0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_4779_칸토어집합 {
	// boj Silver3
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while ((input = br.readLine()) != null) {
			int num = Integer.parseInt(input);
			kanto((int) Math.pow(3, num));
			bw.append("\n");
			bw.flush();
		}
		bw.close();
	}
	
	public static void kanto(int n) throws IOException {
		if (n == 1) {
			bw.append("-");
		} else {
			kanto(n/3);
			for (int i = 0; i < n/3; i++) {
				bw.append(" ");			
			}
			kanto(n/3);
		}
	}
}
