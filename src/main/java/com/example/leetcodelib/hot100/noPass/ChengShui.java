package com.example.leetcodelib.hot100.noPass;

/**
 * @Author malili
 * @Description
 * @Date 13:49 2024/5/11
 * @Param 盛最多水的容器
 * @return
 **/
public class ChengShui {

    /**
     * @Author malili
     * @Description  做这道题，需要知道的是，高度越高，那么算出来的面积越大。
     * 所以，拿首位的位点，指针一起往中间走，左右的值谁小谁就移动指针，这样就能获取到最大的面积。
     * 比如1，2这两个值最大，1和最后一位相比，最后一位肯定小，最终末尾指针一直在往前移动，最后移动到2，然后算12的乘积，最终拿到最大面积。
     *
     * @Date 13:55 2024/5/11
     * @Param
     * @return
     **/
    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
        while (leftIndex != rightIndex) {
            if (height[leftIndex] >= height[rightIndex]) {
                rightIndex = rightIndex - 1;
                int aa = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
                result = Math.max(result, aa);
            }
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex = leftIndex + 1;
                int aa = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
                result = Math.max(result, aa);
            }
        }
        return result;
    }
    //public static int maxArea(int[] height) {
    //    int result = 0;
    //    for (int i = 0; i < height.length; i++) {
    //        for (int j = i + 1; j < height.length; j++) {
    //            int index = j - i;
    //            int min = Math.min(height[i], height[j]);
    //            int sum = index * min;
    //            if (sum > result) {
    //                result = sum;
    //            }
    //        }
    //    }
    //    return result;
    //}




    public static void main(String[] args) {
        int height[] = new int[]{1,8, 100, 2, 5, 100, 8, 3, 7};
        int result = maxArea(height);
        System.err.println("result: " + result);
    }
}
