package array;

public class StockProfit {
  public int maxProfit(int[] prices) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (prices.length <= 1)
      return 0;
    int buyDate = 0;
    int tempProfit = prices[1] - prices[0];
    for (int i = 1; i <= prices.length - 1; i++) {
      if (prices[i] < prices[buyDate]) {
        buyDate = i;
      }
      if (prices[i] - prices[buyDate] > tempProfit) {
        tempProfit = prices[i] - prices[buyDate];
      }
    }
    return tempProfit;
  }
}
