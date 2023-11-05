package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Main_5635_생일 {
	// boj Silver5
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int n = Integer.parseInt(br.readLine());
		Date low_age = format.parse("1989-01-01");
		Date high_age = format.parse("2011-01-01");
		String low_name = "";
		String high_name = "";
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String day = st.nextToken();
			String month = st.nextToken();
			String year = st.nextToken();
			
			Date temp = format.parse(year + "-" + month + "-" + day);
//			System.out.println(temp);
			if (high_age.after(temp)) {
				high_age = temp;
				high_name = name;
			}
			
			if (low_age.before(temp)) {
				low_age = temp;
				low_name = name;
			}
		}
		System.out.println(low_name);
		System.out.println(high_name);
	}
}
