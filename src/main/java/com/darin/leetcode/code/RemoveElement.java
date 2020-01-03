package com.darin.leetcode.code;

public class RemoveElement {

    /**
     * Official solution
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val){
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Solution 1
     * @param nums
     * @param val
     * @return
     */
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
