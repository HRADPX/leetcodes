package com.hr.top100;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-26
 */
public class R_ProductExceptSelf_238 {

    // 不要除法
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int base = 1;

        for (int i = 0; i < res.length; i++){
            res[i] = base;
            base *= nums[i];
        }
        base = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= base;
            base *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        R_ProductExceptSelf_238 instance = ReflectUtils.getInstance(R_ProductExceptSelf_238.class);
        System.out.println(Arrays.toString(instance.productExceptSelf(nums)));
    }
}
