package com.beefeng.leetcode.array;

import com.beefeng.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                combinationSum(candidates, i + 1, tempList, result, target - current);
                tempList.remove(tempList.size() - 1);

                //跳过重复元素
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 sum = new CombinationSum2();
        List<List<Integer>> result = sum.combinationSum2(new int[]{2, 3, 6, 7}, 7);
        Utils.printList(result);

        result = sum.combinationSum2(new int[]{2, 6, 7}, 7);
        Utils.printList(result);

        result = sum.combinationSum2(new int[]{2, 6, 7}, 10);
        Utils.printList(result);

        result = sum.combinationSum2(new int[]{8, 7, 4, 3}, 11);
        Utils.printList(result);

        result = sum.combinationSum2(new int[]{4, 2, 8}, 8);
        Utils.printList(result);

        result = sum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        Utils.printList(result);
    }
}
