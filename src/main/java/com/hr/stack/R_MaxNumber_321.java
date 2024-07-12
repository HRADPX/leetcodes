package com.hr.stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 */
public class R_MaxNumber_321 {

    // 输入：nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
    // 输出：[9,8,6,5,3]
    // 示例 2：
    //
    // 输入：nums1 = [6,7], nums2 = [6,0,4], k = 5
    // 输出：[6,7,6,0,4]
    // 示例 3：
    //
    // 输入：nums1 = [3,9], nums2 = [8,9], k = 3
    // 输出：[9,8,9]
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];

        for(int i = Math.max(0,k - nums2.length); i <= Math.min(k,nums1.length); i++){

            int[] n1 = findMax(nums1,i);
            int[] n2 = findMax(nums2,k - i);
            ans = maxArray(ans,meger(n1,n2));
        }
        return ans;
    }

    private int[] findMax(int[] nums, int k){

        int[] ans = new int[k];
        int right = 0, n = nums.length;

        for(int i = 0; i < nums.length; i++){

            while(right > 0 && n - i + right > k && ans[right - 1] < nums[i]) --right;
            if(right < k) ans[right++] = nums[i];
        }
        return ans;
    }

    private int[] meger(int[] a, int[] b){

        int[] ans = new int[a.length + b.length];
        int i = 0, j = 0, right = 0;

        while(i < a.length && j < b.length){

            if(isBigger(a,b,i,j))
                ans[right++] = a[i++];
            else
                ans[right++] = b[j++];
        }
        while(i < a.length) ans[right++] = a[i++];
        while(j < b.length) ans[right++] = b[j++];
        return ans;
    }

    private boolean isBigger(int[] a, int[] b, int i, int j){

        // 9 8 7    9 8 7
        while(i < a.length && j < b.length){
            if(a[i] > b[j]) return true;
            else if(a[i] < b[j]) return false;
            else {
                ++i; ++j;
            }
        }
        if(j == b.length) return true;
        return false;
    }

    private int[] maxArray(int[] a, int[] b){

        for(int i = 0; i < a.length; i++){

            if(a[i] < b[i]) return b;
            else if(a[i] > b[i]) return a;
        }
        return a;
    }
}
