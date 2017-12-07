package com.beefeng.leetcode.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInRotatedSortedArray2Test {

    SearchInRotatedSortedArray2 sortedArray2;

    @Before
    public void setUp() throws Exception {
        sortedArray2 = new SearchInRotatedSortedArray2();
    }

    @Test
    public void search() throws Exception {
        int[] nums = new int[]{};
        assertEquals(sortedArray2.search(nums, 5), false);

        nums = new int[]{3, 1};
        assertEquals(sortedArray2.search(nums, 3), true);

        nums = new int[]{3, 1};
        assertEquals(sortedArray2.search(nums, 1), true);

        nums = new int[]{1, 1, 3, 1};
        assertEquals(sortedArray2.search(nums, 3), true);

        nums = new int[]{3, 1, 1};
        assertEquals(sortedArray2.search(nums, 3), true);

        nums = new int[]{5, 1, 3};
        assertEquals(sortedArray2.search(nums, 5), true);

        nums = new int[]{1, 1, 3};
        assertEquals(sortedArray2.search(nums, 3), true);

        nums = new int[]{5, 6, 7, 0, 1, 2};
        assertEquals(sortedArray2.search(nums, 6), true);

        nums = new int[]{5, 6, 7, 0, 1, 1, 2, 3, 4};
        assertEquals(sortedArray2.search(nums, 2), true);

        nums = new int[]{5, 6, 7, 0, 1, 2};
        assertEquals(sortedArray2.search(nums, 1), true);

        nums = new int[]{5, 6, 5};
        assertEquals(sortedArray2.search(nums, 5), true);

        nums = new int[]{5, 6, 5, 5, 5};
        assertEquals(sortedArray2.search(nums, 6), true);

        nums = new int[]{5, 5, 5, 6, 5};
        assertEquals(sortedArray2.search(nums, 6), true);

        nums = new int[]{5, 1, 3};
        assertEquals(sortedArray2.search(nums, 3), true);
    }
}