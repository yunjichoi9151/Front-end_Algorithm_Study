import java.util.Scanner;

public class 다리_놓기_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = 1;
            for(int j = 0; j < n; j++) {
                ans = ans * (m - j) / (j + 1);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
