package Programmers;

import java.util.*;

class 최댓값과_최솟값_12939 {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
    
        Arrays.sort(arr);
        return arr[0] + " " + arr[arr.length - 1];
    }
}
