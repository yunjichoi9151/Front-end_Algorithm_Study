package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1639_행운의티켓 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ticket = br.readLine();
		
		int result = 0;
		int size = ticket.length();
		int length = size / 2;
		
		while (length > 0) {
			if (result != 0) {
				break;
			}
			
			// 시작 위치
			for (int i = 0; i <= size - length * 2; i++) {
				int left = 0;
				int right = 0;
				for (int j = i; j < i + length; j++) {
					left += ticket.charAt(j) - '0';
					right += ticket.charAt(j+length) - '0';
				}
				
				if (left == right) {
					result = length * 2;
				}
			}
			
			length --;
		}
		
		System.out.println(result);
	}
}
