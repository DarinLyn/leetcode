package com.darin.leetcode.code;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定的 n 保证是有效的。
 */
public class RemoveNthNodeFromEndOfList {

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

        ListNode ans = new RemoveNthNodeFromEndOfList().removeNthFromEnd(l1, 2);
        System.out.println(ans);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for(int i = 1; i < n + 1; i++){
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if(n == 1&&head.next==null) return null;

        ListNode node = head;

        int length = 1;
        while (node.next != null){  //统计链表长度
            node = node.next;
            length++;
        }

        int index = length + 1 - n;  //计算要删除的节点的顺序长度

        int i = 1;
        if(index == 1) head = head.next;
        node = head;
        ListNode ansHead = new ListNode(head.val);
        ListNode loopNode = ansHead;
        while (node.next != null){  //删除该节点
            if(++i != index) {
                loopNode.next = new ListNode(node.next.val);
                loopNode = loopNode.next;
            }
            node = node.next;
        }

        return ansHead;
    }
}
