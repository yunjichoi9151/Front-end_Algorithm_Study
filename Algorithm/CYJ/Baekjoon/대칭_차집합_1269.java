import java.util.HashSet;
import java.util.Scanner;

public class 대칭_차집합_1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < a + b; i++) {
			set.add(sc.nextInt());
		}
		System.out.println(2 * set.size() - a - b);
		sc.close();
	}
}
