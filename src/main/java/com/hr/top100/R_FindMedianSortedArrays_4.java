package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 算法复杂度：O(log(m+n))
 *
 * 二分思想
 *  求两个数组第 k 小的数，通过二分一次过滤掉 k/2 个数
 *
 */
public class R_FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) >> 1;
        int right = (m + n + 2) >> 1;
        return (this.getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + this.getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) / 2.0;
    }

    private int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {

        if (e1 - s1 > e2 - s2) return this.getKth(nums2, s2, e2, nums1, s1, e1, k);
        if (s1 > e1) return nums2[s2 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int idx1 = Math.min(e1, s1 - 1 + k / 2);
        int idx2 = s2 - 1 + k / 2;
        // 1 2 4 6   2, 3, 4, 6  -> k = 4
        if (nums1[idx1] < nums2[idx2])
            return this.getKth(nums1, idx1 + 1, e1, nums2, s2, e2, k - idx1 + s1 - 1);
        return this.getKth(nums1, s1, e1, nums2, idx2 + 1, e2, k - idx2 + s2 - 1);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out
                .println(ReflectUtils.getInstance(R_FindMedianSortedArrays_4.class).findMedianSortedArrays(nums1, nums2));
    }
}
