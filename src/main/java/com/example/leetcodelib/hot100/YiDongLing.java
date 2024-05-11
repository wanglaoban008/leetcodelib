package com.example.leetcodelib.hot100;

import com.alibaba.fastjson.JSON;

/**
 * @Auther: malili008
 * @Date: 2024/5/10 14:00
 * @Description: 移动零
 */
public class YiDongLing {

    /**
     * @Author malili
     * @Description
     * 遍历一遍找到所有不是0的，第一次找到那他的角标就是0，找到第二个角标+1
     * 然后遍历一遍不是0的角标最大的到数组的长度这个区间的数值全部设置为0
     * @Date 14:09 2024/5/11
     * @Param
     * @return
     **/
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.err.println("nums: " + JSON.toJSONString(nums));

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
    }


}
