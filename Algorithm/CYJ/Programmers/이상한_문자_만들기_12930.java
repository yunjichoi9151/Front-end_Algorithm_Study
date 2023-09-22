public class 이상한_문자_만들기_12930 {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
                cnt = 0;
                continue;
            }
            if(cnt % 2 == 0) {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }
            cnt++;
        }
        return answer;
    }
}
