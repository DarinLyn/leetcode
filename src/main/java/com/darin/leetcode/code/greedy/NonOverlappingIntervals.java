package com.darin.leetcode.code.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 */
public class NonOverlappingIntervals {

    /**
     * 按照数组的的结尾值排序，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     * 以上是关键！！找到局部最佳的合理接入点
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (o1, o2) -> (o1[1] - o2[1]));

        int cnt = 1, end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end) continue; //如果现在看得区间开头小于当前结尾，表示有重叠，看下一区间
            end = intervals[i][1]; //没有重叠了，结尾换成当前区间的结尾
            cnt++;
        }
        return intervals.length - cnt;
    }
}
