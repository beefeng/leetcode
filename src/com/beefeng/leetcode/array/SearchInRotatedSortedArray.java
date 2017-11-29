package com.beefeng.leetcode.array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {

        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        int current = nums[middle];
        if (current == target) {
            return middle;
        } else if ((current > nums[right] && (target > current || target <= nums[right]))
                || (current < nums[right] && (target <= nums[right] && target > current))) {
            return binarySearch(nums, middle + 1, right, target);
        } else {
            return binarySearch(nums, left, middle - 1, target);
        }
    }


    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        System.out.println(test.search(nums, 5));

        nums = new int[]{5, 1, 3};
        System.out.println(test.search(nums, 5));

        nums = new int[]{1, 3};
        System.out.println(test.search(nums, 3));

        nums = new int[]{1, 3, 5};
        System.out.println(test.search(nums, 1));
    }
}
