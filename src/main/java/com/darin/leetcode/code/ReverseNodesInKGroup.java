package com.darin.leetcode.code;

import java.util.ArrayDeque;

public class ReverseNodesInKGroup {

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
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(l1, 4));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null){
            for(int i = 0; i < k && end!= null; i++) end = end.next;
            if(end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            end = pre = start;
        }

        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break; //当end的node数不够k循环就跳出
            ListNode start = pre.next; //右移一位，因为有0->
            ListNode next = end.next; //右移一位，因为有0->
            end.next = null; //把start的尾巴也清掉
            pre.next = reverse(start); //把k位反转后的给dummy
            start.next = next; //将k位后的nodes给pre和end
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    /**
     * 反转listNode，pre是反转后listNode；curr是当前尚未反转的listNode
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre = null; //保存结果
        while (head != null){
            ListNode next = head.next; //将从第二个node开始的链表保存起来，等下赋值给head继续遍历
            head.next = pre; //将当前第一个node放在刚刚拿到的头node前面，形成反转 例: 2 -> 1
            pre = head;
            head = next;
        }

        return pre;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode loop = ans;
        ArrayDeque<ListNode> list = new ArrayDeque<>();

        while (head != null){
            list.push(new ListNode(head.val));
            if(list.size() == k){
                while (!list.isEmpty()){
                    loop.next = list.pollFirst();
                    loop = loop.next;
                }
            }
            head = head.next;
        }
        while (!list.isEmpty()){
            loop.next = list.pollLast();
            loop = loop.next;
        }

        return ans.next;
    }
}
