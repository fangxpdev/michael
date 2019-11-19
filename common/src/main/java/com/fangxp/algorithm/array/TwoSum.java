package com.fangxp.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{10, 2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum1(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        int[] ints1 = twoSum2(nums, target);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    /**
     * 方案1
     * O(n²)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (a + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        return result;
    }


    /**
     * O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap(8);
        for (int i = 0; i < nums.length; i++) {

            int dif = target - nums[i];
            if (map.containsKey(dif)) {
                return new int[]{i, map.get(dif)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
