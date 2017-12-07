package com.beefeng.leetcode.array;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
       return searchRange(nums, 0, nums.length - 1, target);
    }

    public int[] searchRange(int[] nums, int start, int end, int target) {
        int i = binarySearch(nums, start, end, target);

        if (i < 0) {
            return new int[]{-1, -1};
        } else {
            int[] left = searchRange(nums, start, i - 1, target);
            int[] right = searchRange(nums, i + 1, end, target);
            return new int[]{left[0] >= 0 ? left[0] : i, Math.max(i, right[1])};
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return binarySearch(nums, middle + 1, end, target);
        } else {
            return binarySearch(nums, start, middle - 1, target);
        }
    }
}
