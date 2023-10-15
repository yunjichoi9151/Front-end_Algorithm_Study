public class 소수_찾기_12921 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 3; i <= n; i++) {
            answer++;
            for(int j = 2; j <= i / j; j++) {
                if(i % j == 0) {
                    answer--;
                    break;
                }
            }
        }
        return answer + 1;
    }
}
