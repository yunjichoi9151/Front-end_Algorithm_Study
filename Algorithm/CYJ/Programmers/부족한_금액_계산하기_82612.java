package Programmers;

public class 부족한_금액_계산하기_82612 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i = 1; i <= count; i++) {
            answer += price * i;
        }
        return answer > money ? answer - money : 0;
    }
}
