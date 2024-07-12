package com.hr.utils;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-27
 */
public class SortUtils {

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    // 每轮找到最小的
    public static void selectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, i, min);
            }
        }
    }

    // 0,2,1,4,3
    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int temp = nums[j];

            while (j > 0 && nums[j - 1] > temp)  {
                nums[j] = nums[j - 1];
                --j;
            }
            nums[j] = temp;
        }
    }

    public static void heapSort(int[] nums) {

        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 大根堆
            heapify(nums, i , nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private static void heapify(int[] nums, int index, int high) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;

        if (left < high && nums[left] > nums[max])
            max = left;
        if (right < high && nums[right] > nums[max])
            max = right;
        if (max != index) {
            swap(nums, max, index);
            heapify(nums, max, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int[] temp, int low, int high) {

        if (low < high) {
            int mid = (low + high) >>> 1;
            mergeSort(nums, temp, low, mid);
            mergeSort(nums, temp, mid + 1, high);
            merge(nums, temp, low, mid, high);
        }
    }

    private static void merge(int[] nums, int[] temp, int low, int mid, int high) {

        // [low, mid] + [mid + 1, high]
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int i, j, k;
        for (i = k = low, j = mid + 1; i <= mid && j <= high; k++) {
            if (temp[i] > temp[j]) {
                nums[k++] = temp[j++];
            } else {
                nums[k++] = temp[i++];
            }
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= high) nums[k++] = temp[j++];
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSortV1(int[] nums) {
        quickSortV2(nums, 0, nums.length - 1);
    }

    public static void quickSortV3(int[] nums) {
        quickSortV3(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;

        int index = partition(nums, low, high);
        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, high);
    }

    private static void quickSortV2(int[] nums, int low, int high) {
        if (low >= high) return;

        int[] res = partitionV2(nums, low, high);
        quickSort(nums, low, res[0]);
        quickSort(nums, res[1], high);
    }

    // O(N*logN)
    private static void quickSortV3(int[] nums, int low, int high) {
        if (low >= high) return;

        int[] res = partitionV3(nums, low, high);
        quickSort(nums, low, res[0]);
        quickSort(nums, res[1], high);
    }

    // 最差 O(N*N)
    private static int partition(int[] nums, int low, int high) {
        int pivotKey = nums[high];
        int p1 = low - 1, i = low;
        while (i <= high) {
            if (nums[i] <= pivotKey)
                swap(nums, ++p1, i);
            ++i;
        }
        return p1;
    }


    public int[] getNext(char[] cs) {

        if (cs.length == 0) return new int[0];
        int[] next = new int[cs.length];

        int value = -1, i = 0;

        while (i < cs.length - 1) {
            if (value == -1 || cs[i] == cs[value])
                next[++i] = ++value;
            else
                value = next[value];
        }
        return next;
    }
    private static int[] partitionV2(int[] nums, int low, int high) {
        int pivotKey = nums[high];
        int p1 = low - 1, p2 = high + 1, i = low;

        while (i < p2) {
            if (nums[i] <= pivotKey)
                swap(nums, ++p1, i++);
            else if (nums[i] == pivotKey)
                ++i;
            else
                swap(nums, i, --p2);
        }
        return new int[] {p1, p2};
    }

    // [<pivotKey][=pivotKey][>pivotKey]
    //          p1           p2
    private static int[] partitionV3(int[] nums, int low, int high) {
        // 随机选择
        int pivotKey = nums[(int) (Math.random() * (high - low + 1)) + low];
        int p1 = low - 1, p2 = high + 1, i = low;

        while (i < p2) {
            if (nums[i] < pivotKey)
                swap(nums, ++p1, i++);
            else if (nums[i] == pivotKey)
                ++i;
            else
                swap(nums, i, --p2);
        }
        return new int[] {p1, p2};
    }

    private static void swap(int[] arrays, int i, int j) {

        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    // 荷兰旗问题，将数据分为三个部分，左边是小于 base，中间等于 base，右边大于 base
    public static int[] dutchNationalFlag(int[] nums, int base) {
        int p1 = -1, p2 = nums.length, i = 0;
        while (i < p2) {
            if (nums[i] < base)
                swap(nums, ++p1, i++);
            else if (nums[i] == base)
                ++i;
            else
                swap(nums, --p2, i);
        }
        return new int[] {p1, p2};
    }
}
