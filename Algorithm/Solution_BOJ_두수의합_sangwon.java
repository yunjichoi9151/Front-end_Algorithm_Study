import java.util.*;

public class Solution_BOJ_두수의합_sangwon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //수열 크기
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int x = sc.nextInt();
		
		int cnt = 0;
		int lp = 0;
		int rp = n-1;
		
		while(lp < rp) { 
			if(arr[lp] + arr[rp] == x) {
				cnt++;
				lp++;
				rp--;
			} else if(arr[lp] + arr[rp] < x) {
				lp++;
			} else {
				rp--;
			}
		}
		
		System.out.println(cnt);
	}

}
