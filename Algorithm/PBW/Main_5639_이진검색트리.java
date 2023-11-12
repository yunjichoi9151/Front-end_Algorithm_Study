package algo0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5639_이진검색트리 {
	// boj Gold5
	
	static int[] arr = new int[10001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		int idx = 0;
		// 백준 제출엔 null로 써야한다
        while ((str = br.readLine()) != null) {
        	arr[idx++] = Integer.parseInt(str);
        }
//        // 이클립스용
//        while (!(str = br.readLine()).equals("")) {
//        	arr[idx++] = Integer.parseInt(str);
//        }

        postOrder(0, idx - 1);
	}

	private static void postOrder(int num, int end) throws NumberFormatException, IOException {
		if (num > end) {
            return;
		}
		
        int mid = num + 1;
        while (mid <= end && arr[mid] < arr[num]) {
        	mid++;        	
        }

        postOrder(num + 1, mid - 1);
        postOrder(mid, end);
        System.out.println(arr[num]);
	}
}
