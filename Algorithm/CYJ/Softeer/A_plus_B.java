import java.util.*;

public class A_plus_B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println("Case #" + tc + ": " + (A + B));
        }
        sc.close();
    }
}