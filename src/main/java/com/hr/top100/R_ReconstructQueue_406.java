package com.hr.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 *
 *
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * 示例 1：
 *
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 排序：sorted = [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 */
public class R_ReconstructQueue_406 {

    public int[][] reconstructQueue(int[][] people) {
        if(people.length <= 1) return people;
        // 高个子站哪都可以，但是矮个子的必须要主动选择位置，不然会被高个子挡住...
        Arrays.sort(people,(a,b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<int[]> list = new ArrayList<>();
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        for(int[] p : people) list.add(p[1], p);
        return list.toArray(new int[people.length][0]);
    }

    public int[][] reconstructQueue2(int[][] people) {
        if(people.length <= 1) return people;
        // 高个子站哪都可以，但是矮个子的必须要主动选择位置，不然会被高个子挡住...
        Arrays.sort(people,(a,b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();

        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][0]);
    }
}
