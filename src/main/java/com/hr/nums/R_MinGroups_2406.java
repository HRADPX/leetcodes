package com.hr.nums;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-20
 *
 * 差分思想，区间重叠可以看作上下车，在右区间下车，在左区间上车。
 * 需要多少个区间，可以看作有多少个区间重叠，重叠的区间就是需要分多少个组。
 * 有多少个重叠的区间？就是同一时刻在车上的最大人数。
 */
public class R_MinGroups_2406 {

    public int minGroups(int[][] intervals) {
        int[] d = new int[1000002];

        for (int[] interval : intervals) {
            d[interval[0]] += 1;
            d[interval[1] + 1] -= 1;
        }
        int sum = 0, res = 0;
        for (int num : d) {
            res = Math.max(res, sum += num);
        }
        return res;
    }
}
