import java.util.Scanner;

public class 숫자의_합_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += s.charAt(i) - '0';
        }
        System.out.println(ans);
        sc.close();
    }
}
