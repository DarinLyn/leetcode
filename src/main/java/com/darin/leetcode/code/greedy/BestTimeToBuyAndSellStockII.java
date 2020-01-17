package com.darin.leetcode.code.greedy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * 当今天的价格比昨天低，则更新买入价；若比昨天的高，卖出，再以今天的价格买入
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int buyingPrice = prices[0];
        int totalProfit = 0;
        for(int i = 1; i < prices.length; i++){ //如果今天价格大于买入价，则卖出并买入
            if(prices[i] > buyingPrice){
                totalProfit += prices[i] - buyingPrice;
            }
            buyingPrice = prices[i];
        }

        return totalProfit;
    }
}
