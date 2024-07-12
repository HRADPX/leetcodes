package com.hr.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-26
 */
public class WordBreakII_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int max = 0;
        for (String s1 : wordDict) max = Math.max(max, s1.length());
        return wordBreak(cs, 0, max, map, wordDict);
    }

    // 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    //输出:["cats and dog","cat sand dog"]
    private List<String> wordBreak(char[] cs, int idx, int max, Map<Integer, List<String>> map, List<String> wordDict) {

        if (idx == cs.length) return Collections.singletonList("");
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        List<String> res = new ArrayList<>();
        for (int i = idx; i < cs.length && i - idx + 1 <= max; i++) {
            String s = new String(cs, idx, i - idx + 1);
            if (!wordDict.contains(s)) continue;
            for (String ss : this.wordBreak(cs, i + 1, max, map, wordDict)) {
                if (ss.equals("")) {
                    res.add(s);
                } else {
                    res.add(s + " " + ss);
                }
            }
        }
        map.put(idx, res);
        return res;
    }


    public List<String> wordBreakV1(String s, List<String> wordDict) {

        // s and wordDict is not empty
        Set<String> set = new HashSet<>(wordDict);
        int max = 0;
        for(String ss : wordDict) max = Math.max(max,ss.length());
        HashMap<String,List<String>> cache = new HashMap<>();
        return wordBreak(s,set,cache,max);
    }

    private List<String> wordBreak(String s, Set<String> set,HashMap<String,List<String>> cache,int max){

        if(cache.containsKey(s)) return cache.get(s);
        List<String> ans = new ArrayList<>();
        if(set.contains(s)) ans.add(s);
        for(int i = 0; i < s.length() && i < max; i++){
            String cur = s.substring(0,i + 1);
            if(!set.contains(cur)) continue;
            List<String> list = wordBreak(s.substring(i + 1,s.length()),set,cache,max);
            for(String string : list){
                ans.add(cur + ' ' + string);
            }
        }
        cache.put(s,ans);
        return ans;
    }

    public static void main(String[] args) {

        List<String> wordDict = Arrays.asList("apple","pen","applepen","pine","pineapple");
        WordBreakII_140 instance = ReflectUtils.getInstance(WordBreakII_140.class);
        System.out.println(instance.wordBreakV1("pineapplepenapple", wordDict));
    }
}
