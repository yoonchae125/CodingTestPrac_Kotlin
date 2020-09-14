package programmers_practice.level2;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            int j;
            for (j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    count = j - i;
                    break;
                }
            }
            if (count == 0)
                answer[i] = j - i - 1;
            else answer[i] = count;
        }
        return answer;
    }
}
