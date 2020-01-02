package com.darin.leetcode.code;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//
//        nums1 = new int[]{1, 2};
//        nums2 = new int[]{3, 4};
//        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[0];
        nums2 = new int[]{1};

//        nums1 = new int[]{2, 5, 8, 9, 10};
//        nums2 = new int[]{1, 3, 7, 11};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] integrated = new int[totalLength];
        boolean isOdd = totalLength % 2 == 1;
        boolean isOutOfBounds1 = nums1.length == 0;
        boolean isOutOfBounds2 = nums2.length == 0;

        for (int index1 = 0, index2 = 0, i = 0; i < totalLength; i++) {
            if ((isOutOfBounds1?Integer.MAX_VALUE:nums1[index1]) > (isOutOfBounds2?Integer.MAX_VALUE:nums2[index2])) {
                integrated[i] = nums2[index2];
                if(++index2 == nums2.length) isOutOfBounds2 = true;
            } else {
                integrated[i] = nums1[index1];
                if(++index1 == nums1.length) isOutOfBounds1 = true;
            }

            if (i == totalLength / 2) {
                if(isOdd){
                    return integrated[i];
                }else {
                    return (integrated[i]+integrated[i-1])/2.0;
                }
            }
        }
        throw new RuntimeException("");
    }

    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }
}
