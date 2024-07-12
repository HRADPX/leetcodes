package com.hr.top100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-26
 */
public class R_MaxSlidingWindow_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 单调栈
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 递减...
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }

    /**
     * 左右扫描
     */
    public int[] maxSlidingWindowV1(int[] nums, int k) {

        if (nums.length < k || k <= 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length - k + 1];
        left[0] = nums[0]; right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {

            if ((i % k) == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i - 1], nums[i]);

            int j = nums.length - 1 - i;
            if ((j + 1) % k == 0) right[j] = nums[i];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i <= nums.length - k; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        R_MaxSlidingWindow_239 instance = ReflectUtils.getInstance(R_MaxSlidingWindow_239.class);
        int[] res = instance.maxSlidingWindowV1(nums, 3);
        System.out.println(Arrays.toString(res));

    }
}
