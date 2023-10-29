import java.util.Scanner;

public class 최소공배수_13241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = a * b;
        while (b > 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        System.out.println(c / a);
        sc.close();
    }
}
