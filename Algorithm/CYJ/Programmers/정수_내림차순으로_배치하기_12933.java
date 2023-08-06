package Programmers;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기_12933 {
    public long solution(long n) {
        long answer = 0;
        String str = n + "";
        int[] arr = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        Arrays.sort(arr);
        long num = 1;
        for(int i = 0; i < arr.length; i++) {
            answer += arr[i] * num;
            num *= 10;
        }
        return answer;
    }
}
