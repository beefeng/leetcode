package com.beefeng.leetcode;

/**
 * ID: 4
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        if ((m + n) % 2 == 1) {
            findKthTwoSortedArrays(nums1, nums2, (m + n) / 2);
        } else {
            findKthTwoSortedArrays(nums1, nums2, (m + n) / 2);
        }


        return 0;
    }


    public int findKthTwoSortedArrays(int[] nums1, int[] nums2, int k) {

        return 0;
    }


    public static void main(String[] args) {

    }


}
