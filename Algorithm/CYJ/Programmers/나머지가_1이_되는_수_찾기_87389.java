package Programmers;

public class 나머지가_1이_되는_수_찾기_87389 {
    public int solution(int n) {
        int answer = 1;
        while(true) {
            if(n % answer == 1) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
