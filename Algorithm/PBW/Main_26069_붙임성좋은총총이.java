package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_26069_붙임성좋은총총이 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("ChongChong", true);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			
			if (map.get(A) == null) {
				map.put(A, false);
			}
			if (map.get(B) == null) {
				map.put(B, false);
			}
			
			if (map.get(A) || map.get(B)) {
				map.put(A, true);
				map.put(B, true);
			}
		}
		
		int result = 0;
		for (String check : map.keySet()) {
			if (map.get(check)) {
				result ++;
			}
		}
		
		System.out.println(result);
	}
}
