package com.beefeng.leetcode.array;

import com.beefeng.leetcode.util.Utils;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if(nums[left] == val) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, 3));
        Utils.printArray(nums);

        System.out.println();

        nums = new int[]{1};
        System.out.println(removeElement.removeElement(nums, 1));
        Utils.printArray(nums);
    }
}
