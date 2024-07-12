package com.hr.nums;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 *
 * 差分数组
 *  原数组：a = [1,3,3,5,8]
 *  差分数组：d = [1,2,0,2,3]
 * 其中 d[0] = a[0]，d[i] = a[i] - a[i - 1] (i > 0)
 *
 * 特征1：差分数组从左往右累加即可还原回原数组
 * 特征2：如下两个操作是等价的
 *   (1) 把 a 的子数组 a[i], a[i+1],...,a[j] 都加上 x
 *   (2) 把 d[i] 增加 x，将 d[j+1] 减少 x
 *
 * 对于特征2，将连续子数组 a[1],a[2],a[3] 都加上 10，得到 a'=[1,13,13,15,8]，新的差分数组 d'=[1,12,0,2,-7],
 * 对比原差分数组 d = [1,2,0,2,3]，只有 i = 1 和 i = 4 的位置发生了变化，d'[1] = d[1] + 10, d'[4] = d[4] - 10
 *
 * 本题思路：
 *  1) 设 a[i] 表示行驶到位置 i 时车上的人数，初始时 a[i] = 0，表示每个位置车上都没人，所以初始差分数组 d[i] = 0.
 *  2) trip[i] 相当于把 a 中的下标从 from(trip[i][1]) 到 to - 1(trip[i][2] - 1，这里需要减 1 是因为到 to 站乘客就下车了)
 * 都增加 trip[i][0] 个乘客，正好可以用差分数组解决。
 *  3) 得到差分数组后，从左向右累加，判断 a[i] 是否 capactity 即可。
 *
 *
 * 相似题
 * 1109. 航班预订统计 1570                done
 * 2406. 将区间分为最少组数 1713           done
 * 2381. 字母移位 II 1793                done
 * 2772. 使数组中的所有元素都等于零 2029    done
 * 2528. 最大化城市的最小供电站数目 2236
 * 2439. 最小化数组中的最大值
 * 2513. 最小化两个数组中的最大值
 * 2517. 礼盒的最大甜蜜度
 */
public class R_CarPooling_1094 {

    // 差分数组
    public boolean carPooling(int[][] trips, int capacity) {

        int[] d = new int[1001];
        for (int[] trip : trips) {
            d[trip[1]] += trip[0];
            d[trip[2]] -= trip[0];
        }
        int s = 0;
        for (int v : d) {
            s += v;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPoolingV1(int[][] trips, int capacity) {
        int[] timestamp = new int[1001]; // 使用一个数组记录每个位置上的乘客数量

        // 遍历每次旅行
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            // 在起始位置上增加乘客数量
            timestamp[start] += passengers;
            // 在终点位置上减少乘客数量
            timestamp[end] -= passengers;
        }

        int memberInCar = 0; // 记录车上成员数量

        // 遍历位置数组，计算每个位置上的乘客数量累计和
        for (int value : timestamp) {
            memberInCar += value;
            // 判断是否超过座位数量
            if (memberInCar > capacity) {
                return false;
            }
        }

        return true;
    }
}
