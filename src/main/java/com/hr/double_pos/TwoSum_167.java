package com.hr.double_pos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class TwoSum_167 {

    public int[] twoSum(int[] numbers, int target) {

        int sum = 0;
        int low = 0, high = numbers.length - 1;

        while (low < high) {

            sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            }
            if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[] {-1, -1};
    }
}
