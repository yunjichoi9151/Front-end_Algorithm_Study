import java.util.Arrays;

public class 문자열을_정수로_바꾸기_12925 {
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
