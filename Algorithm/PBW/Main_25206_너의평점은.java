package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25206_너의평점은 {
	// boj Silver5
	
	public static void main(String[] args) throws IOException {
		double all = 0;
		double grade = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String sub = st.nextToken();
			double temp = Double.parseDouble(st.nextToken());
			switch (st.nextToken()) {
			case "A+":
				all += temp;
				temp *= 4.5;
				break;
			case "A0":
				all += temp;
				temp *= 4.0;
				break;
			case "B+":
				all += temp;
				temp *= 3.5;
				break;
			case "B0":
				all += temp;
				temp *= 3.0;
				break;
			case "C+":
				all += temp;
				temp *= 2.5;
				break;
			case "C0":
				all += temp;
				temp *= 2.0;
				break;
			case "D+":
				all += temp;
				temp *= 1.5;
				break;
			case "D0":
				all += temp;
				temp *= 1.0;
				break;
			case "F":
				all += temp;
				temp = 0;
			default:
				temp = 0;
				break;
			}
			
			grade += temp;
		}
		
		System.out.println(grade / all);
	}
}
