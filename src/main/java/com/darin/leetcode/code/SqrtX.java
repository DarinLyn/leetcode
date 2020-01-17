package com.darin.leetcode.code;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        long left = 0, right = x;
        while (left < right){
            long mid = left + right + 1 >>> 1;
            if(mid*mid > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }
}
