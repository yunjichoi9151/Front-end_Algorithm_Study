package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {
	// boj Silver5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());	
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> row_list = new ArrayList<Integer>();
		List<Integer> col_list = new ArrayList<Integer>();
		row_list.add(0);
		row_list.add(row);
		col_list.add(0);
		col_list.add(col);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (check == 0) {
				col_list.add(num);
			} else {
				row_list.add(num);
			}
		}
		Collections.sort(row_list);
		Collections.sort(col_list);
		
		int row_result = 0;
		int col_result = 0;
		for (int i = 1; i < row_list.size(); i++) {
			int temp = row_list.get(i) - row_list.get(i-1);
			System.out.println(temp);
			if (temp > row_result) {
				row_result = temp;
			}
		}
		for (int i = 1; i < col_list.size(); i++) {
			int temp = col_list.get(i) - col_list.get(i-1);
			if (temp > col_result) {
				col_result = temp;
			}
		}
		
		System.out.println(row_result * col_result);
	}
}
