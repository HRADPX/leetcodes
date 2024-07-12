package com.hr.double_pos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-12
 *
 * 给一个非递减数组，返回每个数字的平方，也结果也需要排序
 * [-4,-1,0,3,10] ==> [0,1,9,16,100]
 */
public class SortedSquares_977 {

    public int[] sortedSquares(int[] nums) {

        int low = 0, high = nums.length - 1, k = nums.length - 1;
        int[] res = new int[nums.length];

        while (low <= high) {

            if (Math.abs(nums[high]) > Math.abs(nums[low]))
                res[k--] = (int) Math.pow(nums[high--], 2);
            else
                res[k--] = (int) Math.pow(nums[low++], 2);
        }
        return res;
    }
}
