package com.hr.nums;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-20
 *
 * 区间加减，典型的差分思想，在连续 k 个区间的子数组只能减1，如 [2,2,3,1,1,0], k = 3,其差分数组为 [2,0,1,-2,0,-1],
 * 如果要想让第1个位置的数减少到 0，那么以 0 为开始的子数组必须被选择 nums[i] 次，即 nums[0] 必须选
 * 2 次，即差分数组 d[0] - 2，d[3] += 2，所以从开始遍历差分数组，依次执行上述操作，如果发现 i 位置作为开始，d[i] < 0,
 * 则不能完成（因为要求只能减不能加），直到遍历到最后一组，遍历完成后，如果差分数组还有不为 0 的，表示不能满足，反之则可以
 */
public class CheckArray_2772 {

    public boolean checkArray(int[] nums, int k) {

        int[] d = new int[nums.length + 1];
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            d[i] = nums[i] - nums[i - 1];

        for (int i = 0; i <= nums.length - k; i++) {
            if (d[i] < 0) return false;  // 要求只能减不能加
            d[i + k] += d[i];
            d[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (d[i] != 0) return false;
        }
        return true;
    }
}
