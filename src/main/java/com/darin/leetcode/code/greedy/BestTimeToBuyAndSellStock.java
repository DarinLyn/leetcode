package com.darin.leetcode.code.greedy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int bidPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < bidPrice){ //如果今天的价格之前看中的买入价更低，则更新今天的价格为买入价
                bidPrice = prices[i];
            }else {
                maxProfit = Math.max(maxProfit, prices[i] - bidPrice);
            }
        }

        return maxProfit;
    }
}
