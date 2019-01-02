/*
Leetcode Q322 : 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。
编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] coinNums = new int[amount+1];
        for(int i = 1 ; i < coinNums.length ; i++)
            coinNums[i] = amount + 1;
        coinNums[0] = 0;
        Arrays.sort(coins);
        for(int total = 1 ; total <= amount ; total++){
            for(int i = 0 ; i < coins.length && coins[i] <= total ; i++)
                coinNums[total] = Math.min(coinNums[total],coinNums[total-coins[i]] + 1);
        }
        if(coinNums[amount] == (amount+1))
            return -1;
        else return coinNums[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int coins[] = {1,2,5};
        int amount = 11;
        System.out.println(cc.coinChange(coins,amount));
    }
}