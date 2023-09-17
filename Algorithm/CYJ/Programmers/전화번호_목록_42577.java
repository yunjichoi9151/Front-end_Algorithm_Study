import java.util.HashMap;

public class 전화번호_목록_42577 {
    public boolean solution(String[] phone_book) {
        boolean[] len = new boolean[21];
        HashMap<String, Boolean> map = new HashMap<>();
        for(String s : phone_book) {
            len[s.length()] = true;
            map.put(s, true);
        }
        for(int i = 1; i <= 20; i++) {
            if(len[i]) {
                for(String s : phone_book) {
                    if(s.length() > i && map.containsKey(s.substring(0, i)) && map.get(s.substring(0, i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
