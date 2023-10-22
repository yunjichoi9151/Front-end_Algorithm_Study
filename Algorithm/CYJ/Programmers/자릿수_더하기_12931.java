public class 자릿수_더하기_129831 {
    public int solution(int n) {
        int answer = 0;
        while(true) {
            answer += n % 10;
            n /= 10;
            if(n == 0) {
                break;
            }
        }
        return answer;
    }
}
