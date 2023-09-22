public class 둘만의_암호_155652 {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] arr = new boolean[26];
        for(int i = 0; i < skip.length(); i++) {
            arr[skip.charAt(i) - 'a'] = true;
        }
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int num = index;
            while (num > 0) {
                idx = (idx + 1) % 26;
                if (!arr[idx]) {
                    num--;
                }
            }
            answer += (char)(idx + 'a') + "";
        }
        return answer;
    }
}
