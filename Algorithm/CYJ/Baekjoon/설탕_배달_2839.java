import java.util.Scanner;

public class 설탕_배달_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        int ans = -1;
        while(true) {
            if(5 * num > n) break;
            if((n - 5 * num) % 3 == 0) ans = num + ((n - 5 * num) / 3);
            num++;
        }
        System.out.println(ans);
        sc.close();
    }
}
