package algo0408;

import java.util.Scanner;

public class Main_11401_이항계수3 {
	// boj Gold1
	
	static long N,K;
	static long div_num = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(bino_coef(N,K));
	}
	
	private static long bino_coef(long n, long k) {
		
		if (k == 0 || n == k) {
			return 1;
		}
		
		return (facto(n) * reverse(k, n-k)) % div_num;
		
	}
	
	private static long facto(long f) {
		if (f == 1) {
			return 1;
		}
		return (f * facto(f-1)) % div_num;
	}
	
	private static long reverse(long r, long m) {
		
		long demon = (facto(r) * facto(m)) % div_num;
//		System.out.println("demon : " + demon);
		return pow(demon,div_num-2) % div_num;
	}
	
	private static long pow(long n, long expo) {
		
		if (expo == 1) {
			return n % div_num;
		}
		
		long temp = pow(n, expo/2);
		
		if (expo % 2 == 1) {
			return (temp * temp % div_num) * n % div_num;
		}
		return temp * temp % div_num;
	}
}
