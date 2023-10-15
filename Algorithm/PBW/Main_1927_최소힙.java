package algo0408;

import java.io.*;

public class Main_1927_최소힙 {
	// boj Silver2
	
	static int heep [];
	static int end = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		heep = new int [N];
		
		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command == 0) {
				remove();
			} else {
				add(command);
			}
		}
	}

	private static void add(int num) {
		int size = end;
		end ++;
		
		heep[size] = num;
		while (true) {
			if (size/2 > 0) {
				if (heep[size/2] > heep[size]) {
					int temp = heep[size/2];
					heep[size/2] = heep[size];
					heep[size] = temp;
				}
			} else {
//				// 정상적으로 최소힙이 들어갔는지 체크
//				for (int i = 0; i < heep.length; i++) {
//					System.out.print("heep : " + heep[i] + " ");
//				}
//				System.out.println();
				return;
			}
			size = size/2;
		}
	}

	private static void remove() {
		System.out.println(heep[1]);
		if (heep[1] == 0) {
			return;
		}
		heep[1] = heep[end-1];
		heep[end-1] = 0;
		end --;
		
		int start = 1;
		while(true) {
			if (start * 2 >= heep.length) {
				return;
			}
			if (heep[start*2] != 0 && heep[start*2+1] != 0) {
				int temp = heep[start*2] < heep[start*2+1] ? heep[start*2] : heep[start*2+1];
				boolean lr = heep[start*2] < heep[start*2+1] ? true : false;
				if (temp < heep[start]) {
					if (lr) {
						heep[start*2] = heep[start];
						heep[start] = temp;
						start = start*2;
					} else {
						heep[start*2+1] = heep[start];
						heep[start] = temp;
						start = start*2+1;
					}
				} else {
					return;
				}
			} else if (heep[start*2] != 0) {
				int temp = heep[start*2];
				if (temp < heep[start]) {
					heep[start*2] = heep[start];
					heep[start] = temp;
					start = start *2;
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}
}
