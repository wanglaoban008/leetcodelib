package com.example.leetcodelib.aa;

import java.util.Arrays;

/**
 * @Auther: malili008
 * @Date: 2024/3/4 14:28
 * @Description:
 */
public class HebingShuzu {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int count = removeElement(nums, val);
        System.err.println("count: " + count);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
            }
        }
        return count;
    }
}
