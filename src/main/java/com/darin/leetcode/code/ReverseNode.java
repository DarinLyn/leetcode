package com.darin.leetcode.code;

public class ReverseNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(l1);
        System.out.println(reverse(l1));
    }

    /**
     * 反转listNode，pre是反转后listNode；curr是当前尚未反转的listNode
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre = null; //保存结果
        while (head != null){
            ListNode next = head.next; //将从第二个node开始的链表保存起来
            head.next = pre; //将当前第一个node放在刚刚拿到的头node前面，形成反转 例: 2 -> 1
            pre = head;
            head = next;
        }

        return pre;
    }
}
