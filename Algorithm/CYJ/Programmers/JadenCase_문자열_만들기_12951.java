package Programmers;

class JadenCase_문자열_만들기_12951 {
    public String solution(String s) {
        String answer = "";
        answer += Character.toUpperCase(s.charAt(0));
        char[] arr = s.toCharArray();
        for(int i = 1; i < s.length(); i++) {
            if(arr[i - 1] == ' ' && arr[i] != ' ') {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }
        }
        return answer;
    }
}