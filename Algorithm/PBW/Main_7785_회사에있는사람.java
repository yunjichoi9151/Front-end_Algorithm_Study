package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_7785_회사에있는사람 {
	// boj Silver5
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		List<String> sortKey = new ArrayList<String>(map.keySet());
		Collections.sort(sortKey);
		Collections.reverse(sortKey);
		
		for (String member : sortKey) {
			if (map.get(member).equals("enter")) {
				System.out.println(member);
			}
		}
	}
}
