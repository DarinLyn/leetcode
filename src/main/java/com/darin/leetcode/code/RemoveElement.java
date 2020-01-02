package com.darin.leetcode.code;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int count = nums[0] == val?1:0;
        for (int j = 1; j < nums.length; j++){
            if(nums[j]!=val){
                nums[j-count] = nums[j];
            }else {
                count++;
            }
        }
        return nums.length - count;
    }
}
