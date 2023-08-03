package Baekjoon;


import java.util.Scanner;

public class 별_찍기_14_2556 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        sc.close();
    }
}
