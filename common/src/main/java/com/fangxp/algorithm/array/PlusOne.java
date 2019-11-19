package com.fangxp.algorithm.array;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] plusOne1 = plusOne(digits);
        for (int i = 0; i < plusOne1.length; i++) {
            System.out.println(plusOne1[i]);

        }
    }

    /**
     * 99、9
     * 犀利解法 👍
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne1(int[] digits) {

        //不需要用新数组
        int[] res = new int[digits.length];

        boolean addOne = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (addOne) {
                int temp = digit + 1;
                if (temp == 10) {
                    addOne = true;
                    res[i] = 0;
                    if (i == 0) {
                        int[] result = new int[digits.length + 1];
                        result[0] = 1;
                        //todo 无需复制  这种后面肯定都是0 只需要复制result[0] 巧妙的方法
                        for (int i1 = 1; i1 < result.length; i1++) {
                            result[i1] = res[i1 - 1];
                        }
                        return result;
                    }
                } else {
                    res[i] = temp;
                    addOne = false;
                }
            } else {
                res[i] = digit;
            }
        }
        return res;
    }

}
