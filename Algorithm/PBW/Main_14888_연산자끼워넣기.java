package algo0408;

import java.util.*;
import java.io.*;

public class Main_14888_연산자끼워넣기 {
	// boj Silver1
	
	static int N, max_result, min_result;
	static int [] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int [N];
		int [] cal= new int [4];
		max_result = Integer.MIN_VALUE;
		min_result = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		calculation(0, 0, cal);
		System.out.println(max_result);
		System.out.println(min_result);
		
	}
	
	public static void calculation(int cnt, int sum, int [] cal) {
		if (cnt == N-1) {
			if (sum > max_result) {
				max_result = sum;
			}
			if (sum < min_result) {
				min_result = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cal[i] > 0) {
				int temp_sum = sum;
				switch (i) {
				case 0:
					if (cnt == 0) {
						sum = num[cnt] + num[cnt+1];
					} else {						
						sum += num[cnt+1];  
					}
					cal[i] -= 1;
					break;
				case 1:
					if (cnt == 0) {
						sum = num[cnt] - num[cnt+1];
					} else {						
						sum -= num[cnt+1];  
					}
					cal[i] -= 1;
					break;
				case 2:
					if (cnt == 0) {
						sum = num[cnt] * num[cnt+1];
					} else {						
						sum *= num[cnt+1];  
					}
					cal[i] -= 1;
					break;
				case 3:
					if (cnt == 0) {
						sum = num[cnt] / num[cnt+1];
					} else {						
						sum = sum / num[cnt+1];  
					}
					cal[i] -= 1;
					break;
				}
				
				calculation(cnt+1, sum, cal);
				sum = temp_sum;
				cal[i] += 1;
			}
		}
	}
}
