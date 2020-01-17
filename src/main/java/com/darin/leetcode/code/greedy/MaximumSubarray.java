package com.darin.leetcode.code.greedy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-4,-2,-3, -1};
//        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int currentSum = nums[0];
        int maxSum = currentSum;
        for (int i = 1; i < nums.length; i++) {
            currentSum = currentSum > 0 ? currentSum + nums[i] : nums[i]; //如果现和大于零，那就加上现值；如果现和小于零，那就换成现值
            maxSum = Math.max(maxSum, currentSum); //如果大于了最大值就更新
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]>0){ //如果nums[1]大于零，果断加上
                temp += nums[i];
                max = Math.max(max, temp);
            }else { //如果nums[1]小于零
                if(nums[i]>max){ //如果大于最大值，说明最大值也是个负数，更新一下
                    max = nums[i];
                }
                if(temp+nums[i]>=0){ //如果之前的总和和现在加起来还大于零，那就先加上  4,-3
                    temp += nums[i];
                }else { //3, -4
                    temp = 0;
                }
            }
        }
        return max;
    }
}
