package com.beefeng.leetcode.list;


import com.beefeng.leetcode.util.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0) {
            return head;
        }

        ListNode headPoint = new ListNode(-1);
        headPoint.next = head;

        ListNode prevNode = headPoint;
        while (n > 0) {
            prevNode = prevNode.next;
            if(prevNode == null) {
                return head;
            }
            n--;
        }

        ListNode tailNode = headPoint;
        while (prevNode.next != null) {
            tailNode = tailNode.next;
            prevNode = prevNode.next;
        }

        tailNode.next = tailNode.next.next;
        return headPoint.next;
    }
}
