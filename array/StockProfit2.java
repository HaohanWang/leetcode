package array;

public class StockProfit2 {
  public int maxProfit(int[] prices) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (prices.length<=1)
        return 0;
    int buyDate = 0;
    int length=prices.length-1;
    int totalMax = 0;
    for (int i=1;i<=length-1;i++){
        if (prices[i]<prices[buyDate]){
            buyDate=i;
        }
        if (prices[i]>=prices[i-1]&&prices[i]>=prices[i+1]){
            int firstMax = prices[i]-prices[buyDate];
            int secondMax = 0;
            int buyDate2=i+1;
            for (int j = i+2; j<=length;j++){
                if (prices[j]<prices[buyDate2]){
                    buyDate2 = j;
                }
                if (prices[j]-prices[buyDate2]>secondMax){
                    secondMax = prices[j]-prices[buyDate2];
                }
            }
            if (totalMax<firstMax+secondMax){
                totalMax = firstMax+secondMax;
            }
        }
    }
    if (totalMax<prices[length]-prices[buyDate]){
        totalMax=prices[length]-prices[buyDate];
    }
    return totalMax;
}
}
