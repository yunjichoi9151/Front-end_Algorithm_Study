public class 정수_제곱근_판별_12934 {
    public long solution(long n) {
        double answer = Math.sqrt(n);
        return answer % 1 == 0.0 ? (long)(Math.pow(answer + 1, 2)) : -1;
    }
}
