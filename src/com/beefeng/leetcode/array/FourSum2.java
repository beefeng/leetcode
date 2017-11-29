package com.beefeng.leetcode.array;

import java.util.HashMap;

public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                int sum = A[i] + B[i1];
                countMap.put(sum, countMap.containsKey(sum) ? countMap.get(sum) + 1 : 1);
            }
        }


        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                int sum = C[i] + D[i1];
                int newTar = 0 - sum;
                if(countMap.containsKey(newTar)) {
                    count += countMap.get(newTar);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        int result = 0;

        FourSum2 forFourSum2 = new FourSum2();
        result = forFourSum2.fourSumCount(A, B, C, D);
        System.out.println(result);


        long start = System.currentTimeMillis();
        A = new int[]{-12,-29,-27,-20,-2,-21,9,-30,10,-21,9,4,-31,-24,0,-22,-11,-18,-14,-26,-27,-30,-8,-14,-21,2,-8,-18,3,-1,-28,9,9,-30,-6,1,-10,7,0,-26,10,-7,6,7,-2,5,-28,-1,-32,-26,-16,-17,-12,0,-3,-7,-24,-28,-11,5,-25,-3,6,-14,-17,7,-7,-30,4,-32,-5,-18,-13,-5,0,-6,-9,2,2,-20,-18,-17,3,-16,-28,-21,2,-30,3,-17,-24,-21,-31,-1,-21,-26,-5,-17,-1,3};
        B = new int[]{8,-14,-15,-11,-3,-11,-23,2,-3,-9,-23,-29,-26,-12,-5,-20,-9,-32,-30,-17,-3,-30,-28,-14,-20,-8,-12,1,-29,-30,-12,-21,-24,-13,2,3,-6,2,-8,-3,-12,7,-14,0,-15,-2,10,-14,-4,2,-27,-15,-13,-22,-27,3,3,-26,-6,-32,-25,-30,-13,-16,-1,-11,-17,-27,0,-4,7,6,-5,-18,9,6,-16,-32,3,8,1,-11,-3,-12,-1,10,-22,-4,-31,4,-23,10,2,-18,-12,10,-25,-14,-17,-23};
        C = new int[]{-8,-15,-5,-3,-3,-17,7,2,-11,-13,9,-29,-27,-12,-6,-18,-14,-10,-20,0,10,3,9,-17,-24,-1,-12,-21,-11,-26,8,-19,-25,2,9,10,-4,1,0,-2,-20,6,-29,-30,-1,7,-31,-14,-2,-7,-31,-18,-3,-17,-26,-27,-9,-25,-20,-3,-24,2,-32,4,10,-5,-22,-23,3,-4,-30,-25,5,-16,0,-7,-11,7,-8,-12,-1,-17,-27,0,-19,1,-30,-5,0,-15,-3,2,0,-20,-16,5,-13,0,-4,-22};
        D = new int[]{-15,-2,-18,-19,6,-11,-1,-28,-1,-12,-14,-31,-28,0,-15,-15,-21,-29,8,-13,-12,5,2,8,-16,-8,8,-16,-26,5,-11,-17,6,-3,-32,-31,-6,-26,9,-23,1,-20,-17,2,-17,-7,-31,1,-16,-3,-20,-21,-12,-16,-9,-12,-29,-5,0,-20,6,4,-16,-15,-26,-14,-21,-7,-26,-4,-28,-22,9,-19,-12,-32,7,-30,-28,-23,-16,-32,-14,-22,-32,-4,0,-6,-7,-20,-17,9,-24,2,-10,5,-8,-7,6,-5};
        result = forFourSum2.fourSumCount(A, B, C, D);
        System.out.println(result);
        System.out.println(String.format("cost: %d", System.currentTimeMillis() - start));

        A = new int[]{-1, -1};
        B = new int[]{-1, 1};
        C = new int[]{-1, 1};
        D = new int[]{1, -1};
        result = forFourSum2.fourSumCount(A, B, C, D);
        System.out.println(result);

    }
}
