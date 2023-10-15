

import java.util.Scanner;

public class 알고리즘_수업_알고리즘의_수행_시간_6_24267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = 0;
        long cnt = 1;
        for(long i = n - 2; i > 0; i--) {
            ans += i * cnt;
            cnt++;
        }
        System.out.println(ans + "\n" + 3);
        sc.close();
    }
}
