public class 점프와_순간_이동_12980 {
    public int solution(int n) {
        int ans = 1;
        while(n > 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                ans++;
                n = (n - 1) / 2;
            }
        }
        return ans;
    }
}
