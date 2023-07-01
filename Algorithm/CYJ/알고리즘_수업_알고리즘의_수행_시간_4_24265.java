package Algorithm.CYJ;

import java.util.Scanner;

public class 알고리즘_수업_알고리즘의_수행_시간_4_24265 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = 0;
        for(long i = n - 1; i > 0; i--) {
            ans += i;
        }
        System.out.println(ans + "\n" + 2);
        sc.close();
    }
}
