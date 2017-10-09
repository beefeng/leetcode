package com.beefeng.leetcode;

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
    int[] result = new TwoSum().twoSum(numbers, 9);
    System.out.println("=======");
    System.out.println(result[0]);
    System.out.println(result[1] );
  }
}
