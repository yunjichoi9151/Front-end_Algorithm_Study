import java.util.Arrays;

public class 구명보트_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(people);
        for(int i = people.length - 1; i >= idx; i--) {
            if(people[i] + people[idx] <= limit) {
                idx++;
            }
            answer++;
        }
        return answer;
    }
}
