package com.darin.leetcode.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        FindTheDuplicateNumber runner = new FindTheDuplicateNumber();
        int[] nums = {3,1,2,1};
        System.out.println(runner.findDuplicate3(nums));
//        nums = new int[]{3,1,3,4,2};
//        System.out.println(runner.findDuplicate3(nums));
    }

    /**
     * Solution 3
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    /**
     * solution 2, using set to find the duplicate num
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }

        return -1;
    }

    /**
     * solution 1, sort and compare
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
