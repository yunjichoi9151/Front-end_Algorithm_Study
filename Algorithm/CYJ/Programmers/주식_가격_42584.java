public class 주식_가격_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
}
