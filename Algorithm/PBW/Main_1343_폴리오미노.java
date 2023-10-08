package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1343_폴리오미노 {
	// boj Silver5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		str = str.replace("XXXX", "AAAA");
		str = str.replace("XX", "BB");
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'X') {
				str = "-1";
				break;
			}
		}
		
		System.out.println(str);
	}
}
