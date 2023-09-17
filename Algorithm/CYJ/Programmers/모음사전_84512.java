public class 모음사전_84512 {
    public int solution(String word) {
        int ans = 0;
        int num = 3905;
        for(String s : word.split("")) {
            ans += "AEIOU".indexOf(s) * (num /= 5) + 1;
        }
        return ans;
    }
}
