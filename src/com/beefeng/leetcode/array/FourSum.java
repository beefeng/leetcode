package com.beefeng.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i+ 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int k = j + 1;
                int l = nums.length - 1;

                int newTar = target - nums[i] - nums[j];
                while (k < l) {
                    if(k > j + 1 && nums[k] == nums[k -1]) {
                        k++;
                        continue;
                    }

                    int sum2 = nums[k] + nums[l];
                    if (sum2 == newTar) {
                        result.add(new ArrayList<>(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k], nums[l]})));
                        l--;
                        k++;
                    } else if (sum2 > newTar) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1,  1, 0, -2, 2};

        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSum(nums, 0);
        for (List<Integer> triplet : result) {
            System.out.println(String.format("%d, %d, %d, %d", triplet.get(0), triplet.get(1), triplet.get(2), triplet.get(3)));
        }
        System.out.println("");

    }
}
