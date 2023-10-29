import java.util.Scanner;

public class 설탕_배달_dp_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        if(n >= 3) dp[3] = 1;
        if(n >= 5) dp[5] = 1;
        for(int i = 6; i <= n; i++) {
            if(i % 5 == 0) dp[i] = dp[i - 5] + 1;
            else if(i % 3 == 0) dp[i] = dp[i - 3] + 1;
            else {
                if(dp[i - 5] != 0 && dp[i - 3] != 0) {
                    dp[i] = Math.min(dp[i - 5], dp[i - 3]) + 1;
                }
            }
        }
        System.out.println(dp[n] == 0 ? -1 : dp[n]);
        sc.close();
    }
}
