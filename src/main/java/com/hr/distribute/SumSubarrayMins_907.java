package com.hr.distribute;

import java.util.ArrayDeque;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-04
 */
public class SumSubarrayMins_907 {

    private static final long MOD = (long) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为 -1）
        int[] left = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for (int i = 0; i < n; ++i) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i])
                st.pop();
            left[i] = st.peek();
            st.push(i);
        }

        // 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为 n）
        int[] right = new int[n];
        st.clear();
        st.push(n); // 方便赋值 right
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 1 && arr[st.peek()] > arr[i])
                st.pop();
            right[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (ans % MOD);

    }
}
