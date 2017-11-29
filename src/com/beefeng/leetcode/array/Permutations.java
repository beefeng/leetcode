package com.beefeng.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        permute(nums, visited, new ArrayList<Integer>(), result);
        return result;
    }

    public void permute(int[] nums, boolean[] visited, List<Integer> prev, List<List<Integer>> result) {
        if(prev.size() == nums.length) {
            result.add(new ArrayList<Integer>(prev));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                prev.add(nums[i]);
                permute(nums, visited, prev, result);
                visited[i] = false;
                prev.remove(prev.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbs = new int[] {1,2 ,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(numbs);
        printResult(result);

        System.out.println();
        numbs = new int[] {1,2 ,3, 4};
        result = permutations.permute(numbs);
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
