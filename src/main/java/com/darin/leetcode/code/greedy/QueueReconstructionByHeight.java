package com.darin.leetcode.code.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 */
public class QueueReconstructionByHeight {

    public static void main(String[] args) {

    }

    /**
     * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
     * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，因为低个对于高个不影响。
     * 例:
     * [7,0] [6,1] [7,1]
     * 和在填充h=5的同学后一样成立
     * [5,0] [7,0] [5,2] [6,1] [7,1]
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1]: o2[0] - o1[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] p: people){
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][]);
    }
}
