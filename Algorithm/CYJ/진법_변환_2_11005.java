package Algorithm.CYJ;

import java.util.ArrayList;
import java.util.Scanner;

public class 진법_변환_2_11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Character> list = new ArrayList<>();
        while(n > 0) {
            if(n % b < 10) {
                list.add((char) (n % b + '0'));
            } else {
                list.add((char) (n % b  - 10 + 'A'));
            }
            n /= b;
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
        sc.close();
    }
}
