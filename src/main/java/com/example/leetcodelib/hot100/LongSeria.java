package com.example.leetcodelib.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: malili008
 * @Date: 2024/4/17 10:01
 * @Description: 最长连续序列
 */
public class LongSeria {

    /**
     * @Author malili
     * @Description
     * 1、先排序
     * 2、用map存连续的，没加一个连续key换成最新添加的数值，value为长度，连不起来的用新的map存放，
     * 3、最后取map长度最长的值就是最长的连续
     *
     * @Date 14:02 2024/5/11
     * @Param
     * @return
     **/
    public static int longestConsecutive(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            String numStr = String.valueOf(nums[i]);
            int value = nums[i] - 1;
            String valueStr = String.valueOf(value);
            if (map.containsKey(valueStr)) {
                map.put(numStr, map.get(valueStr) + 1);
                map.remove(valueStr);
            } else {
                if (!map.containsKey(numStr)) {
                    map.put(numStr, 1);
                }
            }
        }
        int result = 0;
        if (map != null && map.size() > 0) {
            result = map.entrySet().stream().max(Comparator.comparing(integerIntegerEntry -> integerIntegerEntry.getValue())).get().getValue();
        }
        System.err.println("result: " + result);

        return result;

    }

    public static void main(String[] args) {

        int[] nums = {0,  0, -1};
        int result = longestConsecutive(nums);
        System.err.println("result: " + result);
    }
}
