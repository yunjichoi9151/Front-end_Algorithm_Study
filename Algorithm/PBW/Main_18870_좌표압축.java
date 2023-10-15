package algo0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {
	// boj Silver2
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];
		int [] sort = new int [N];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sort[i] = num;
		}
		
		Arrays.sort(sort);
		int cnt = 0;
		map.put(sort[0], cnt);
		for (int i = 1; i < N; i++) {
			if (sort[i] == sort[i-1]) {
				continue;
			} else {
				cnt++;
				map.put(sort[i], cnt);
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			bw.append(map.get(arr[i]) + " ");
		}
		bw.flush();
		bw.close();
	}
}
