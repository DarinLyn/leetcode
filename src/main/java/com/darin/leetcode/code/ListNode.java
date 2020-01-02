package com.darin.leetcode.code;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val = x;}

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(6);
        l5.next = l6;
        l6.next = l7;
//        System.out.println(l1);
        System.out.println(addTwoNumbers(l1, l5));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerNode = null;
        ListNode loopNode = answerNode;
        ListNode loopNode1 = l1;
        ListNode loopNode2 = l2;
        boolean sumOne = false;
        while (loopNode1 != null || loopNode2 != null || sumOne){
            int sum = (loopNode1!=null?loopNode1.val:0) + (loopNode2!=null?loopNode2.val:0) + (sumOne?1:0);
            ListNode answerNextNode = new ListNode(sum);
            sumOne = sum >= 10;
            if(sumOne){
                answerNextNode = new ListNode(sum-10);
            }
            if(answerNode == null){
                loopNode = answerNode = answerNextNode;
            }else {
                loopNode.next = answerNextNode;
                loopNode = answerNextNode;
            }
            if(loopNode1 != null) {
                loopNode1 = loopNode1.next;
            }if(loopNode2 != null){
                loopNode2 = loopNode2.next;
            }
        }
        return answerNode;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.val + "->");
        ListNode nextCode = this.next;
        while (nextCode != null){
            sb.append(nextCode.val + "->");
            nextCode = nextCode.next;
        }
        return sb.toString().substring(0, sb.length() -2);
    }
}
