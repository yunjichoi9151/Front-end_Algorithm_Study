package SWEA;
import java.util.Scanner;

public class 성택이의_은밀한_비밀번호_25372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(s.length() >= 6 && s.length() <= 9 ? "yes" : "no");
        }
        sc.close();
    }
}
