package com.beefeng.leetcode;

public class AddTwoNum {

  public static class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
      this.value = value;
    }
  }


  public ListNode addTwoNum(ListNode list1, ListNode list2) {
    ListNode result = null;
    ListNode pre = null;
    int sum = 0;
    while (list1 != null || list2 != null) {
      if(list1 != null) {
        sum += list1.value;
        list1 = list1.next;
      }

      if(list2 != null) {
        sum += list2.value;
        list2 = list2.next;
      }

      int bit = sum % 10;
      sum /= 10;
      if(result == null) {
        result = new ListNode(bit);
        pre = result;
      } else {
        pre.next = new ListNode(bit);
        pre = pre.next;
      }
    }

    if(sum == 1) {
      pre.next = new ListNode(1);
    }
    return result;
  }



  static ListNode createList(int[] numbers) {
    ListNode header = null;
    ListNode pre = null;
    for (int i = 0; i < numbers.length; i++) {
      if(header == null) {
        header = new ListNode(numbers[i]);
        pre = header;
      } else {
        pre.next = new ListNode(numbers[i]);
        pre = pre.next;
      }
    }
    return header;
  }

  public static void main(String[] args) {
    AddTwoNum addTwoNum = new AddTwoNum();

    ListNode list1 = createList(new int[]{2, 4, 3});
    ListNode list2 = createList(new int[]{5, 6, 6});
    ListNode result = addTwoNum.addTwoNum(list1, list2);

    System.out.print("{" + result.value);
    result = result.next;

    while (result != null) {
      System.out.print("->" + result.value);
      result = result.next;
    }
    System.out.println("}");
  }
}
