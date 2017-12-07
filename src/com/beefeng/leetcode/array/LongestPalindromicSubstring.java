package com.beefeng.leetcode.array;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();

        if (length == 0) {
            return "";
        }

        int start = 1;
        int end = 1;

        for (int i = 2; i < length * 2 - 1; i += 1) {

            boolean seprate = charAt(s, i) == '#';
            int left = seprate ? i - 1 : i - 2;
            int right = seprate ? i + 1 : i + 2;

            while (left >= 1 && right <= length * 2 && charAt(s, left) == charAt(s, right)) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
                left -= 2;
                right += 2;
            }
        }
        return s.substring(start / 2, end / 2 + 1);
    }

    private char charAt(String s, int index) {
        if (index % 2 == 0) {
            return '#';
        } else {
            return s.charAt(index / 2);
        }
    }
}
