package com.darin.leetcode.code;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(new SearchInRotatedSortedArray().search(nums, 1));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (left + right)/2;

        while (left <= right) {
            if(nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) { //左边纯升序
                if (target >= nums[left] && target < nums[mid]) { //在左边
                    right = mid - 1;
                } else { //在右边
                    left = mid + 1;
                }
            } else { //右边纯升序
                if (target > nums[mid] && target <= nums[right]) { //在右边
                    left = mid + 1;
                } else { //在左边
                    right = mid - 1;
                }
            }
            mid = left + (right-left)/2;
        }

        return -1;
    }
}
