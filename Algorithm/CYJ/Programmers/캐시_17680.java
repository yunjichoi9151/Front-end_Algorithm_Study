import java.util.LinkedList;
import java.util.Queue;

public class 캐시_17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        for(String s : cities) {
            s = s.toLowerCase();
            if(!queue.contains(s)) {
                if(queue.size() >= cacheSize) {
                    queue.poll();
                }
                answer += 5;
            } else {
                queue.remove(s);
                answer++;
            }
            queue.add(s);
        }
        return answer;
    }
}
