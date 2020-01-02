package com.darin.leetcode.code;

import java.util.*;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        l7.next = l8;

        ListNode[] nodeArr = {l1, l4, l7};
        System.out.println(new MergeKSortedLists().mergeKLists(nodeArr));

    }

    /**
     * solution 4: improve solution 3
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;
        while(n>1){
            int m=(n+1)/2; //当前数组长度的一半
            for(int i=0;i<n/2;i++){ //是n/2
                lists[i]=mergeTwoLists(lists[i],lists[i+m]);
            }
            n=m;
        }
        return lists[0];
    }

    /**
     * solution 3: merge list node one by one using mergeTwoLists method
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode ansNode = new ListNode(Integer.MIN_VALUE);
        for(ListNode node : lists){
            ansNode = mergeTwoLists(ansNode, node);
        }

        return ansNode.next;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode temp = first;
        while(l1!=null&&l2!=null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;

        return first.next;
    }

    /**
     * solution 2, use PriorityQueue to sort the value then poll to generate list node
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(ListNode node: lists){
            while (node!=null){
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode ansNode = new ListNode(0);
        ListNode temp = ansNode;
        while(!queue.isEmpty()){
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }
        return ansNode.next;
    }

    /**
     * solution 1, collect all value into a sorted list then build a list node
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> valList = new ArrayList<>();
        for(ListNode node : lists){
            while (node!=null){
                valList.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(valList);
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for(int i: valList){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        return result.next;
    }
}
