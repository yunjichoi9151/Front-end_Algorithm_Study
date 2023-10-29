import java.util.Scanner;

public class 평범한_배낭_12865 {
    public static int[][] dp;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n + 1][2];
        dp = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(arr[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(arr[i][1] + dp[i - 1][j - arr[i][0]], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[n][k]);
        sc.close();
    }
}
