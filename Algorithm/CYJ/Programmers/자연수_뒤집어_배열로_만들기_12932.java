package Programmers;

public class 자연수_뒤집어_배열로_만들기_12932 {
    public int[] solution(long n) {
        String s = n + "";
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(s.length() - i - 1) - '0';
        }
        return answer;
    }
}
