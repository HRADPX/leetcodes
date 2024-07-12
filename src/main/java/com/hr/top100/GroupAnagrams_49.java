package com.hr.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-27
 *
 * 异位词
 */
public class GroupAnagrams_49 {

    /**
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String ss : strs) {
            int[] count = new int[26];
            for (char c : ss.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int c : count) sb.append(c).append("_");
            String key = sb.toString();
            System.out.println(key);
            map.computeIfAbsent(key, v -> new ArrayList<>()).add(ss);
        }
        for (String key : map.keySet()) res.add(map.get(key));
        return res;
    }

    public static void main(String[] args) {

        String[] rs = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(rs));
    }
}
