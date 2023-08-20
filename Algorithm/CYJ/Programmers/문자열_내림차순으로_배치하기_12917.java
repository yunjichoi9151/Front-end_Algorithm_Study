import java.util.Arrays;

public class 문자열_내림차순으로_배치하기_12917 {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i];
        }
        return answer;
    }
}
