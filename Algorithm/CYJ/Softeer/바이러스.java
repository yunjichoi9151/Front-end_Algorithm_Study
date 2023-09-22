import java.util.Scanner;

public class 바이러스 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long p = sc.nextLong();
        long n = sc.nextLong();
        System.out.println((int)(k * (Math.pow(p, n) % 1000000007)));
        sc.close();
    }
}
