package com.hr.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ArrayUtils;
import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class Merge_56 {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);

        List<int[]> res = new ArrayList<>(intervals.length);
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] interval = res.get(res.size() - 1);
            if (interval[1] >= intervals[i][1]) continue;
            if (interval[1] < intervals[i][0]) res.add(intervals[i]);
            else if (interval[1] < intervals[i][1]) interval[1] = intervals[i][1];
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }

    public static void main(String[] args) {

        int[][] nums = ArrayUtils.parse2DoubleNums("[[1,3],[3,6]");
        Merge_56 instance = ReflectUtils.getInstance(Merge_56.class);
        instance.merge(nums);
    }
}
