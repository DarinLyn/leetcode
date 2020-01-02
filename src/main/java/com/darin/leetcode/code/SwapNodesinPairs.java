package com.darin.leetcode.code;

import java.util.Stack;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class SwapNodesinPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(l1);
        System.out.println(new SwapNodesinPairs().swapPairs(l1));
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = head.next; //与node.next = head 形成头两位node位置交换
        head.next = swapPairs(node.next); //将第三位开始的list node递归进行位置交换
        node.next = head;
        return node;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    /**
     * solution 1: a tricky way?
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode loop = ans;
        Stack<ListNode> stack = new Stack<>();

        while (head != null){
            stack.push(new ListNode(head.val));
            if(stack.size() == 2){
                loop.next = stack.pop();
                loop = loop.next;
                loop.next = stack.pop();
                loop = loop.next;
            }
            head = head.next;
        }
        if(!stack.isEmpty()) loop.next = stack.pop();

        return ans.next;
    }
}
