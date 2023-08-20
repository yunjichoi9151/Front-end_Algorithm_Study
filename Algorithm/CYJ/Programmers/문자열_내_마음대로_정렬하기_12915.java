import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기_12915 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                } else {
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
            }
        });
        return strings;
    }
}
