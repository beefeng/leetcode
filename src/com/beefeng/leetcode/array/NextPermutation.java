package com.beefeng.leetcode.array;

import com.beefeng.leetcode.util.Utils;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        boolean found = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    reverse(nums, i + 1, nums.length - 1);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        if (!found) {
            reverse(nums, 0, nums.length - 1);
            for (int i = 0; i <= nums.length / 2; i++) {
                swap(nums, i, nums.length - 1 - i);
            }
        }
    }

    private void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int nums[], int start, int end) {
        for (int i = start; i <= start + (end - start) / 2; i++) {
            swap(nums, i, end - (i - start));
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);

        System.out.println();
        nums = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);

        System.out.println();
        nums = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);

        System.out.println();
        nums = new int[]{1, 1, 5};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);

        System.out.println();
        nums = new int[]{1};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);

        System.out.println();
        nums = new int[]{1, 3};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);


        System.out.println();
        nums = new int[]{2, 2, 0, 4, 3, 1};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);

        System.out.println();
        nums = new int[]{1, 7, 8, 5, 7, 4, 1, 8, 5, 9, 7, 5};
        nextPermutation.nextPermutation(nums);
        Utils.printArray(nums);
    }
}
