package com.hr.nums;

import com.hr.utils.ArrayUtils;
import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-20
 */
public class ShiftingLetters_2381 {

    public String shiftingLetters(String s, int[][] shifts) {
        int[] d = new int[s.length() + 1];

        d[0] = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            d[i] = s.charAt(i) - s.charAt(i - 1);
        }
        for (int[] shift : shifts) {
            int add = shift[2] > 0 ? 1 : -1;
            d[shift[0]] += add;
            d[shift[1] + 1] -= add;
        }
        StringBuilder ss = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = ((sum + d[i]) % 26 + 26) % 26;
            ss.append((char) (sum + 'a'));
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        int[][] nums = ArrayUtils.parse2DoubleNums("[[4,8,0],[4,4,0],[2,4,0],[2,4,0],[6,7,1],[2,2,1],[0,2,1],[8,8,0],[1,3,1]]");
        ShiftingLetters_2381 instance = ReflectUtils.getInstance(ShiftingLetters_2381.class);
        System.out.println(instance.shiftingLetters("xuwdbdqik", nums));
    }
}
