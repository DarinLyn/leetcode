package com.darin.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length < 3) return result;
        Arrays.sort(nums);

        for(int index = 0; index<nums.length&&nums[index]<=0; index++){ //如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
            if(index>0&&nums[index] == nums[index - 1]) continue; //如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
            int left = index + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[index] + nums[left] + nums[right];
                if(sum < 0) left++; //当 sum = 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
                if(sum > 0) right--; //当 sum = 0 时，nums[R] = nums[R−1] 则会导致结果重复，应该跳过，R−−
                if(sum == 0){
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    while(nums[left] == nums[left+1]) left++;
                    while(nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
