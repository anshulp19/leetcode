import java.util.ArrayList;

/**
 * Created by anshul on 30/07/18.
 *
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
class StockInterval {
    int buy, sell;
}
public class StockBuyAndSell_2 {
    void stockBuySell(int[] prices) {
        if(prices.length <= 1)
            return;
        int count = 0, i = 0, n = prices.length;

        ArrayList<StockInterval> sol = new ArrayList<StockInterval>();

        while (i < n - 1) {
            //local minima
            while((i < n - 1) && (prices[i + 1] <= prices[i]))
                i++;

            if (i == n - 1)
                break;

            StockInterval e = new StockInterval();
            e.buy = i++;

            //local maxima
            while ((i < n - 1) && (prices[i] >= prices[i - 1]))
                i++;

            e.sell = i - 1;
            sol.add(e);
            count++;
        }

        if (count == 0) {
            System.out.println("There is no day when buying the stock will make profit.");
        } else {
            for (int j = 0; j < count; j++) {
                System.out.println("Buy on: " + sol.get(j).buy + "\t Sell on: " + sol.get(j).sell);
            }
        }

        return;
    }

    public static void main(String[] args) {
        StockBuyAndSell_2 s = new StockBuyAndSell_2();
        s.stockBuySell(new int[]{100, 180, 260, 310, 40, 535, 695});
    }
}
