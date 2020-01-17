package com.darin.leetcode.code;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + right >>> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
