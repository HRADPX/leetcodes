package com.hr.top100;

import java.util.ArrayList;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij"，每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少
 */
public class R_PartitionLabels_763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int[] array = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++)
            array[chars[i] - 'a'] = i;
        int max = 0;
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            max = Math.max(array[chars[i] - 'a'], max);
            if (max == i) {
                res.add(i - pre + 1);
                pre = max + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        R_PartitionLabels_763 instance = ReflectUtils.getInstance(R_PartitionLabels_763.class);
        System.out.println(instance.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
