package com.hr.binary_search;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-02
 *
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 相似题：
 * 410. 分割数组的最大值
 * 1011. 爱吃香蕉的珂珂
 */
public class ShipWithinDays_1011 {

    // weights = [1,2,3,4,5,6,7,8,9,10], days = 5  ==> 15
    public int shipWithinDays(int[] weights, int days) {

        int low = 1, high = 0;
        // 没有正确定位最小值，导致后续判断逻辑比较复杂
        for (int weight : weights)
            high += weight;

        while (low < high) {

            int mid = (low + high) >> 1;
            int d = 1, cur = 0;
            for (int i = 0; i < weights.length; i++) {
                int weight = weights[i];
                cur += weight;
                if (cur > mid) {
                    d++;
                    cur = weight;
                } else if (cur == mid) {
                    d++;
                    cur = 0;
                }
                if (cur == 0 && i == weights.length - 1)
                    d--;
                if (d > days)
                    break;
                if (cur > mid) {  // low 应该是数组的最大值，这里就不需要判断
                    d = days + 1;
                    break;
                }
            }
            if (d > days)
                low = mid + 1; // low = 10
            else
                high = mid;
        }
        // low == high
        return high;
    }


    public int shipWithinDays_o(int[] weights, int days) {
        int right = 0;
        int left = Integer.MIN_VALUE;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {

            // 当前运输量
            int mid = (left + right) >>> 1;
            int needs = 1;
            int cur = 0;

            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++needs;
                    cur = 0;
                }
                cur += weight;

                if (needs > days) {
                    break;
                }
            }
            if (needs > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] weights = {3,3,3,3,3,3};
        ShipWithinDays_1011 instance = ReflectUtils.getInstance(ShipWithinDays_1011.class);
        System.out.println(instance.shipWithinDays(weights, 2));
    }
}
