package com.darin.leetcode.code;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l4));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode temp = first;
        while(l1!=null&&l2!=null){
            if(l1.val <= l2.val){
//                temp.next = new ListNode(l1.val);
                temp.next = l1;
                l1 = l1.next;
            }else {
//                temp.next = new ListNode(l2.val);
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;

        return first.next;
    }
}
