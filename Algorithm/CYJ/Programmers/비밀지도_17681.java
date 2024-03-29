public class 비밀지도_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            if(s.length() < n) {
                int k = n - s.length();
                for(int j = 0; j < k; j++) {
                    s = "0" + s;
                }
            }
            s = s.replaceAll("1", "#");
            s = s.replaceAll("0", " ");
            answer[i] = s;
        }
        return answer;
    }
}
