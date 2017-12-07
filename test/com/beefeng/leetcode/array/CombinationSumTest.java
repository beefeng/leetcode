package com.beefeng.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CombinationSumTest {

    @Test
    public void combinationSum() throws Exception {
        CombinationSum combinationSum = new CombinationSum();

        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = combinationSum.combinationSum(nums, 7);
        Assert.assertEquals(2, result.size());
    }

}