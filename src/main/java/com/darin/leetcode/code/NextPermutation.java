package com.darin.leetcode.code;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class NextPermutation {
    public static void main(String[] args) {
        int nums[] = {5,4,3,2,1};
        new NextPermutation().nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /**
     * Official solution
     * 1. find from right to left to get the nums[i] < nums[i+1]
     * 2. find from right to left to get nums[i] < nums[j], then swap nums[i] with nums[j]
     * 3. reverse from i+1 to the end
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j  = nums.length -1;
            while (nums[j]<=nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length-1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Darin's solution
     * @param nums
     */
    public void nextPermutation1(int[] nums) {
        int length = nums.length;
        boolean changed = false;
        int temp;
        for (int j = length - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1] ) { //当出现左元素小于有元素时开始需要数组元素顺序变化
                for (int i = j + 1; i <= (length+j)/2; i++) { //把左元素右边的所有元素反序（因为原来一定是降序，所以现在是升序）排列
                    // 把数组中的元素首尾交换
                    temp = nums[i];
                    nums[i] = nums[length - i + j];
                    nums[length - i + j] = temp;
                    if(!changed&&nums[i]>nums[j]){
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        changed = true;
                    }
                }
                if(!changed){
                    for(int i = (length+j)/2+1; i < length; i++){
                        if(nums[i] > nums[j]){
                            temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            changed = true;
                            break;
                        }
                    }
                }
                break;
            }
        }
        if(!changed){
            for(int i = 0; i < length/2; i++) {
                // 把数组中的元素首尾交换
                temp = nums[i];
                nums[i] = nums[length - i - 1];
                nums[length - i - 1] = temp;
            }
        }
    }
}
