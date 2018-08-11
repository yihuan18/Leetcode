public class MaxProfit {
    public int maxProfit(int[] prices) {
        int buyIndex = 0 , sellIndex = 1;
        int profit = 0;
        if(prices.length <= 1)
            return 0;
        for(int i = 0 ; i < prices.length ; i++){
            if(prices[buyIndex] < prices[sellIndex]){
                if(sellIndex == prices.length - 1){
                    profit += prices[sellIndex] - prices[buyIndex];
                    buyIndex = sellIndex + 1;
                    sellIndex = buyIndex + 1;
                    break;
                }
                else if(prices[sellIndex] > prices[sellIndex+1]){
                    profit += prices[sellIndex] - prices[buyIndex];
                    buyIndex = sellIndex + 1;
                    sellIndex = buyIndex + 1;
                }
                else sellIndex++;
            }
            else if(prices[buyIndex] >= prices[sellIndex]){
                buyIndex++;
                sellIndex++;
            }
            if(sellIndex == prices.length)
                break;
        }
        return profit;
    }

    public static void main(String[] args){
        MaxProfit maxProfit = new MaxProfit();
        int prices[] = {7,6,4,3,1};
        int ret = maxProfit.maxProfit(prices);
        System.out.print(ret);
    }
}
