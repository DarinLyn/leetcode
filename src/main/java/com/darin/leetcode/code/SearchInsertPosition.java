package com.darin.leetcode.code;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        System.out.println(new SearchInsertPosition().searchInsert(nums, 8));

    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length; //右边界要为len，因为有越界的情况

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len;

        while (left < right) { //left<right的跳出情况为left==right此时不用纠结
            int mid = left + (right - left) / 2; //左中位数
            if (nums[mid] < target) { //在右边，mid已经看过了不等于，所以mid+1
                left = mid + 1;
            } else { //在右边，由于mid有可能等于target，所以right要等于mid
                right = mid;
            }
        }
        return left;
    }
}
