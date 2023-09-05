package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20920_영단어암기는괴로워 {
	// boj Silver3
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.length() >= M ) {
				if (map.get(str) == null) {
					map.put(str, 1);
				} else {
					map.put(str, map.get(str)+1);
				}
			}
		}
		
		List<String> list = new ArrayList<String>(map.keySet());
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o2) != map.get(o1)) {
					return map.get(o2).compareTo(map.get(o1));					
				}
				
				if (o2.length() != o1.length()) {
					return o2.length() - o1.length();
				}
				
				return o1.compareTo(o2);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			bw.append(list.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
