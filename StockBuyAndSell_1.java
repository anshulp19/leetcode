/**
 * Created by anshul on 26/07/18.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class StockBuyAndSell_1 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        StockBuyAndSell_1 s = new StockBuyAndSell_1();

        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{100, 180, 260, 310, 40, 535, 695}));
    }
}
