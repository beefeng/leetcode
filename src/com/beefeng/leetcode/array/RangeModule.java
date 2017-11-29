package com.beefeng.leetcode.array;

import java.util.ArrayList;
import java.util.List;

class RangeModule {

    List<Integer[]> gaps;

    public RangeModule() {
        gaps = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        int leftIndex = find(left);
        int rightIndex = find(right);

        int newLeft = left;
        int newRight = right;

        int i = rightIndex;
        for (; i >= leftIndex && i >= 0; i--) {
            if (gaps.get(i)[1] < newLeft) {
                break;
            }

            if (gaps.get(i)[1] > newRight) {
                newRight = gaps.get(i)[1];
            }

            if (gaps.get(i)[0] <= newLeft) {
                newLeft = gaps.get(i)[0];
            }
            gaps.remove(i);
        }
        gaps.add(i + 1, new Integer[]{newLeft, newRight});
    }

    public boolean queryRange(int left, int right) {
        int leftIndex = find(left);
        int rightIndex = find(right);
        return leftIndex >= 0 && leftIndex == rightIndex && gaps.get(leftIndex)[1] > left && gaps.get(rightIndex)[1] >= right;
    }

    public void removeRange(int left, int right) {
        addRange(left, right);

        int leftIndex = find(left);

        if (gaps.get(leftIndex)[0] == left) {
            int end = gaps.get(leftIndex)[1];
            gaps.remove(leftIndex);
            gaps.add(leftIndex, new Integer[]{right, end});
        } else if (gaps.get(leftIndex)[1] == right) {
            int start = gaps.get(leftIndex)[0];
            gaps.remove(leftIndex);
            gaps.add(leftIndex, new Integer[]{start, left});
        } else {
            int start = gaps.get(leftIndex)[0];
            int end = gaps.get(leftIndex)[1];
            gaps.remove(leftIndex);
            gaps.add(leftIndex, new Integer[]{right, end});
            gaps.add(leftIndex, new Integer[]{start, left});
        }

    }

    private int find(int target) {
        return binarySearch(gaps, 0, gaps.size() - 1, target);
    }

    private int binarySearch(List<Integer[]> gaps, int start, int end, int target) {

        int middle = (start + end) / 2;

        if (start > end) {

            return start - 1;
        }

        int middleValue = gaps.get(middle)[0];

        if (middleValue == target) {
            return middle;
        } else if (middleValue < target) {
            return binarySearch(gaps, middle + 1, end, target);
        } else {
            return binarySearch(gaps, start, middle - 1, target);
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        List<Integer[]> nums = new ArrayList<>();
        nums.add(new Integer[]{1, 2});
        nums.add(new Integer[]{3, 5});
        nums.add(new Integer[]{5, 8});
        nums.add(new Integer[]{10, 11});
        nums.add(new Integer[]{13, 15});
        nums.add(new Integer[]{2, 14});

        rangeModule.addRange(1, 2);
        rangeModule.addRange(3, 5);
        rangeModule.addRange(5, 8);
        rangeModule.addRange(10, 11);
        rangeModule.addRange(13, 15);
        rangeModule.addRange(12, 14);
        printList(rangeModule.gaps);

        rangeModule.removeRange(6, 13);
        printList(rangeModule.gaps);
    }

    private static void printList(List<Integer[]> list) {
        for (Integer[] integers : list) {
            System.out.print(String.format("[%d,%d) , ", integers[0], integers[1]));
        }
        System.out.println();
    }
}
