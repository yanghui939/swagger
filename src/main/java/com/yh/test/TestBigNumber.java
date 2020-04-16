package com.yh.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestBigNumber {
    public static void main(String[] args) {
//        System.out.println(bigNumberAdd("999", "1000"));
        System.out.println(bigNumber("999", "1000"));


    }


    /**
     * 冒泡排序
     * @param arr
     */
    private static String bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {   // 这里说明为什么需要-1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return Arrays.toString(arr);
    }

    /**
     * 大数字乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static String bigNumber(String a, String b) {
        char[] large = null;
        char[] small = null;
        if (a.length() >= b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        int[] mult = new int[a.length() + b.length()];
        for (int i = small.length - 1; i >= 0; i--) {
            for (int j = large.length - 1; j >= 0; j--) {
                int num1 = small[i] - '0';
                int num2 = large[j] - '0';
                mult[large.length - 1 - i + small.length - 1 - j] += num1 * num2;
            }
        }
        for (int i = 0; i < mult.length - 1; i++) {
            if (mult[i] > 9) {
                mult[i] = mult[i] % 10;
                mult[i + 1] += mult[i] / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = mult.length - 1; i >= 0; i--) {
            stringBuilder.append(mult[i]);
        }
        String result = stringBuilder.toString();
        if (result.startsWith("0")) {
            result = result.substring(1);
        }
        return result;
    }

    /**
     * 大数字加法
     *
     * @param a
     * @param b
     * @return
     */
    public static String bigNumberAdd(String a, String b) {
        char[] large = null;
        char[] small = null;
        if (a.length() >= b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        int[] nums = new int[large.length + 1];
        for (int i = 0; i < large.length; i++) {
            nums[i] = large[large.length - i - 1] - '0';
        }
        for (int i = 0; i < small.length; i++) {
            nums[i] += small[small.length - i - 1] - '0';
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 9) {
                nums[i] = nums[i] % 10;
                nums[i + 1] += 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            stringBuilder.append(nums[i]);
        }
        String result = stringBuilder.toString();
        if (result.startsWith("0")) {
            result = result.substring(1);
        }
        return result;
    }
}
