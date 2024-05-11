package com.example.leetcodelib.hot100;

import com.alibaba.fastjson.JSON;

/**
 * @Auther: malili008
 * @Date: 2024/4/16 13:33
 * @Description:  两数之和
 */
public class TwoNumSum {

    /**
     * @Author malili
     * @Description
     * 我觉得也可以用指针，这样就只需要遍历一次了，
     * 或者用map，遍历一次，去map中拿要添加的数值的目标值去找map的key是否包含目标值
     * @Date 14:04 2024/5/11
     * @Param
     * @return
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] sums = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    sums[0] = i;
                    sums[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 7};
        int[] sums = twoSum(nums, 9);
        System.err.println("sums: " + JSON.toJSONString(sums));

    }


}
