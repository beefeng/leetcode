package com.beefeng.leetcode.array;

/**
 * 与第一种情况相比，需考虑首尾相等情况，例如
 * [5,6,5,5,5], [5,6,5,5,5] target=5, 第一次折半无法确定左边还是右边
 * 跳过首尾相同的部分，就容易很多 [5,6,5,5,5] 转化为[6,5]
 * 几种往左走的情况：
 * 1. num[left] < num[right]  未发送折断，常规二分查找即可
 * 2. [5,6,0,1,2,4] [5,6,4,4,4] target = 6 target > nums[left] && nums[middle] <= nums[right]
 * 3. [5,6,7,0,1,4] [6,4,4] target = 6 target >= nums[left] && nums[middle] > target
 * 3. [5,0,1,2,4] [5,6,0] target = 0  target <= nums[right] && nums[middle] > target
 */
public class SearchInRotatedSortedArray2 {


    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public boolean binarySearch(int[] nums, int left, int right, int target) {

        if (left > right) {
            return false;
        }

        int middle = (left + right) / 2;


        int l = nums[left];
        int r = nums[right];
        int m = nums[middle];

        if (m == target) {
            return true;
        } else {

            //跳过收尾相同元素
            boolean skiped = false;
            while (left < right && l == r) {
                if (l == target) {
                    return true;
                } else {
                    left++;
                    right--;
                    skiped = true;
                }

                l = nums[left];
                r = nums[right];
            }

            middle = (left + right) / 2;
            m = nums[middle];
            if (middle != left && m == l) {
                left = middle;
                skiped = true;
            } else  if(middle != right && m == r) {
                right = middle;
                skiped = true;
            }

            if (!skiped) {
                //发生折断
                if(l > r) {
                    if((m >= l && (target < l || target > m)) ||
                            (m < r && target > m && target <= r)) {
                        left = middle + 1;
                    } else {
                        right = middle -1;
                    }
                } else {
                    if(target > m) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
            return binarySearch(nums, left, right, target);
        }
    }
}




