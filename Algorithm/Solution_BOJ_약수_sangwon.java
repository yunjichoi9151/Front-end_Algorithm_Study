import java.util.*;

public class Solution_BOJ_약수_sangwon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); //진짜 약수의 개수
		
		int[] rDiv = new int[num];
		
		for(int i=0; i<num; i++) {
			rDiv[i] = sc.nextInt();
		}
		
		Arrays.sort(rDiv);
		
//		if(num % 2 == 0) {
//			System.out.println(rDiv[num/2 - 1] * rDiv[num/2]);
//		} else {
//			System.out.println(rDiv[num/2] * rDiv[num/2]);
//		}
		
		System.out.println(rDiv[0] * rDiv[num-1]);
	}
}
