package com.beefeng.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchForARangeTest {

    SearchForARange searchForARange;

    @Before
    public void setUp() throws Exception {
        searchForARange = new SearchForARange();
    }

    @Test
    public void searchRange() throws Exception {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[]  result = searchForARange.searchRange(nums, 8);
        Assert.assertArrayEquals(new int[]{3, 4}, result);

        nums = new int[]{8,8,8,8,8,8};
        result = searchForARange.searchRange(nums, 8);
        Assert.assertArrayEquals(new int[]{0, 5}, result);

        nums = new int[]{};
        result = searchForARange.searchRange(nums, 8);
        Assert.assertArrayEquals(new int[]{-1, -1}, result);

        nums = new int[]{1,1,2,3,4,5,5};
        result = searchForARange.searchRange(nums, 6);
        Assert.assertArrayEquals(new int[]{-1, -1}, result);

        nums = new int[]{1,1,2,3,4,5,5};
        result = searchForARange.searchRange(nums, 5);
        Assert.assertArrayEquals(new int[]{5, 6}, result);
    }

}