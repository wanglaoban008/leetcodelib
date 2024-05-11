package com.example.leetcodelib.hot100.noPass;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: malili008
 * @Date: 2024/5/11 10:43
 * @Description: 三数之和
 */
/**
 * @Author malili
 * @Description
 * @Date 13:49 2024/5/11
 * @Param  三数之和  使用指针
 * @return
 **/
public class ThreeNumSum {

    /**
     * @Author malili
     * @Description  本来要遍历三次，时间复杂度是O(N的3次方)，
     * 啥叫指针呢，就是遍历2的时候，能拿到2对应这个数组末尾往前倒腾，这样就不用再遍历2后面的数值挨个遍历去和1，2做匹配是否和=0.
     * 而是直接拿着2+最末尾值=0-1,一直循环，直到循环到了。其实就是把3的遍历转变成while循环，一直根据条件去循环。最好的指针是只进行循环，循环结束的位点的值再相加进行处理。
     * 要注意：
     * 1先排序，
     * 2遍历第一位和第一位的下一位，不遍历第三位，第三位在第二位遍历里面循环，从最后一位倒序往第二位靠近
     * 3、list要去重，因为数组排过序了，第一位，第二位相同的跳过本次循环进行下一次循环。
     *
     * @Date 13:50 2024/5/11
     * @Param
     * @return
     **/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            }
            // 因为排过序了，所以过滤第一个元素重复添加相同的数值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                // 因为排过序了，所以过滤第二个元素重复添加相同的数值
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (j < third && second + nums[third] > 0 - first) {
                    third--;
                }
                if (j == third) {
                    break;
                }
                if (first + second + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(first, second, nums[third]));
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result = threeSum(nums);
        System.err.println("result: " + JSON.toJSONString(result));

    }
}
