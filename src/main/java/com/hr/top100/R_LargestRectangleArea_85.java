package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 *
 * 思路：如果以 i 处的值作为高，需要找到 i 左右两侧第一个小于 height[i] 的位置，
 * 这类在一维数组中找到小于或大于某个数的问题，适用于单调栈。
 *
 * 相似题
 *   42、739、496、316、901、402、581。
 */
public class R_LargestRectangleArea_85 {

    // 2,1,5,6,2,3
    // 3,4,5
    public int largestRectangleArea(int[] heights) {

        //单调栈 遍历原数组，枚举每个元素，
        //元素比栈顶元素大，加入栈中；
        //元素比栈顶元素小，栈顶元素出栈，计算以栈顶元素为高度的矩形面积


        // 在一维数组中找到左右两边第一个比自己小的数，以自己为高的面积

        int[] stack = new int[heights.length + 1];
        int top = -1, max = 0; stack[++top] = -1;

        for (int i = 0; i < heights.length; i++) {
            while (top != 0 && heights[stack[top]] >= heights[i])
                // 这里为什么 --top？因为这里是以 height[stack[top]] 为高，是需要左右两边的位置
                // 右边界很容易确定就是 i - 1, 左边界是 [stack[top]] 左边的，即 stack[--top]
                //  [5,4,1,2]
                max = Math.max(max, heights[stack[top]] * (i - stack[--top] - 1));
            stack[++top] = i;
        }

        while (top != 0)
            max = Math.max(max, heights[stack[top]] * (heights.length - 1 - stack[--top]));
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {5,4,1,2};
//        int[] nums = {2,1,5,6,2,3};
        R_LargestRectangleArea_85 instance = ReflectUtils.getInstance(R_LargestRectangleArea_85.class);
        System.out.println(instance.largestRectangleArea(nums));
    }
}
