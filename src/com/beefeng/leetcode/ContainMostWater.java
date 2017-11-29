package com.beefeng.leetcode;

public class ContainMostWater {

  public static int mostWater(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      max = Math.max((right - left) * Math.min(height[left],height[right]), max);
      if(height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(mostWater(new int[] { 2,3,4,5,18,17,6 }));
    System.out.println(mostWater(new int[] { 1, 5, 0, 0, 2, 3, 4, 1, 0, 1, 0, 7, 5 }));
  }
}
