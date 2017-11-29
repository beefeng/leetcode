package com.beefeng.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public List<List<Integer>> findTriplets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (i > 0 && first == nums[i - 1]) {
                continue;
            }

            int target = 0 - first;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int second = nums[j];
                int third = nums[k];
                if (second + third > target) {
                    k--;
                } else if (second + third < target) {
                    j++;
                } else if (second + third == target) {
                    result.add(Arrays.asList(new Integer[]{first, second, third}));
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        test(nums);

        nums = new int[]{-2, 0, 0, 2, 2};
        test(nums);

        nums = new int[]{0, 0, 0, 0};
        test(nums);
    }

    public static void test(int[] nums) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.findTriplets(nums);
        for (List<Integer> triplet : result) {
            System.out.println(String.format("%d, %d, %d", triplet.get(0), triplet.get(1), triplet.get(2)));
        }
        System.out.println("");
    }
}
