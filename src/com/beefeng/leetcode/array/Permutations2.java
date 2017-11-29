package com.beefeng.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        permute(nums, visited, new ArrayList<Integer>(), result);
        return result;
    }

    public void permute(int[] nums, boolean[] visited, List<Integer> prev, List<List<Integer>> result) {
        if (prev.size() == nums.length) {
            result.add(new ArrayList<>(prev));
            return;
        }

        HashSet<Integer> d = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (d.contains(nums[i])) {
                    continue;
                } else {
                    d.add(nums[i]);
                }

                visited[i] = true;
                prev.add(nums[i]);
                permute(nums, visited, prev, result);
                visited[i] = false;
                prev.remove(prev.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbs = new int[]{1, 1, 2};
        Permutations2 permutations = new Permutations2();
        List<List<Integer>> result = permutations.permuteUnique(numbs);
        printResult(result);

        System.out.println();
        numbs = new int[]{1, 2, 3, 4};
        result = permutations.permuteUnique(numbs);
        printResult(result);
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
