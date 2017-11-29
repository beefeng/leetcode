package com.beefeng.leetcode;

import java.util.HashMap;

public class LongestSubstring {

  public static String longestSubstring(String input) {

    HashMap<Character, Integer> map = new HashMap<>();

    int start = 0;
    int maxStart = 0;
    int currentLen = 0;
    int max = 0;
    for(int i = 0, len = input.length(); i < len; i++) {
      char c = input.charAt(i);
      if(map.containsKey(c)) {
        if(i - start > max) {
          maxStart = start;
          max = i - start;
        }
        start = map.get(c) + 1;
        currentLen = i - start;
      } else {
        currentLen++;
      }
      map.put(c, i);
    }

    return input.substring(maxStart , maxStart + max);
  }

  public static void main(String[] args) {
    System.out.println(longestSubstring("abcabcbb"));
    System.out.println(longestSubstring("bbb"));
    System.out.println(longestSubstring("abcdb;afk;ajffafa1230819oi"));
  }
}
