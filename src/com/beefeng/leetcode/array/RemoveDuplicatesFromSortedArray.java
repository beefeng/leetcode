package com.beefeng.leetcode.array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int current = 0;
        int next = 1;
        while (next < nums.length) {
            if (nums[current] == nums[next]) {
                next++;
            } else {
                current++;
                nums[current] = nums[next];
                next++;
            }

        }
        return current + 1;
    }

    public static void main(String[] args) {

        int[] nums;
        nums = new int[]{1, 1, 2};
        RemoveDuplicatesFromSortedArray cal = new RemoveDuplicatesFromSortedArray();
        int result = cal.removeDuplicates(nums);
        System.out.println(result);

        nums = new int[]{1};
        result = cal.removeDuplicates(nums);
        System.out.println(result);

        nums = new int[]{1, 1};
        result = cal.removeDuplicates(nums);
        System.out.println(result);

        nums = new int[]{1, 1, 2, 3, 3};
        result = cal.removeDuplicates(nums);
        System.out.println(result);
    }
}
