package com.hr.nums;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-20
 */
public class CorpFlightBookings_1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] d = new int[n + 2];

        for (int[] booking : bookings) {
            int from = booking[0], to = booking[1], num = booking[2];
            d[from] += num;
            d[to + 1] -= num;
        }
        int[] res = new int[n];
        int sum = 0;
        for (int i = 1; i < d.length - 1; i++) {
            sum += d[i];
            res[i - 1] = sum;
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        CorpFlightBookings_1109 instance = ReflectUtils.getInstance(CorpFlightBookings_1109.class);
        System.out.println(Arrays.toString(instance.corpFlightBookings(bookings, 5)));
    }
}
