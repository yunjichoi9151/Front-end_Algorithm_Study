package Algorithm.CYJ;

import java.util.Scanner;

public class 별_찍기_12_2552 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < 2 * n - 1; i++) {
            if(i < n) {
                for(int j = 0; j < n; j++) {
                    if(j < n - i - 1) {
                        System.out.print(' ');
                    } else {
                        System.out.print('*');
                    }
                }
            } else {
                for(int j = 0; j < n; j++) {
                    if(j > i - n) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
