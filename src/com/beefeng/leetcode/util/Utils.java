package com.beefeng.leetcode.util;

import java.util.List;

public class Utils {
    public static void printArray(int[] array){
        for (Object o : array) {
            System.out.print(o.toString() + ',');
        }
    }

    public static <T> void printList(List<T> list) {
        for (Object obj : list) {
            if(obj instanceof List) {
                for (Object o : (List) obj) {
                    System.out.print(o + ",");
                }
                System.out.println();
            } else {
                System.out.print(obj + "");
            }
        }

        System.out.println();
    }

    public static ListNode createLinkedList(int[] nums) {
        ListNode head = null;

        ListNode current = null;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if(head == null) {
                head = new ListNode(value);
                current = head;
            } else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return head;
    }
}
