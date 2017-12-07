package com.beefeng.leetcode.array;

import com.beefeng.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, new ArrayList<Integer>(), result, target);
        return result;
    }

    public void combinationSum(int[] candidates, int start, List<Integer> tempList, List<List<Integer>> result, int target) {
        if(target < 0) {
            return;
        } else if( target == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                int current = candidates[i];
                tempList.add(current);
                combinationSum(candidates, i, tempList, result, target - current);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        List<List<Integer>> result = sum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        Utils.printList(result);

        result = sum.combinationSum(new int[]{2, 6, 7}, 7);
        Utils.printList(result);

        result = sum.combinationSum(new int[]{2, 6, 7}, 10);
        Utils.printList(result);

        result = sum.combinationSum(new int[]{8, 7, 4, 3}, 11);
        Utils.printList(result);

        result = sum.combinationSum(new int[]{4, 2, 8}, 8);
        Utils.printList(result);
    }
}
