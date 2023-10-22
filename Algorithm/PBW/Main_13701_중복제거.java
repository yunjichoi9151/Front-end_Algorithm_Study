package algo0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_13701_중복제거 {
	// boj Gold4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int size = st.countTokens();
		for (int i = 0; i < size; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) {
				continue;
			} else {
				bw.append(num + " ");
				map.put(num, true);
			}
		}
		
		bw.flush();
		bw.close();
		
	}
}
