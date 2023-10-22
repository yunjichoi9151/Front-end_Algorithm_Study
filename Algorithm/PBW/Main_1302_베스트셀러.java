package algo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main_1302_베스트셀러 {
	// boj Silver4
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				int temp = map.get(str);
				map.put(str, temp+1);
			} else {
				map.put(str, 1);
			}
			
			if (map.get(str) > max) {
				max = map.get(str);
			}
		}
		
		List<String> list = new LinkedList<>();
		for (String string : map.keySet()) {
			list.add(string);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i)) == max) {
				System.out.println(list.get(i));
				break;
			}
		}
	}
}
