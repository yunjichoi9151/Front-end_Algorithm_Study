public class 최대공약수와_최소공배수_12940 {
    public int[] solution(int n, int m) {
        int min = n < m ? n : m;
        int num1 = 0;
        for(int i = 1; i <= min; i++) {
            if(n % i == 0 && m % i == 0) {
                num1 = i;
            }
        }
        return new int[]{num1, n * m / num1};
    }
}
