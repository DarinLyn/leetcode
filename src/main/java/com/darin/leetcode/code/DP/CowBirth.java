package com.darin.leetcode.code.DP;

/**
 * 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。
 * 第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 */
public class CowBirth {

    /**
     * dp[i] = dp[i-1] + dp[i-3]
     * 今年有多少牛 = 去年有多少牛 + 今年有了多少新牛 ie. 今年有多少成熟牛（三年前有多少牛）
     * @param args
     */
    public static void main(String[] args) {

    }
}
