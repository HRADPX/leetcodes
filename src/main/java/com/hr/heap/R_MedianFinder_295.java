package com.hr.heap;

import java.util.PriorityQueue;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-05
 */
public class R_MedianFinder_295 {

    private final PriorityQueue<Integer> minHeap;  // 小顶堆，存储较大的一半
    private final PriorityQueue<Integer> maxHeap;  // 大顶堆，存储较小的一半

    public R_MedianFinder_295() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((x, y) -> y - x);
    }

    // 5 2 4 3 1 6
    public void addNum(int num) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.add(num);
            while (maxHeap.size() + 1 < minHeap.size())
                maxHeap.add(minHeap.poll());

        } else {
            maxHeap.add(num);
            while (minHeap.size() < maxHeap.size())
                maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() != minHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
