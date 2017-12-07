package com.beefeng.leetcode.list;

import com.beefeng.leetcode.util.ListNode;
import com.beefeng.leetcode.util.Utils;
import org.junit.Assert;
import org.junit.Test;

public class RemoveNthNodeFromEndofListTest {

    @Test
    public void removeNthFromEnd() throws Exception {
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();

        ListNode list = Utils.createLinkedList(new int[]{1, 2, 3, 4, 5});

        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 2);
        Assert.assertEquals(1, list.val);
        Assert.assertEquals(2, (list = list.next).val);
        Assert.assertEquals(3, (list = list.next).val);
        Assert.assertEquals(5, (list = list.next).val);
        Assert.assertEquals(null, list.next);

        list = Utils.createLinkedList(new int[]{1, 2});
        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 3);
        Assert.assertEquals(1, list.val);
        Assert.assertEquals(2, (list = list.next).val);
        Assert.assertEquals(null, list.next);

        list = Utils.createLinkedList(new int[]{1, 2});
        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 3);
        Assert.assertEquals(1, list.val);
        Assert.assertEquals(2, (list = list.next).val);
        Assert.assertEquals(null, list.next);

        list = Utils.createLinkedList(new int[]{1});
        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 0);
        Assert.assertEquals(1, list.val);
        Assert.assertEquals(null, list.next);

        list = Utils.createLinkedList(new int[]{1});
        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 1);
        Assert.assertEquals(null, list);

        list = Utils.createLinkedList(new int[]{1,2,3});
        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 1);
        Assert.assertEquals(1, list.val);
        Assert.assertEquals(2, (list = list.next).val);
        Assert.assertEquals(null, list.next);

        list = Utils.createLinkedList(new int[]{1,2,3});
        list = removeNthNodeFromEndofList.removeNthFromEnd(list, 3);
        Assert.assertEquals(2, list.val);
        Assert.assertEquals(3, (list = list.next).val);
        Assert.assertEquals(null, list.next);
    }

}