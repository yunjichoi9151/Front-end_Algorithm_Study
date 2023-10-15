import java.util.Scanner;

public class 동아리실_관리하기_3316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // dp를 담을 배열
        int[][] dp;
        for(int tc = 1; tc <= t; tc++) {
            String keys = sc.next();
            // [문자열 길이(날짜만큼)][4명이 존재 or 비존재할 경우의 수 -> 2 ^ 4]
            dp = new int[keys.length()][16];
            // 첫번째 날 계산(key를 A가 먼저 가지고 있다는 조건)
            first_day(keys, dp);
            for(int i = 1; i < keys.length(); i++) {
                // 첫번째 날 제외 나머지 날 계산
                other_day(keys, dp, i);
            }
            int ans = sol(dp);
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }

    public static void first_day(String keys, int[][] dp) {
        // 첫번째 날의 담당자가 누구인지 알아내고, 그에 맞는 위치까지 shift한다.
        int key = 1 << (keys.charAt(0) - 'A');
        // 모든 16가지 경우에 대해 판별한다.
        for(int i = 1; i < 16; i++) {
            // 담당자가 존재하고, 가장 처음 키를 가지고 있는 A 또한 존재하는 경우
            if((i & key) != 0 && (i & 1) != 0) {
                dp[0][i] = 1;
            }
        }
    }

    public static void other_day(String keys, int[][] dp, int day) {
        // 담당자가 누구인지 알아내고, 그에 맞는 위치까지 shift한다.
        int key = 1 << (keys.charAt(day) - 'A');
        for(int i = 1; i < 16; i++) {
            // 전날에서 가능하다고 판별난 경우만 생각하면 됨
            if(dp[day - 1][i] != 0) {
                for(int j = 1; j < 16; j++) {
                    // 1. 지금 인원 구성과, 전에 가능하다고 판별된 인원 구성에 겹치는 인원이 있어야 함
                    // 2. 지금 인원 구성에 담당자가 포함되어 있어야 함
                    if((j & i) != 0 && (j & key) != 0) {
                        // dp[day][j]에 dp[day - 1][i]를 더하는 이유는
                        // 전날에서 당일로 이어진 가지의 개수만큼의 경우의 수가 추가되는 것이기 때문임
                        dp[day][j] += dp[day - 1][i];
                        dp[day][j] %= 1000000007;
                    }
                }
            }
        }
    }

    public static int sol(int[][] dp) {
        int sum = 0;
        // dp의 최종 결과들을 더함
        for(int i = 1; i < 16; i++) {
            // 누적된 각 경우의 결과들을 더함
            sum += dp[dp.length - 1][i];
            sum %= 1000000007;
        }
        return sum;
    }
}
