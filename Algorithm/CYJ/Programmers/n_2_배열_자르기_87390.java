public class n_2_배열_자르기_87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        for(long i = left; i <= right; i++) {
            answer[idx++] = Math.max((int)(i / (long)n), (int)(i % (long)n)) + 1;
        }
        return answer;
    }
}
