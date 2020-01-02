package com.darin.leetcode.code;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        if(nums.length == 0) return 0;
        int min = Integer.MIN_VALUE;
        int count = 0;
        int curr = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == curr) {
                nums[i] = min;
                count++;
            }else {
                curr = nums[i];
            }
        }
        int dCount = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == min){
                dCount++;
            }else {
                int temp = nums[i];
                nums[i] = min;
                nums[i-dCount] = temp;
            }

        }
        return nums.length - count;
    }
}
