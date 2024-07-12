package com.hr.dp;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-08
 */
public class CanCompleteCircuit_134 {

    // 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    // 输出: 3
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0, cur = 0, pos = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            cur += (gas[i] - cost[i]);

            if (cur < 0) {
                cur = 0;
                pos = i + 1;
            }
        }
        return sum >= 0 ? pos : -1;
    }

    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        CanCompleteCircuit_134 instance = ReflectUtils.getInstance(CanCompleteCircuit_134.class);
        System.out.println(instance.canCompleteCircuit(gas, cost));
    }
}
