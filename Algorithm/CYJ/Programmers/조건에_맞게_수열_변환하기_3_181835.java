public class 조건에_맞게_수열_변환하기_3_181835 {class Solution {
    public int[] solution(int[] arr, int k) {
        if(k % 2 == 0) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] += k;
            }
        } else {
            for(int i = 0; i < arr.length; i++) {
                arr[i] *= k;
            }
        }
        return arr;
    }
}
}
