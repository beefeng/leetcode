package com.beefeng.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindrome() throws Exception {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        Assert.assertEquals("bab", test.longestPalindrome("babad"));

        Assert.assertEquals("b", test.longestPalindrome("b"));
        Assert.assertEquals("b", test.longestPalindrome("bad"));
        Assert.assertEquals("", test.longestPalindrome(""));
        Assert.assertEquals("bbbb", test.longestPalindrome("bbbb"));
    }

}