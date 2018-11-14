/*
Q121 买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
 */

public class MaxProfitI {
    public int maxProfit(int[] prices) {
        if(0 == prices.length)
            return 0;
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuy)
                minBuy = prices[i];
            else maxProfit = (prices[i] - minBuy) > maxProfit ? (prices[i] - minBuy) : maxProfit;
        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        MaxProfitI maxProfit = new MaxProfitI();
        int ret = maxProfit.maxProfit(prices);
        System.out.print(ret);
    }

}
