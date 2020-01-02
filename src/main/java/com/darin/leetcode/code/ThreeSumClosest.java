package com.darin.leetcode.code;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1, 1, 3};
        int target = -1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length < 3) throw new RuntimeException("no answer");

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int i = 1;  i < len -1; i++){
            int left = 0, right = len - 1;

            while (left < i && i < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(ans - target)) ans = sum;

                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else return ans;
            }
        }

        return ans;
    }
}
