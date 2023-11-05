import java.util.HashMap;

public class 롤케이크_자르기_132265 {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int n : topping) {
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }
        for(int n : topping) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
            if(map2.get(n) == 1) {
                map2.remove(n);
            } else {
                map2.put(n, map2.get(n) - 1);
            }
            if(map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}
