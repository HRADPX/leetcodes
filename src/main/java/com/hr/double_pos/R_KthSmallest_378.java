package com.hr.double_pos;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-08
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 1  5  9
 * 10 11 13
 * 12 13 15
 */
public class R_KthSmallest_378 {

    // 与排序 K 个链表实现逻辑相似
    // 维护一个小顶堆
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            pq.add(new int[] {matrix[i][0], i, 0});  // 第一记录数，第二个记录第几个数组，第三个记录是当前数组的第几个数字
        }

        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[] {matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    // 二分
    public int kthSmallestV1(int[][] matrix, int k) {
        int n = matrix.length, min = matrix[0][0], max = matrix[n - 1][n - 1];

        while (min < max) {
            int mid = (min + max) >>> 1;
            if (this.check(matrix, mid, k, n))
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }

    // * 1  5  9
    // * 10 11 13
    // * 12 13 15
    // mid = 8
    private boolean check(int[][] matrix, int mid, int k, int n) {

        int i = n - 1, j = 0, count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else
                i--;
        }
        return count >= k;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(ReflectUtils.getInstance(R_KthSmallest_378.class).kthSmallest(matrix, 8));
    }
}