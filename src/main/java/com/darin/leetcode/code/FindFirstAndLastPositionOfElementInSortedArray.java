package com.darin.leetcode.code;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 3, 8};

        int ans [] = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 3);
        for(int i: ans){
            System.out.print(i + " ");
        }
    }


    /**
     * solution 2
     * 1. 初始化返回值为{-1， -1}
     * 2. 生成左边界
     * 3. 如果左边界等于数组长度或者左边界不等于目标值则说明目标值太大或太小
     * 4. 生成右边界
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int leftIndex = extremeInsertionIndex(nums, target, true);

        if(leftIndex == nums.length || nums[leftIndex] != target){
            return ans;
        }

        ans[0] = leftIndex;
        ans[1] = extremeInsertionIndex(nums, target, false) - 1;
        return ans;
    }

    /**
     * 获取左右边界
     * @param nums
     * @param target
     * @param left
     * @return
     */
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int leftFlag = 0;
        int rightFlag = nums.length;

        while (leftFlag < rightFlag){
            int midFlag = (leftFlag + rightFlag)/2;
            if(nums[midFlag] > target || (left && nums[midFlag] == target)){ //要找的边接值在左边。1. 当找左边界的时候如果目标与mid值相等也左移 2. 当找左边界的时候如果目标与mid值相等就右移
                rightFlag = midFlag;
            }else { //要找的边界值在右边
                leftFlag = midFlag + 1;
            }
        }
        return leftFlag;
    }

    /**
     * solution 1
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = 0, right = nums.length-1, mid = (left + right)/2;

        while (left <= right){
            if(target == nums[mid]){ //已经踩到目标值区间
                left = right = mid;
                while (left>=0 || right<=nums.length-1){
                    if(right<=nums.length-1 && nums[right] == target){
                        right++;
                    }else if(left>=0 && nums[left] == target){
                        left--;
                    }else {
                        break;
                    }
                }
                ans = new int[]{left+1, right-1};

                return ans;
            }

            if(target < nums[mid]){ //开始与结束都在右边
                right = mid - 1;
            }else { //开始与结束都在左边
                left = mid + 1;
            }
            mid = left + (right-left)/2;
        }

        return ans;
    }
}
