import java.util.HashSet;
import java.util.Scanner;

public class 문자열_집합_14425 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(sc.next());
		}
		for(int i = 0; i < m; i++) {
			if(set.contains(sc.next())) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
