package com.hr.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class R_TopKFrequent_347 {

    /**
     * O(N) 用空间换时间
     */
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) map.put(num,map.getOrDefault(num,0) + 1);
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Integer num : map.keySet()) {
            int bucket = map.get(num);
            if(buckets[bucket] == null) buckets[bucket] = new ArrayList<>();
            buckets[bucket].add(num);
        }
        for (int i = buckets.length - 1; i >= 0 && res.size() <= k; i--) {
            if (buckets[i] != null) res.addAll(buckets[i]);
        }
        while(res.size() > k)
            res.remove(res.size() - 1);
        return null;
    }

    /**
     * O(N*logN)
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        // 统计数量
        for (int num : nums)
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);

        // 小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(m -> m[1]));
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] res = ReflectUtils.getInstance(R_TopKFrequent_347.class).topKFrequent2(nums, 2);
        System.out.println(Arrays.toString(res));
    }
}
