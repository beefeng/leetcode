package com.beefeng.leetcode.array;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minGap = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int newTar = target - first;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum2 = nums[j] + nums[k];

                if(sum2 == newTar) {
                    return target;
                } else {
                    if(Math.abs(sum2 - newTar) < Math.abs(minGap)) {
                        minGap = sum2 - newTar;
                    }

                    if(sum2 > newTar) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return target + minGap;
    }


    public static void main(String args[]) {
        int[] nums = new int[]{-1,2, 1, -4};

        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int result =threeSumClosest.threeSumClosest(nums, 1);
        System.out.println(result);


        nums = new int[]{0,0,0};
        result =threeSumClosest.threeSumClosest(nums, 0);
        System.out.println(result);

        nums = new int[]{0 ,2, 1, -4};
        result =threeSumClosest.threeSumClosest(nums, 0);
        System.out.println(result);
    }
}
