import java.util.HashSet;

public class 연속_부분_수열_합의_개수_131701 {
    public int solution(int[] elements) {
        int idx = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            idx = i;
            for(int j = 0; j < elements.length; j++) {
                sum += elements[idx++];
                set.add(sum);
                if(idx >= elements.length) {
                    idx = 0;
                }
            }
        }
        return set.size();
    }
}
