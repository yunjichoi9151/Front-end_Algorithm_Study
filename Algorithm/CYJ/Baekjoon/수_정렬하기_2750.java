package Baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class 수_정렬하기_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}
