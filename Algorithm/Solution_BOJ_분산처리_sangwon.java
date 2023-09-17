import java.util.*;

public class Solution_BOJ_분산처리_sangwon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int ans = 1;
			while(a >= 10) {
				a %= 10;
			}
			
			
			switch (a) {
				case 1:
					ans = 1;
					break;
				case 2:
					b %= 4; // 2, 4, 8, 6
					if(b == 0) b = 4;
					ans = (int) Math.pow(a, b);
					break;
				case 3:
					b %= 4; // 3, 9, 7, 1
					if(b == 0) b = 4;
					ans = (int) Math.pow(a, b);
					break;
				case 4:
					b %= 2; // 4, 6
					if(b == 0) b = 2;
					ans = (int) Math.pow(a, b);
					break;
				case 5:
					ans = 5;
					break;
				case 6:
					ans = 6;
					break;
				case 7:
					b %= 4; // 7, 9, 3, 1
					ans = (int) Math.pow(a, b);
					if(b == 0) b = 4;
					break;
				case 8:
					b %= 4; // 8, 4, 2, 6
					if(b == 0) b = 4;
					ans = (int) Math.pow(a, b);
					break;
				case 9:
					b %= 2; // 9, 1
					if(b == 0) b = 2;
					ans = (int) Math.pow(a, b);
					break;
				case 0:
					ans = 10;
					break;
			}

			while(ans >= 11) {
				ans %= 10;
			}
			
			
			if(ans == 0) ans = 10;
			
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

}
