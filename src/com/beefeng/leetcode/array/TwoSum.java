package com.beefeng.leetcode.array;

import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] array, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0, len = array.length; i < len; i++) {
      map.put(array[i], i);
    }

    for (int i = 0, len = array.length; i < len; i++) {
      int current = array[i];
      int toMatch = target - current;
      if (map.containsKey(toMatch) && i != map.get(toMatch)) {
        return new int[] {
            i + 1, map.get(toMatch) + 1
        };
      }
    }
    return new int[] { -1, -1 };
  }

  public static void main(String args[]) {
    int[] numbers = { 2, 5, 7, 11, 15 };
    test(numbers, 9);

    numbers = new int[]{ 0, 0, 0};
    test(numbers, 0);
  }

  public static void test(int[] numbers, int target) {
    int[] result = new TwoSum().twoSum(numbers, target);
    System.out.println(String.format("%d, %d", result[0], result[1]));
  }
}
